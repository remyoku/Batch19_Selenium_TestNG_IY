package com.eurotech.tests.day_09_TypeOfWebElements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class C04_isDisplayedDemo {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("edge");

    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
    @Test
    public void displayed_Test() throws InterruptedException {

        /**
         * navigate to https://the-internet.herokuapp.com/dynamic_loading
         * click the first link (Example 1: Element on page that is hidden)
         * locate start button and "Hello World!" text element
         * verify that Hello World! is NOT displayed
         * click start button
         * wait 5 seconds
         * verify that Hello World! is now displayed
         * take the text of element and print it
         */

        driver.get("https://the-internet.herokuapp.com/dynamic_loading");
        Thread.sleep(1000);

        //click the first link (Example 1: Element on page that is hidden)
        driver.findElement(By.partialLinkText("Example 1")).click();
        Thread.sleep(1000);

        // locate start button and "Hello World!" text element
        WebElement startButton = driver.findElement(By.xpath("//button"));
        WebElement helloWorldText = driver.findElement(By.xpath("//h4[text()='Hello World!']"));

        //verify that Hello World! is NOT displayed
        Assert.assertTrue(startButton.isDisplayed());
        Assert.assertFalse(helloWorldText.isDisplayed());

        // wait 5 seconds
        startButton.click();
        Thread.sleep(5000);

        // verify that Hello World! is now displayed
        // take the text of element and print it
        Assert.assertTrue(helloWorldText.isDisplayed());
        System.out.println(helloWorldText.getText());
    }
    @Test
    public void displayedTest_Task() throws InterruptedException {
        /**  Task
         * navigate to https://the-internet.herokuapp.com/dynamic_loading
         * click the second link (Example 2: Element rendered after the fact)
         * click start button
         * verify that hello element is displayed (bu elementin locate işlemi starta clickten sonra yapılmalı)
         * get the element text and print it
         */

        driver.get("https://the-internet.herokuapp.com/dynamic_loading");
        WebElement example2 = driver.findElement(By.xpath("//a[text()='Example 2: Element rendered after the fact']"));
        example2.click();
        Thread.sleep(2000);

        WebElement startBtn = driver.findElement(By.xpath("//button[text()='Start']"));
        startBtn.click();
        Thread.sleep(8000);

        WebElement helloElement = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
        System.out.println("helloElement.getText() = " + helloElement.getText());

    }

}
