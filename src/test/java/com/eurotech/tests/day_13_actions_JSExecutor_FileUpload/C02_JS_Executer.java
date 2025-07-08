package com.eurotech.tests.day_13_actions_JSExecutor_FileUpload;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_JS_Executer {
    WebDriver driver;
    // WebDriverWait wait;
    Actions actions;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //  wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
       driver.quit();
    }
    @Test
    public void clickWithJS(){
        /** CLASS TASK
         * navigate to https://www.amazon.com.tr/
         * accept cookies if any
         * click Kariyer link with js executor
         * accept cookies if any
         * verify that the url contains https://www.amazon.jobs/en/
         *
         * note : ask google how to click with js executor
         */

        driver.get("https://www.amazon.com.tr/");

        WebElement acceptCookies = driver.findElement(By.id("sp-cc-accept"));
        acceptCookies.click();

        WebElement kariyer = driver.findElement(By.linkText("Kariyer"));

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", kariyer);
        driver.findElement(By.id("btn-accept-cookies")).click();

        String expectedUrl = "https://www.amazon.jobs/en/";
        String actualUrl = driver.getCurrentUrl();

      Assert.assertTrue(actualUrl.contains(expectedUrl));


    }
    @Test
    public void typeWithJSE(){
        /**
         * go to https://the-internet.herokuapp.com/dynamic_controls
         * send "Hello World!" to the disabled box with js executor
         *
         * note : ask google--> how to sendKeys using JSExecutor
         */

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement disableBox = driver.findElement(By.cssSelector("[type='text']"));

      //  disableBox.sendKeys("Hello World!"); çalışmadı

        String text = "Hello World!";

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].value='"+text+"';", disableBox);


    }
    @Test
    public void scrollDownAndUp() throws InterruptedException {
        driver.get("https://www.amazon.com.tr/");

        WebElement acceptCookies = driver.findElement(By.id("sp-cc-accept"));
        acceptCookies.click();

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,800)");

        for (int i = 0; i <10 ; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,300)");
        }
        for (int i = 0; i <10 ; i++) {
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,-300)");
        }
    }
    @Test
    public void scrollToElement(){
        /**
         * navigate to https://www.amazon.com.tr/
         * accept cookies if any
         * scroll to the Kariyer and click it
         * verify that current page is "https://www.amazon.jobs/en/"
         */
        driver.get("https://www.amazon.com.tr/");

        WebElement acceptCookies = driver.findElement(By.id("sp-cc-accept"));
        acceptCookies.click();

        JavascriptExecutor jse = (JavascriptExecutor)driver;

        WebElement kariyer = driver.findElement(By.linkText("Kariyer"));
      //  jse.executeScript("arguments[0].scrollIntoView(true);", kariyer);

                                 // scroll down yapmak için              // Js click için
        jse.executeScript("arguments[0].scrollIntoView(true);"+"arguments[0].click();", kariyer);
        driver.findElement(By.id("btn-accept-cookies")).click();

        String expectedUrl = "https://www.amazon.jobs/en/";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrl));

    }
    @Test
    public void Task(){
        /**
         * navigate to https://sdettest.eurotechstudy.eu/forms/elements
         * scroll 1000 px down
         * change the Range position (actions ile)
         * change the Disabled Range position
         * scroll to the Number label
         * change the color from blue to red
         * select the Disabled Radio 3 button
         * scroll to the submit button
         * scroll again to the number label
         * scroll to the submit button and click on it
         * take the new page title and url
         * verify that the page title contains "EuroTech"
         *
         * not: all steps should be done with js executor except step 3 and last one.
         */
    }
}
