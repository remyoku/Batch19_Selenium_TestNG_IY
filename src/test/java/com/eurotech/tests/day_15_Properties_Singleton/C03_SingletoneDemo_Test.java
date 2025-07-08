package com.eurotech.tests.day_15_Properties_Singleton;

import org.testng.annotations.Test;

public class C03_SingletoneDemo_Test {

    @Test
    public void test1(){
    //   C02_SingletoneDemo c02_singletoneDemo = new C02_SingletoneDemo(); bu classtan obje üretilemez

        String driver = C02_SingletoneDemo.getDriver();
        System.out.println("driver = " + driver);

        System.out.println("--------------------");

        String driver1 = C02_SingletoneDemo.getDriver();
        System.out.println("driver1 = " + driver1);
    }
}
