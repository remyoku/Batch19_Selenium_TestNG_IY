package com.eurotech.tests.day_05_06_xPath;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C03_RelativeXpath_Contains_StartWith {
    public static void main(String[] args) {

        /**
         * Task
         * open chrome browser
         * go to http://www.eurotech.study/
         * click I understand button and accept cookies (use xPath-contains text)
         * locate login button (use xPath - known attribute (class) )
         * click login button
         * locate email address input box (use xPath -starts-with (id))
         * send "abc" into email address input box
         * locate second login button (use xPath - * -> use star in xPath formula )
         * click Login button
         * get the message which appears on the email input box and print the message
         * VERIFY that the message contains "Please include an '@' in the email address."
         * close browser.
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://www.eurotech.study/");

        driver.findElement(By.xpath("//button[contains(text(),'I understand')]")).click();

        WebElement loginBtn = driver.findElement(By.xpath("//a[@class='btn btn-light']"));
        loginBtn.click();

        WebElement emailBox = driver.findElement(By.xpath("//input[starts-with(@id,'loginpage-i')]"));
        emailBox.sendKeys("abc");

        WebElement secondLogin = driver.findElement(By.xpath("//*[@*='Login']"));
        secondLogin.click();

        String actualMessage = emailBox.getAttribute("validationMessage");
        String exceptedMessage = "Lütfen e-posta adresine bir \"@\" işareti ekleyin. \"abc\" adresinde \"@\" eksik.";

        if (actualMessage.equals(exceptedMessage)){
            System.out.println("Pass");
        }else {
            System.out.println("Failll");
        }

        driver.close();


    }
}
