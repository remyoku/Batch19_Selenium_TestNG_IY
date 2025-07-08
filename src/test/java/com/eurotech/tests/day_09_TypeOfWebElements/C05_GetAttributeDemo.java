package com.eurotech.tests.day_09_TypeOfWebElements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class C05_GetAttributeDemo {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("edge");

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
    }

    @Test
    public void getAttributeTest() throws InterruptedException {

        /**
         * navigate to https://demoqa.com/text-box
         * locate the form web element
         * use some of GET (getAttribute, getTagName, getLocation, getCssValue) methods with the element
         */

        driver.get("https://demoqa.com/text-box");
        Thread.sleep(2000);


        WebElement formElement = driver.findElement(By.xpath("//form"));
        System.out.println("formElement.getAttribute(\"id\") = " + formElement.getAttribute("id"));
        System.out.println("--------------");
        System.out.println("formElement.getAttribute(\"innerHTML\") = " + formElement.getAttribute("innerHTML")); //child elementleri ile birlikte döner.(son child elemnt ise boştadır.)
        System.out.println("--------------");
        System.out.println("formElement.getAttribute(\"outerHTML\") = " + formElement.getAttribute("outerHTML"));
        System.out.println("--------------");
        System.out.println("formElement.getText() = " + formElement.getText());
        System.out.println("--------------");
        System.out.println("formElement.getLocation() = " + formElement.getLocation()); //X,Y OLARAK ELEMENTİN KOORDİNATLARINI VERİR.
        System.out.println("--------------");
        System.out.println("formElement.getCssValue(\"background\") = " + formElement.getCssValue("background"));
        System.out.println("--------------");
        System.out.println("formElement.getCssValue(\"font\") = " + formElement.getCssValue("font"));
        System.out.println("--------------");
        System.out.println("formElement.getCssValue(\"color\") = " + formElement.getCssValue("color"));
        System.out.println("--------------");
        System.out.println("formElement.getRect().getDimension() = " + formElement.getRect().getDimension());
        System.out.println("--------------");
        System.out.println("formElement.getSize() = " + formElement.getSize());


    }
    @Test
    public void getAttribute_Task() throws InterruptedException {

        /**
         * navigate to https://demoqa.com/text-box
         * locate Full Name input box
         * use getAttribute method with the element
         * get type attribute value and print it
         * get autocomplete attribute value and print it
         * get name attribue value and print it (name attribute olmadığı için boş dönecektir. hata vermez..)
         * get innerHTML and print it (altında child veya grandchild element olmadığından boş döner..)
         * get outerHTML (sadece kendi tag bilgilerini döner..)
         * send Ahmet to the box and take the value (eğer bir text box'ına yazı gönderirsek.. bu gönderlen yazıyı
         * getAttribute("value") metodu ile alabiliriz..)
         * NOT: getAttribute metodu ile bir web elementin texti alınamaz.. onun için getText() metodu kullanılır..
         */

        driver.get("https://demoqa.com/text-box");

        WebElement fullNameInputBox = driver.findElement(By.cssSelector("[id='userName']"));
        System.out.println("fullNameInputBox.getAttribute(\"type\") = " + fullNameInputBox.getAttribute("type"));
        System.out.println("fullNameInputBox.getAttribute(\"autocomplete\") = " + fullNameInputBox.getAttribute("autocomplete"));
        System.out.println("fullNameInputBox.getAttribute(\"name\") = " + fullNameInputBox.getAttribute("name"));

        System.out.println("--------------------------");

        System.out.println("fullNameInputBox.getAttribute(\"innerHTML\") = " + fullNameInputBox.getAttribute("innerHTML"));
        System.out.println("fullNameInputBox.getAttribute(\"outerHTML\") = " + fullNameInputBox.getAttribute("outerHTML"));
        Thread.sleep(1000);

        fullNameInputBox.sendKeys("Ahmet");
        Thread.sleep(2000);
        System.out.println("fullNameInputBox.getAttribute(\"value\") = " + fullNameInputBox.getAttribute("value"));
    }
}
