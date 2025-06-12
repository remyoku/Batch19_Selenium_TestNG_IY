package com.eurotech.tests.day_02_webdriver_basic;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02A_CloseAndQuit {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(-1000,0));
        driver.manage().window().maximize(); // method üstüne method çağırmaya chain zincir deniyor

        driver.get("https://the-internet.herokuapp.com/windows");

        //click here yazısına tıklama
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();

        Thread.sleep(2000);
        System.out.println("driver.getTitle() = " + driver.getTitle());

       // driver.close();  sekmeyi kapatır

        driver.quit(); // komple kapatır.


    }
}
