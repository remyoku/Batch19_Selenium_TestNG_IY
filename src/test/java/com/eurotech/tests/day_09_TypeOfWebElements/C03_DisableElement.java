package com.eurotech.tests.day_09_TypeOfWebElements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class C03_DisableElement {

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
    public void disableElement() throws InterruptedException {
        /**
         * go to https://the-internet.herokuapp.com/dynamic_controls
         * locate disable text bar
         * verify that the element is disabled(etkileşime açık değil)
         * locate and click the Enable button
         * send "The element is now enabled!!" keys to the bar
         * verify that the element is enabled.
         */

        //go to https://the-internet.herokuapp.com/dynamic_controls
        driver.get(" https://the-internet.herokuapp.com/dynamic_controls");
        Thread.sleep(1000);

        //locate disable text bar
        WebElement textBar = driver.findElement(By.cssSelector("#input-example>input"));
        //textBar.sendKeys("Harry Potter");

        //verify that the element is disabled
        Assert.assertFalse(textBar.isEnabled());

        //locate and click the Enable button
        WebElement enableButton = driver.findElement(By.xpath("//button[text()='Enable']"));
        enableButton.click();
        Thread.sleep(4000);

        String sentence ="The element is now enabled!!";

        //send "The element is now enabled!!" keys to the bar
        textBar.sendKeys(sentence);

        //verify that excepted value is seen on the text bar.
        String actualValue = textBar.getAttribute("value");
        Assert.assertEquals(actualValue,sentence);

        //verify that the element is enabled.
        Assert.assertTrue(textBar.isEnabled());
    }
    @Test
    public void disableElements_Task() throws InterruptedException {
        /**
         * navigate to http://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html
         * locate pumpkin element
         * verify that the element is enabled
         * verify that the element is selected
         * verify that the element is displayed
         * locate cabbage element
         * verify that the element is NOT enabled
         * verify that the element is NOT selected
         * verify that the element is displayed
         */
    }
}
