package com.eurotech.tests.day_07_Css_Locator.day_10_listOfElemenets_DropDawns;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class C03_DropDownsWithoutSelectTag {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void dropDownWithoutSelectTag() throws InterruptedException {
        /**
         * navigate to https://demoqa.com/select-menu
         * locate and click Select Value dropdown
         * select (click) "Group 1, option 2" from Select Value dropdown
         * locate the new "Group 1, option 2" web element (stale element daha sonra anlatılacak)
         * verify that the element text is "Group 1, option 2"
         */

        driver.get("https://demoqa.com/select-menu");
        Thread.sleep(1000);

        WebElement dropdownMenü = driver.findElement(By.xpath("//div[text()='Select Option']"));
        dropdownMenü.click();
        Thread.sleep(1000);

        WebElement group1_Option2 = driver.findElement(By.xpath("//div[text()='Group 1, option 2']"));
        group1_Option2.click();
        Thread.sleep(2000);

       // String actualText = group1_Option2.getText();  //bu webelement seçildiğinden ilk sıradadır ve artık başka
       // System.out.println(actualText);               //web element olduğu için Stale Element hatası alınır.

        //ilk sıraya geçtiği için tekrar locate edilmeli

        WebElement group1_Option2_FirstPlace = driver.findElement(By.xpath("//div[text()='Group 1, option 2']"));
        String actualText = group1_Option2_FirstPlace.getText();
//aslında hiç bişey değiştirmedim locate olarak ama neden tekrar yazdık çünkü artık birinci sırada onun yeri değişti
//bu yüzden bu artık farklı diyor birebir aynı olmasına rağmen ve tekrar locate etmeni istiyor selenium.

        String expectedText = "Group 1, option 2";

        Assert.assertEquals(actualText,expectedText);

    }
    @Test
    public void dropdownWithoutSelectTag_Task(){
        /**
         * navigate to https://demoqa.com/select-menu
         * click Select One dropdown
         * click on 'Mrs.'
         * verify that the selected text is "Mrs."
         *
         * NOT:right click/inspect/eventlisteners/blur  burada bulunan bütün seçenekler silinir.
         */
    }
}
