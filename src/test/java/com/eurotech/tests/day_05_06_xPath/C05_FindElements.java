package com.eurotech.tests.day_05_06_xPath;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class C05_FindElements {
    public static void main(String[] args) throws InterruptedException {

        /**
         * open chrome
         * go to https://demoqa.com/automation-practice-form
         * take all form labels to a web element list
         * then print labels texts
         * close driver
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/automation-practice-form");

        Thread.sleep(2000);

        List<WebElement> labels = driver.findElements(By.xpath("//label[@class='form-label']"));

        for (WebElement label : labels) {
            System.out.println(label.getText());
        }

        //beşinci sırada date of birth olduğunu test et

        String actualFifthLabel = labels.get(3).getText();
        String exceptedFifthLabel = "Date of Birth";

        if (actualFifthLabel.equals(exceptedFifthLabel)){
            System.out.println("Passsss");
        }else {
            System.out.println("Faillll");
        }

        System.out.println("Sonuncu = "+ labels.get(labels.size() - 1).getText());

        WebElement fifthElement = driver.findElement(By.xpath("(//label[@class='form-label'])[4]"));
        String actualFifthElement_2= fifthElement.getText();
        String exceptedFifthElement_2= "Date of Birth";

        if (actualFifthElement_2.equals(exceptedFifthElement_2)){
            System.out.println("passssss");
        }else {
            System.out.println("faillllllll");
        }

        driver.close();
    }
}
