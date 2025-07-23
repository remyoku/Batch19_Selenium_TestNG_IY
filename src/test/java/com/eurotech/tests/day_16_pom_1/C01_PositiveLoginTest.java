package com.eurotech.tests.day_16_pom_1;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C01_PositiveLoginTest extends TestBase {

    /**
     * ilk yapılması gereken : class ı TestBase e extends et  !!!!
     */
    @Test
    public void positiveLoginTest_OldVersion() {
        /**
         * navigate to https://sdettest.eurotechstudy.eu/login
         * login with valid credentials
         * verify success login with page title (contains Dashboard)
         *
         * old version
         */

        WebElement emailBox = driver.findElement(By.id("email"));
        WebElement passwordBox = driver.findElement(By.id("yourPassword"));
        WebElement loginBtn = driver.findElement(By.xpath("//button"));

        emailBox.sendKeys(ConfigurationReader.get("userEmail"));
        passwordBox.sendKeys(ConfigurationReader.get("password"));
        loginBtn.click();

        //verification
        String actualTitle = driver.getTitle();
        String expectedTitle = "Dashboard";

        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }
    @Test
    public void positiveLoginTest() {
        /**
         * navigate to https://sdettest.eurotechstudy.eu/login
         * login with valid credentials
         * verify success login with page title (contains Dashboard)
         *
         * old version
         */

        WebElement emailBox = driver.findElement(By.id("email"));
        WebElement passwordBox = driver.findElement(By.id("yourPassword"));
        WebElement loginBtn = driver.findElement(By.xpath("//button"));

        emailBox.sendKeys(ConfigurationReader.get("userEmail"));
        passwordBox.sendKeys(ConfigurationReader.get("password"));
        loginBtn.click();

        //verification
        String actualTitle = driver.getTitle();
        String expectedTitle = "EuroTech";

        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }
    @Test
    public void positiveLoginTest_oldVersion2() {
        /**
         * navigate to https://sdettest.eurotechstudy.eu/login
         * login with valid credentials
         * verify success login with page title (contains Dashboard)
         *
         * old version
         */
        WebElement emailBox = driver.findElement(By.id("email"));
        WebElement passwordBox = driver.findElement(By.id("yourPassword"));
        WebElement loginBtn = driver.findElement(By.xpath("//button"));

        emailBox.sendKeys(ConfigurationReader.get("userEmail"));
        passwordBox.sendKeys(ConfigurationReader.get("password"));
        loginBtn.click();

        //verification
        String actualTitle = driver.getTitle();
        String expectedTitle = "EuroTech";

        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }
    @Test
    public void positiveLoginTest_POM(){

        /**
         * navigate to https://sdettest.eurotechstudy.eu/login
         * login with valid credentials
         * verify success login with page title (contains Dashboard)
         * POM version
         */

        LoginPage loginPage = new LoginPage();

        /*
        WebElement emailBox = loginPage.emailBox;
        WebElement passwordBox = loginPage.passwordBox;
        WebElement loginBtn = loginPage.loginBtn;
        */

        loginPage.emailBox.sendKeys(ConfigurationReader.get("userEmail"));
        loginPage.passwordBox.sendKeys(ConfigurationReader.get("password"));
        loginPage.loginBtn.click();

        //verification
        String actualTitle = driver.getTitle();
        String expectedTitle = "Dashboard";

        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }

    @Test
    public void possitiveLoginTest_2() {

/**
 * navigate to https://sdettest.eurotechstudy.eu/login
 * login with valid credentials
 * verify success login with page title (contains Dashboard)
 * POM version (FindBys and FindAll)
 */
        LoginPage loginPage = new LoginPage();

        loginPage.emailBoxWithBys.sendKeys(ConfigurationReader.get("userEmail"));
        loginPage.passwordBoxWithFindAll.sendKeys(ConfigurationReader.get("password"));
        loginPage.loginBtn.click();

        //verification
        String actualTitle = driver.getTitle();
        String expectedTitle = "Dashboard";

        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }
    @Test
    public void positiveLoginTest_3(){
        LoginPage loginPage = new LoginPage();

        loginPage.login();

        DashboardPage dashboardPage = new DashboardPage();
        String actualUserName = dashboardPage.userName.getText();
        String expectedUserName = ConfigurationReader.get("userName");

        Assert.assertEquals(actualUserName,expectedUserName,"should be same");

    }

    @Test
    public void positiveLoginTest_4() {

        /**
         * navigate to https://sdettest.eurotechstudy.eu/login
         * login with valid credentials
         * verify that the user's name is seen on dashboard page
         *
         * note: do login process with login(userEmail,password) method  // with parameter
         */
        LoginPage loginPage = new LoginPage();

        loginPage.login("liorariven@gmail.com","Irem.2113");

        DashboardPage dashboardPage = new DashboardPage();
        String actualUserName = dashboardPage.userName.getText();
        String expectedUserName = ConfigurationReader.get("userName");

        Assert.assertEquals(actualUserName,expectedUserName,"should be same");


    }
}
