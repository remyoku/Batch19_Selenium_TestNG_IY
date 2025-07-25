package com.eurotech.tests.day_05_06_xPath;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C06_RelativeXpath {
    public static void main(String[] args) throws InterruptedException {
        /**
         * class task
         * open chrome browser and go to http://www.eurotech.study/
         * click I understand button and accept cookies (by xPath with contains (attribute))
         * locate sign up by xPath with contains (text)
         * click Sign Up
         * locate Name input box by xPath (starts with) and send to box "Ahmet"
         * locate email input box by xPath (more than one attribute) and send the box "aaa@aaa.com"
         * locate password input box by xPath (more than one attribute with "and") and type in "123456"
         * locate confirm password input box by xPath (more than one attribute with "or") and type in "123456"
         * locate Sign In link by xPath (with index) --- use only tag
         * click Sign In link
         * close browser
         *
         */

        //open chrome browser and go to http://www.eurotech.study/
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://www.eurotech.study/");
        Thread.sleep(2000);

        //click I understand button and accept cookies (by xPath with contains (attribute))
        driver.findElement(By.xpath("//button[contains(text(),'I understand')]")).click();
        Thread.sleep(2000);

        //locate sign up by xPath with contains (text)
        // click Sign Up
        WebElement signUpBtn = driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]"));
        signUpBtn.click();
        Thread.sleep(2000);

        //locate Name input box by xPath (starts with) and send to box "Ahmet"
        WebElement nameInputBox = driver.findElement(By.xpath("//input[starts-with(@name,'nam')]"));
        nameInputBox.sendKeys("Ahmet");
        Thread.sleep(2000);

        //locate email input box by xPath (more than one attribute) and send the box "aaa@aaa.com"
        WebElement emailBox = driver.findElement(By.xpath("//input[@type='email' and @placeholder='Email Address' ]"));
        emailBox.sendKeys("aaa@aaa.com");
        Thread.sleep(2000);

        //locate password input box by xPath (more than one attribute with "and") and type in "123456"
        WebElement passwordBox = driver.findElement(By.xpath("//input[@id='signuppage-form-pw1-input'][@name='password' ]"));
        passwordBox.sendKeys("123456");
        Thread.sleep(2000);

        //locate confirm password input box by xPath (more than one attribute with "or") and type in "123456"
        WebElement passwordConfirmBox = driver.findElement(By.xpath("//input[@name='password2' or @placeholder='Confirm Password']"));
        passwordConfirmBox.sendKeys("123456");
        Thread.sleep(2000);

        //locate Sign In link by xPath (with index) --- use only tag
        //click Sign In link
        WebElement signInLink = driver.findElement(By.xpath("(//a)[2]"));
        signInLink.click();
        Thread.sleep(2000);

        //close browser
        driver.quit();


    }
}
