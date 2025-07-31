package com.eurotech.tests.day_19_extent_reports;

import com.eurotech.pages.AddExperiencePage;
import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.pages.UserProfilePage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C04_AddExperienceWithExtentLogger_Task extends TestBase {
    @Test
    public void addExperienceTest(){
        /**
         1-navigate to https://sdettest.eurotechstudy.eu/login
         2-make login
         3-Assert successful login with user name
         4-Navigate to My Profile with related method
         5-Verify that User Profile page is displayed
         6-Navigate to Add Experience tab with related method
         7-Verify that add experince page is displayed
         8-Fill the form with non-parameterized method (using actions class is optional)
         9-Verify that added experience record can be seen at user profile page... (assert with job title)
         10-Delete last added experience record

         important note: every student should use own credentials, otherwise the test case will fail....
         */

        LoginPage loginPage = new LoginPage();
        loginPage.login();

        DashboardPage dashboardPage = new DashboardPage();
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(dashboardPage.userName)).isDisplayed());

        String actualUserName = dashboardPage.userName.getText();
        String exceptedUserName = ConfigurationReader.get("userName");
        Assert.assertEquals(actualUserName,exceptedUserName);

        dashboardPage.navigateToTabs(ConfigurationReader.get("userName"),"My Profile");

        UserProfilePage userProfilePage = new UserProfilePage();
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(userProfilePage.userProfilePageTitle)).isDisplayed());

        AddExperiencePage addExperiencePage = new AddExperiencePage();
        userProfilePage.navigateUserProfileTabs("Add Experience");

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOf(addExperiencePage.addExperienceBtn)).isDisplayed());

        addExperiencePage.fillingAddExperienceForm("Qa Tester","EuroTech","Turkiye",
                "09122024","21122025","Education Program");

        String lastAddedJob = userProfilePage.lastAddedJobName("Qa Tester");
        String exceptedJobName = "Qa Tester";
        Assert.assertEquals(lastAddedJob,exceptedJobName);

        userProfilePage.deleteLastAddedExperienceRecord("Qa Tester");
    }
}
