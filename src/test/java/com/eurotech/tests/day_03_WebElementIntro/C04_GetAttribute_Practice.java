package com.eurotech.tests.day_03_WebElementIntro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C04_GetAttribute_Practice {
    public static void main(String[] args) throws InterruptedException {
       /**
        * Task
        * open chrome browser
        * go to http://www.eurotech.study/
        * click I understand button and accept cookies
        * take the value of the attributes (class and href) of the login button and print the values.
        * click login button
        * send "sdfsdsd" into email address input box
        * click Login button
        * get the message which appears on the email input box
        * VERIFY that the message contains "Please include an '@' in the email address."
        */


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://www.eurotech.study/");

        Thread.sleep(1000);
        WebElement cookies = driver.findElement(By.id("rcc-confirm-button"));
        cookies.click();

        Thread.sleep(1000);

        //locate login button
        WebElement loginBtn = driver.findElement(By.cssSelector("[class='btn btn-light']"));

        //prşnt attribute values

        System.out.println("loginBtn class value = " + loginBtn.getAttribute("class"));
        System.out.println("loginBtn href value= " + loginBtn.getAttribute("href"));

        //click login button
        loginBtn.click();


        Thread.sleep(3000);

        //locate emailText box
        WebElement emailTextBox = driver.findElement(By.id("loginpage-input-email"));
        emailTextBox.sendKeys("sdfsdsd");

        //locate
        WebElement userLoginBtn = driver.findElement(By.id("loginpage-form-btn"));
        userLoginBtn.click();

        //email hata mesajını alma(JavaScript mesajı)
        String validationMessage = emailTextBox.getAttribute("validationMessage");
        System.out.println("validationMessage = " + validationMessage);

        String exceptedMessage ="Lütfen e-posta adresine bir \"@\" işareti ekleyin. \"sdfsdsd\" adresinde \"@\" eksik.";

        if (validationMessage.equals(exceptedMessage)){
            System.out.println("pass");
        }else {
            System.out.println("fail");
        }
        driver.close();


    }
}
