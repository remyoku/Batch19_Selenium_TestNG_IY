package com.eurotech.tests.day_11_Alerts_MultipleWindow_iframes;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class C01_HTML_PopUps {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void htmlPopups() throws InterruptedException {
        /**  CLASS TASK
         * navigate to https://testpages.herokuapp.com/styled/alerts/fake-alert-test.html
         * click show fake alert box
         * verify that ok button can be seen on the popup
         * take the text on popup and print it (I am a fake alert box!) and verify.
         * then click on ok at the popup
         * verify that ok button cannot be seen
         */

        driver.get("https://testpages.herokuapp.com/styled/alerts/fake-alert-test.html");
        WebElement fakeAlert = driver.findElement(By.cssSelector("#fakealert"));
        fakeAlert.click();
        Thread.sleep(2000);

        WebElement okBtn = driver.findElement(By.id("dialog-ok"));
        Assert.assertTrue(okBtn.isDisplayed());

        WebElement fakeText = driver.findElement(By.cssSelector("[id='dialog-text']"));

        String actualText = fakeText.getText();
        String expectedText = "I am a fake alert box!";

        Assert.assertEquals(actualText,expectedText,"Fake alert box texts should be same");

        okBtn.click();

        Assert.assertFalse(okBtn.isDisplayed());

        //hatada kırmızı varsa kodu hatalı
        //sarı çıkıyorsa kod doğru ama istenilende bir hata var.




    }
    @Test
    public void html_Popups_Task(){
        /**
         * go to http://primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=73437
         * click on confirm button
         * click on yes at the popup window
         * make verification with confirmed popup
         */
    }



}
