package com.eurotech.tests.day_05_06_xPath;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C02_RelativeXpath_Attribute_Text {
    public static void main(String[] args) throws InterruptedException {
        /**
         * open chrome
         * navigate to https://www.amazon.com.tr/
         * accept cookies if any (use xPath formula with known attribute value)
         * locate search bar with xPath formula with known attribute value
         * send "Selenium" word to the search bar
         * locate search button with xPath formula with known attribute value
         * click search button
         * Get the search result by the formula of the text feature of Xpath (two ways)
         * get the text of web element and print it.
         * close driver.
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com.tr/");

        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='sp-cc-accept']")).click();
        Thread.sleep(2000);

        WebElement searchTextBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchTextBox.sendKeys("Selenium");

        WebElement searchButton = driver.findElement(By.xpath("//input[@value='Git']"));
        searchButton.click();

        WebElement resultText1 = driver.findElement(By.xpath("//span[text()='\"Selenium\"']"));
        WebElement resultText2 = driver.findElement(By.xpath("//span[.='\"Selenium\"']"));

        System.out.println("resultText1.getText() = " + resultText1.getText());
        System.out.println("resultText2.getText() = " + resultText2.getText());

        driver.close();


    }
}
