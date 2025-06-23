package com.eurotech.tests.day_04_basic_locators;

import com.eurotech.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class C09_BasicLocatorTask {
    public static void main(String[] args) throws InterruptedException {
        /** Class Task
         * go to the url - "https://www.browserstack.com/users/sign_up"
         * maximize the window
         * accept cookies if any ,
         * fill in the blanks with the faker class
         * click "Term of service" checkbox
         * and close the window
         *
         * hint: u can use any locator you want
         *
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.browserstack.com/users/sign_up");

        Thread.sleep(2000);

        WebElement fullName = driver.findElement(By.id("user_full_name"));

        Faker faker = new Faker();

        String fullName1 = faker.name().fullName();
        fullName.sendKeys(fullName1);
        Thread.sleep(2000);

        WebElement email_login = driver.findElement(By.id("user_email_login"));
        String emailAddress = faker.internet().emailAddress();
        email_login.sendKeys(emailAddress);
        Thread.sleep(2000);

        WebElement user_password = driver.findElement(By.id("user_password"));
        String password = faker.internet().password();
        user_password.sendKeys(password);
        Thread.sleep(2000);

        WebElement clickTerms = driver.findElement(By.name("terms_and_conditions"));
        clickTerms.click();

        Thread.sleep(2000);

        driver.close();


    }
}
