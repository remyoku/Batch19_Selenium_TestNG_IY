package com.eurotech.tests.day_04_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C08_BasicLocatorReview {
    public static void main(String[] args) throws InterruptedException {
        /**
         * Task
         * open a chrome browser driver and navigate to https://www.demoblaze.com/
         * locate Sign up link by using id and get text of web element then print the text
         * locate BOTH OF previous and next link at the bottom of the page by using name and get text of web element then print the text
         * locate Samsung Galaxy S6 by using tagname and get text of web element then print the text
         * locate Product Store at the left top of the page by using class name and get text of web element then print the text
         * locate Nokia Lumia 1520 by using link text and get text of web element then print the text
         * locate Nexus 6 by using partial link text and get text of web element then print the text
         * close the driver
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.demoblaze.com/");

        Thread.sleep(2000);


        //locate Sign up link by using id and get text of web element then print the text
        WebElement singUp = driver.findElement(By.id("signin2"));
        String singUpText = singUp.getText();
        System.out.println("singUpText = " + singUpText);

        //locate BOTH OF previous and next link at the bottom of the page by using name and get text of web element then print the text

       // driver.findElement(By.name("")) name yok

        // * locate Samsung Galaxy S6 by using tagname and get text of web element then print the text

        WebElement galaxyS6 = driver.findElement(By.tagName("a"));
        String galaxyS6Text = galaxyS6.getText();
        System.out.println("galaxyS6Text = " + galaxyS6Text);


        // locate Product Store at the left top of the page by using class name and get text of web element then print the text

        WebElement productStore = driver.findElement(By.className("navbar-brand"));
        String productStoreText = productStore.getText();
        System.out.println("productStoreText = " + productStoreText);

        //locate Nokia Lumia 1520 by using link text and get text of web element then print the text
        WebElement lumia = driver.findElement(By.linkText("Nokia lumia 1520"));
        String lumiaText = lumia.getText();
        System.out.println("lumiaText = " + lumiaText);

        //locate Nexus 6 by using partial link text and get text of web element then print the text
        WebElement nexus_ = driver.findElement(By.partialLinkText("Nexus "));
        String nexus_text = nexus_.getText();
        System.out.println("nexus_text = " + nexus_text);

        //close the driver

        Thread.sleep(1000);
        driver.close();


    }
}
