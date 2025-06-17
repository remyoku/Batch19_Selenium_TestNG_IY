package com.eurotech.tests.day_03_WebElementIntro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C02_VerifyUrlIsChanged {
    public static void main(String[] args) throws InterruptedException {
        /**
         * Task
         * open chrome browser
         * go to "https://demoqa.com/login"
         * enter "test" into the username box
         * enter "Test.!123" into the password box
         * click on login button
         * VERIFY that url is changed as "https://demoqa.com/profile"
         */
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/login");
        Thread.sleep(2000);

        //locate userNameBox
        WebElement userNameBox = driver.findElement(By.id("userName"));

        //send value to usernameBox
        userNameBox.sendKeys("test");

        Thread.sleep(3000);
        //locate password
       // driver.findElement(By.id("password"));
        WebElement passwordBox = driver.findElement(By.cssSelector("[placeholder=\"Password\"]"));

        passwordBox.sendKeys("Test.!123");

        WebElement element = driver.findElement(By.id("login"));

        //click on login button through click() method

        element.click();
        System.out.println("URL " + driver.getCurrentUrl());

        Thread.sleep(3000);

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://demoqa.com/profile";

        if (actualUrl.equals(expectedUrl)){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }
        driver.close();

    }






}
