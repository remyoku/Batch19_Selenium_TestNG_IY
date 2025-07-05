package com.eurotech.tests.day_09_TypeOfWebElements;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class C01_CheckBoxes {
    /**
     * Açıklamalar   :
     * isSelected()  ----> bir elementin seçili olup olmadığını verir  :  true/false
     * isDisplayed()  ----> bir elementin görünür olup olmadığını verir  :  true/false
     * isEnabled()  ----> bir element ile etkileşime (click, sendKeys vb.) geçilip geçilemeyeceğini verir  :  true/false
     * isEnabled() durumunun tersi disabled ile ifade edilir  ama isDisable() metodu yoktur...
     */


    WebDriver driver;  //class için global bir değişken olarak driver objesi oluşturalım. //declaration

    @BeforeMethod
    public void setUp(){
      driver = WebDriverFactory.getDriver("chrome");  //initialization
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
        driver.get(" http://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
    }

    @Test
    public void checkboxTest() throws InterruptedException {
        /**
         * navigate to http://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html
         * locate option 3 element
         * verify that the element is selected
         * click the element
         * verify that the element is NOT selected
         *
         * locate option 2
         * verify that the element is NOT selected
         * click the element
         * verify that the element is selected
         */

       // WebDriver  driver = WebDriverFactory.getDriver("chrome");
       // driver.get(" http://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        Thread.sleep(1000);

       //locate option 3 element
        WebElement option3 = driver.findElement(By.cssSelector("[value='option-3']"));

        //verify that the element is selected
        Assert.assertTrue(option3.isSelected());
        //parantez içi eğer seçiliyse açtığımız urlde Assert.assertTrue bize true dönüyor eğer içindeki doğru ise
        //bana bu true dönecek ve testim geçecek.false dönerse zaten fail olucak.
        Thread.sleep(1000);


        //click the element
        option3.click();

        //verify that the element is NOT selected
        Assert.assertFalse(option3.isSelected());
        //burda da ne yaptık seçmiş olduğumuz option3 ü clickle seçili butonu çıkarttık.Ve tekrardan verify edince ne
        //yapmış olduk assertFalse kullanarak seçilimi diye sorduk seçili olmadığı için false dönecek ve ben de
        //bunu false içine koyarak seçilimi false o zaman tamam



        //locate option 2
        WebElement option2 = driver.findElement(By.cssSelector("[value='option-2']"));

        //verify that the element is NOT selected
        Assert.assertFalse(option2.isSelected());
        Thread.sleep(1000);

        //click the element
        option2.click();
        Thread.sleep(1000);

        //verify that the element is selected
        Assert.assertTrue(option2.isSelected());
        Thread.sleep(1000);

        //driver.close();


    }
    @Test
    public void checkboxTest_Task(){
        /**
         * go to https://the-internet.herokuapp.com/checkboxes
         * locate both checkBoxes web elements
         * verify that checkbox 1 is NOT selected
         * verify that checkbox 2 is selected
         * click check box 1 and check box 2
         * verify that checkbox 1 is selected
         * verify that checkbox 2 is NOT selected
         */
    }
}
