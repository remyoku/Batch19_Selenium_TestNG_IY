package com.eurotech.tests.day_11_Alerts_MultipleWindow_iframes;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class C04_Iframes {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    //iframe html içinde html demek

    @Test
    public void test1(){

    }
}
//setTimeout(() => {
//    debugger;
//}, 0);
