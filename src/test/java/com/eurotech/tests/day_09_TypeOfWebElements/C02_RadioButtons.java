package com.eurotech.tests.day_09_TypeOfWebElements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class C02_RadioButtons {

    //Radio buttonda sadece bir tane seçin imkanı veriyor ama checkboxta istediğiniz kadar seçme hakkı veriyor


    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("firefox");
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void radioButtonTest() throws InterruptedException {

        /**
         * navigate to http://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html
         * locate yellow element
         * verify that the element is NOT selected
         * click the element
         * verify that the element is selected
         *
         * locate blue element
         * verify that the element is displayed
         * click the element
         * verify that the blue element is selected
         * verify that the yellow element is NOT selected
         */
        driver.get("http://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");

        //locate yellow element
        WebElement yellow = driver.findElement(By.cssSelector("[value='yellow']"));


        //verify that the element is NOT selected
        Assert.assertFalse(yellow.isSelected());
        Thread.sleep(1000);

        //click the element
        yellow.click();
        Thread.sleep(1000);

        //verify that the element is selected
        Assert.assertTrue(yellow.isSelected());
        Thread.sleep(1000);

        //locate blue element
        WebElement blue = driver.findElement(By.cssSelector("[value='blue']"));

        //verify that the element is displayed
        Assert.assertTrue(blue.isDisplayed());
        Thread.sleep(1000);
        //bazen hidden elementler olur yani sayfada görünüz değil ama html kodunda var işte biz displayed
        //metodu ile bunu ben görebiliyormuyum diye soruyoruz.


        //click the element
        blue.click();
        Thread.sleep(1000);

       // verify that the blue element is selected
        Assert.assertTrue(blue.isSelected());
        Thread.sleep(1000);

        //verify that the yellow element is NOT selected
        Assert.assertFalse(yellow.isSelected());
        Thread.sleep(1000);

    }

    @Test
    public void radioButtonTask(){
        /**
         * https://demoqa.com/automation-practice-form
         * locate female gender element
         * verify that the element is NOT selected
         * verify that the element is displayed
         * click the element
         * verify that the element is selected
         * ipucu: eğer elementten istediğiniz sonucu alamıyorsanız..
         * aynı yeri gösteren diğer elementleri deneyin....!!!!
         */
    }


}
