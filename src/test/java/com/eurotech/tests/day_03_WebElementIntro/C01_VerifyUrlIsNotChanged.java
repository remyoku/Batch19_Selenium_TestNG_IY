package com.eurotech.tests.day_03_WebElementIntro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_VerifyUrlIsNotChanged {
    public static void main(String[] args) throws InterruptedException {
        /**
         * Task
         * open chrome browser
         * go to https://demoqa.com/login
         * click on login button
         * VERIFY that url is not changed
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //driver.navigate().to("https://demoqa.com/login");
        driver.get("https://demoqa.com/login");

        Thread.sleep(5000);

        //expected url i kaydedelim

        String exceptedUrl = driver.getCurrentUrl();
        System.out.println("exceptedUrl = " + exceptedUrl);

        //locate login button and put it in a webElement bucket

        WebElement element = driver.findElement(By.id("login"));

        //click on login button through click() method

        element.click();

        //actual url i kaydedeilim

        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(exceptedUrl)){
            System.out.println("pass");
        }else {
            System.out.println("fail");
        }
        driver.close();

    }
}
