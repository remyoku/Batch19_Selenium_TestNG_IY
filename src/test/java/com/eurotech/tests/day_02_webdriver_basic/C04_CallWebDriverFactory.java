package com.eurotech.tests.day_02_webdriver_basic;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class C04_CallWebDriverFactory {
    public static void main(String[] args) {
        /**
         * set up a chrome driver with WebDriverFactory
         * navigate to https://tr-tr.facebook.com/
         * verify that the url is correct
         */

       WebDriver driver = WebDriverFactory.getDriver("chrome");
       driver.navigate().to("https://tr-tr.facebook.com/");

        String actualUrl = driver.getCurrentUrl();
        String exceptedUrl = "https://tr-tr.facebook.com/";

        //test
        if (actualUrl.equals(exceptedUrl)){
            System.out.println("Passed...");
        }else {
            System.out.println("Failed....!");
        }
        driver.quit();

    }
}
