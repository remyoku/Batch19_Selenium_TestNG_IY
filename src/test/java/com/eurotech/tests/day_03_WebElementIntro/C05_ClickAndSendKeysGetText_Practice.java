package com.eurotech.tests.day_03_WebElementIntro;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C05_ClickAndSendKeysGetText_Practice {
    public static void main(String[] args) throws InterruptedException {
        /**
         *      HOMEWORK
         * Open chore browser
         * navigate to https://www.amazon.com/
         * write "Java" to the search bar
         * click search button
         * get result for text
         * verify that the text contains "Java"
         */


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.navigate().to("https://www.amazon.com.tr/");

        Thread.sleep(1000);
        WebElement writeBar = driver.findElement(By.cssSelector("[id=\"twotabsearchtextbox\"]"));
        writeBar.sendKeys("Java");
        Thread.sleep(2000);

        WebElement searchbar = driver.findElement(By.id("nav-search-submit-button"));
        searchbar.click();

        WebElement messageText = driver.findElement(By.cssSelector("[class='a-color-state a-text-bold']"));
        String actualText = messageText.getText();

        if (actualText.contains("Java")){
            System.out.println("Passss");
        }else {
            System.out.println("Faillll");
        }

        driver.quit();
    }
}
