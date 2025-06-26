package com.eurotech.tests.day_05_06_xPath;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C04_RelativeXpath_FirstTask {
    public static void main(String[] args) throws InterruptedException {
        /**
         * open chrome browser and go to http://www.eurotech.study/
         * click I understand button and accept cookies (use xPath with attribute feature)
         * locate Sign Up link (use xPath with text feature)
         * click the Sign Up link
         * locate Sign In link (use xPath with text feature)
         * get the text of element and print it
         * verify that the text is "Sign In"
         * close browser.
         */

        //open chrome browser and go to http://www.eurotech.study/
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://www.eurotech.study/");

        //click I understand button and accept cookies (use xPath with attribute feature)
        WebElement cookies = driver.findElement(By.xpath("//button[@id = 'rcc-confirm-button']"));
        cookies.click();

        Thread.sleep(2000);


        //locate Sign Up link (use xPath with text feature)
        // click the Sign Up link
        driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]")).click();
        Thread.sleep(1000);


        //locate Sign In link (use xPath with text feature)
        WebElement sıgnIn = driver.findElement(By.xpath("//a[contains(text(),'Sign In')]"));
        System.out.println("sıgnIn.getText() = " + sıgnIn.getText());

//        get the text of element and print it
//        verify that the text is "Sign In"

        String expectedText = "Sign In";
        String actualText = sıgnIn.getText();

        if (actualText.equals(expectedText)) {
            System.out.println("Test PASSED ");
        } else {
            System.out.println("Test FAILED ");
        }

        // close browser.
        Thread.sleep(1000);
        driver.close();
    }
}
