package com.eurotech.tests.day_04_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C05_ByTagName {
    public static void main(String[] args) throws InterruptedException {

        /**
         * open chrome browser and navigate to http://www.eurotech.study/
         * accept cookies if any
         * locate Copyright web element at the footer of the web page by using tag name locator
         * get the text of web element and print it
         * close driver.
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://www.eurotech.study/");

        Thread.sleep(2000);

        //accept cookies if any lazy way
        driver.findElement(By.id("rcc-confirm-button")).click();

        //locate Copyright web element at the footer of the web page by using tag name locator
        WebElement copyRightWebElement = driver.findElement(By.tagName("small"));

        String text = copyRightWebElement.getText();

        System.out.println("text = " + text);

        driver.close();
    }
}
