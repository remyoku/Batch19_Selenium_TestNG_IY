package com.eurotech.tests.day_08_TestNG_Intro;

import org.testng.annotations.*;

public class C02_BeforeAfterMethod {

    @Test (priority = 1)
    public void atest3(){                  //testler alfabetik sıraya göre çalışır
        System.out.println("Test 3");
    }
    @Test(priority = 3)
    public void test1(){
        System.out.println("Test 1");
    }
    @Test (enabled = false)
    public void test2() {
        System.out.println("Test 2");
    }
    @Test //priority girilmez ise default olarak "0" atanır ve ilk o test çalışır.
    public void test4() {
        System.out.println("Test 4");
    }
    @BeforeMethod
    public void setUp(){
        System.out.println("Before Method");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("After Method");
    }
    @BeforeClass
    public void setUpClass(){
        System.out.println("Before Class");
    }
    @AfterClass
    public void tearDownClass(){
        System.out.println("After Class");
    }
    @BeforeSuite
    public void beforeSuit(){
        System.out.println("Before Suit");
    }
    @AfterSuite
    public void afterSuit(){
        System.out.println("After Suit");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }
}
