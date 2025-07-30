package com.eurotech.tests.day_07_Css_Locator.day_10_listOfElemenets_DropDawns;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class C01_ListOfElements_FindElements {

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
    public void findElementsWithCorrectLocators() {

        /**
         * https://demoqa.com/elements adresine git
         * soldaki ana başlıkları tek bir locator ile locate et ve bunları bir liste kaydet
         * listin size'ını al.
         * size'ın 6 olduğunu doğrula.
         * listedeki başlık elementlerinin textlerini yazdır. (For each)
         * başlıkların gözüktüğünü doğrulayalım
         */

        driver.get(" https://demoqa.com/elements ");
        List<WebElement> headers = driver.findElements(By.cssSelector(".group-header"));

        int actualSize = headers.size();
        int exceptedSize = 6;

        Assert.assertEquals(actualSize,exceptedSize);

        //başlıkları yazdıralım
        for (WebElement header  : headers ) {
            System.out.println(header.getText());
        }

        //lamda ile
        headers.forEach(header -> System.out.println(header.getText()));

        //lamda ile isDisplayed()
        headers.forEach(header -> {
            Assert.assertTrue(header.isDisplayed());
        });
    }

    @Test
    public void findElementsWithIncorrectLocator() throws InterruptedException {
        driver.get(" https://demoqa.com/elements ");
        List<WebElement> headers = driver.findElements(By.cssSelector(".wrongLocator"));

        //hatalı bir locator verirsek bize hata vermez boş bir list döner.


        int actualSize = headers.size();
        int exceptedSize = 6;
        Thread.sleep(2000);

        System.out.println("actualSize = " + actualSize);

        //Assert.assertEquals(actualSize,exceptedSize);
    }
    @Test
    public void findElements(){
        /**    CLASS TASK
         * navigate to https://www.saucedemo.com/
         * locate login form elements with one locator (username box, password box and login button)
         * send "standard_user" to username box
         * send "secret_sauce" to password box
         * click Login button
         * then take all product names to a web element list and print the text of elements
         * verify that first web element text is "Sauce Labs Backpack"
         */

        driver.get("https://www.saucedemo.com/");
        List<WebElement> inputs = driver.findElements(By.tagName("input"));

        inputs.get(0).sendKeys("standard_user");
        inputs.get(1).sendKeys("secret_sauce");
        inputs.get(2).click();

        List<WebElement> items = driver.findElements(By.cssSelector(".inventory_item_name "));
        for (WebElement item  :items ) {
            System.out.println(item.getText());
        }

//        String actualFirstTagName = items.get(0).getText();
//        String expectedFirstİtemName = "\"Sauce Labs Backpack\"";
        Assert.assertEquals(items.get(0).getText(),"Sauce Labs Backpack");
    }

    @Test
    public void findElements_Task() throws InterruptedException {
        /**

         navigate to http://www.eurotech.study/
         accept cookies
         click login
         locate emailBox, passBox and Login Button with one locator and put them in a list which named as inputs
         verify that the size of list is 3
         verify that the value of 3rd element is Login
         send your credentials to related boxes and then click login button
         verify success login with "Welcome ......." text
         locate Experience Credentials and Education Credentials with findElements()
         then get both element texts and print them
         **/

        driver.get("http://www.eurotech.study/");
        Thread.sleep(1000);

        WebElement cookies = driver.findElement(By.xpath("//button[@id = 'rcc-confirm-button']"));
        cookies.click();
        Thread.sleep(1000);

        WebElement loginBtn = driver.findElement(By.xpath("//a[text()='Login']"));
        loginBtn.click();
        Thread.sleep(1000);

       List<WebElement> inputs = driver.findElements(By.cssSelector("input"));

        System.out.println("inputs.size() = " + inputs.size());
        Assert.assertTrue(inputs.size()==3);

        String thirdElement = inputs.get(2).getAttribute("value");
        Assert.assertEquals(thirdElement,"Login");

        inputs.get(0).sendKeys("iremyokus2113@gmail.com");
        inputs.get(1).sendKeys("Irem.2113");
        inputs.get(2).click();
        Thread.sleep(2000);

        WebElement welcomeMessage = driver.findElement(By.id("dashboard-p1"));
        String actualMessage= welcomeMessage.getText();
        String expectedMessage = "Welcome İrem";

        Assert.assertEquals(actualMessage,expectedMessage);

       List<WebElement> experienceAndEducation = driver.findElements(By.xpath("//h2"));

       for (WebElement experienceAndEducations : experienceAndEducation){
           System.out.println("experienceAndEducations.getText() = " + experienceAndEducations.getText());
       }
        System.out.println("---------------------------------------------------------");
       //ayrı ayrı
        System.out.println("experienceAndEducation.get(0) = " + experienceAndEducation.get(0));
        System.out.println("experienceAndEducation.get(1) = " + experienceAndEducation.get(1));

    }
}

        /** Açıklamalar....
        * findElements() --> bize WebElement'leri bir liste olarak döner.. (1 of 3 ise listede 3 element bulunur..)
        * List<WebElement> inputs = driver.findElements(By.xpath("xPathFormülü")); // diğer yöntemler de kullanılabilir..
        * elements.get(0).click() --> listenin ilk elementine click yapar
        * elements.get(1).getText() --> listenin ikinci elementinin textini alır.
        * elements.get(2).isDisplayed() --> listenin üçüncü elementinin sayfada görünüp/görünmediğini doğrular..
        * ...
        * findElement() ve findElements() arasındaki farklar..
        * a. findElement() --> WebElement döner, eğer elementi locate edemezse noSuchElementException fırlatır.
        * b. findElements() --> WebElement listesi döner. eğer elementleri locate edemezse boş bir liste döner
        * bu nedenle hiçbir zaman noSuchElementException hatası fırlatmaz... bulursa dolu, bulamazsa boş liste verir.
        */