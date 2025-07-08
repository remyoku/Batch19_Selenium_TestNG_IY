package com.eurotech.tests.day_15_Properties_Singleton;

public class C02_SingletoneDemo {

    private C02_SingletoneDemo(){}
        //private constroctor sayesinde bu classtan obje üretilemez.

    private static String driver;

    public static String getDriver(){
        if (driver== null){
            System.out.println("driver boştur, ona değer atayınız");
            driver = "firefox";
        }else {
            System.out.println("driver boş değildir, size mevcut driver'ı dönüyorum.");
        }
        return driver;
    }

}
