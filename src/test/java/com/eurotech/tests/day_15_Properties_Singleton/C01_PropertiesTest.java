package com.eurotech.tests.day_15_Properties_Singleton;

import com.eurotech.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class C01_PropertiesTest {

    @Test
    public void test1(){
        String browser = ConfigurationReader.get("browser");
        System.out.println("browser = " + browser);
    }


}
