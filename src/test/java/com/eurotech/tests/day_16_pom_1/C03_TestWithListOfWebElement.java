package com.eurotech.tests.day_16_pom_1;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C03_TestWithListOfWebElement extends TestBase {

    @Test
    public void positiveLoginTestWithListOfWebElement() {
        /**
         * navigate to https://sdettest.eurotechstudy.eu/login
         * login with valid credentials (use list of element)
         * verify success login user's name (Leeroy)
         *
         */

        LoginPage loginPage = new LoginPage();

        loginPage.loginInputs.get(0).sendKeys(ConfigurationReader.get("userEmail"));
        loginPage.loginInputs.get(1).sendKeys(ConfigurationReader.get("password"));
        loginPage.loginInputs.get(2).click();
      //  loginPage.loginInputs.get(3).getText();  IndexOutOfBoundsException

        DashboardPage dashboardPage = new DashboardPage();
        String actualUserName = dashboardPage.userName.getText();
        String expectedUserName = ConfigurationReader.get("userName");

        Assert.assertEquals(actualUserName,expectedUserName,"should be same");
    }

    @Test
    public void loginWithKeys() {
        /**
         * navigate to https://sdettest.eurotechstudy.eu/login
         * login with valid credentials (use list of element)
         * login with Keys.TAB
         * verify success login user's name (Leeroy)
         *
         */

        LoginPage loginPage = new LoginPage();

        loginPage.loginInputs.get(0).sendKeys(ConfigurationReader.get("userEmail")+
                Keys.TAB+ConfigurationReader.get("password")+
                Keys.TAB+Keys.TAB+Keys.ENTER);

        DashboardPage dashboardPage = new DashboardPage();
        String actualUserName = dashboardPage.userName.getText();
        String expectedUserName = ConfigurationReader.get("userName");

        Assert.assertEquals(actualUserName,expectedUserName,"should be same");
    }

    @Test
    public void dashboardTabMenu() {


    }
}
