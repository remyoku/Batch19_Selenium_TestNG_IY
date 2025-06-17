package com.eurotech.tests.day_03_WebElementIntro;

import com.eurotech.utilities.WebDriverFactory;
import com.mifmif.common.regex.Main;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C03_VerifyUserNameIsCorrect {
    public static void main(String[] args) throws InterruptedException {
        /**
         * Task
         * open chrome browser
         * go to "https://demoqa.com/login"
         * enter "test" into the username box
         * VERIFY that "test" is displayed in the username box
         * enter "Test.!123" into the password box
         * click on login button
         * VERIFY that username is "test"
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/login");

        String exceptedText = "test";
        WebElement userNameBox = driver.findElement(By.id("userName"));
        userNameBox.sendKeys("test");

        Thread.sleep(1000);

        //getAttribute() bize seçili elementin attributleri hakkında bilgi verir.
        //eğer sendKeys() söz konusuysa, gönderilen değeri verir.

        String actualText = userNameBox.getAttribute("value");
        System.out.println("actualText = " + actualText);

        System.out.println("userNameBox.getAttribute(\"id\") = " + userNameBox.getAttribute("id"));
        System.out.println("userNameBox.getAttribute(\"type\") = " + userNameBox.getAttribute("type"));
        System.out.println("userNameBox.getAttribute(\"placeholder\") = " + userNameBox.getAttribute("placeholder"));
        System.out.println("userNameBox.getAttribute(\"class\") = " + userNameBox.getAttribute("class"));


        if (actualText.equals(exceptedText)) {
            System.out.println("pass");
        } else {
            System.out.println("faill");
        }
        WebElement passwordBox = driver.findElement(By.cssSelector("[placeholder=\"Password\"]"));

        passwordBox.sendKeys("Test.!123");

        WebElement element = driver.findElement(By.id("login"));

        //click on login button through click() method

        element.click();

        Thread.sleep(3000);

        //locate username value
        WebElement userNameText = driver.findElement(By.id("userName-value"));

        String actualUserNameText = userNameText.getText();
        String exceptedUserNameText = "test";

        if (actualUserNameText.equals(exceptedUserNameText)) {
            System.out.println("pass");
        } else {
            System.out.println("faill");
        }
        driver.close();
    }
}
