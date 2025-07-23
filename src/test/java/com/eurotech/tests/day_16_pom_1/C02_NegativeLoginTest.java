package com.eurotech.tests.day_16_pom_1;

import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C02_NegativeLoginTest extends TestBase {

    @Test
    public void wrongPasswordTest(){
        /**
         * navigate to https://sdettest.eurotechstudy.eu/login
         * type in correct username
         * type in wrong password
         * verify that user cannot login
         * and takes the warning message: "Password is incorrect. Please check"
         */

        LoginPage loginPage = new LoginPage();

        loginPage.emailBox.sendKeys(ConfigurationReader.get("userEmail"));
        loginPage.passwordBox.sendKeys("wrongPassword");
        loginPage.loginBtn.click();

        String actualMessage = loginPage.wrongPasswordMessage.getText();
        String expectedMessage = "Password is incorrect. Please check";

        Assert.assertEquals(actualMessage,expectedMessage,"the message should be same");
    }

    @Test
    public void wrongEmailTest() {
        /**
         * navigate to https://sdettest.eurotechstudy.eu/login
         * type in wrong username
         * type in correct password
         * verify that user cannot login
         * and takes the warning message: "Email address is incorrect. Please check"
         */

        LoginPage loginPage = new LoginPage();
        loginPage.emailBox.sendKeys("wrongEmail");
        loginPage.passwordBox.sendKeys(ConfigurationReader.get("password"));
        loginPage.loginBtn.click();

        String actualMessage = loginPage.getWrongEmailMessage.getText();
        String expectedMessage = "Email address is incorrect. Please check";

        Assert.assertEquals(actualMessage,expectedMessage,"the message should be same");

        //hocanın yaptığı
//        LoginPage loginPage = new LoginPage();
//        loginPage.login("wrongEmail",ConfigurationReader.get("password"));
//
//        String actualMessage = loginPage.getWrongEmailMessage.getText();
//        String expectedMessage = "Email address is incorrect. Please check";
//
//        Assert.assertEquals(actualMessage,expectedMessage,"the message should be same");

        


    }


}
