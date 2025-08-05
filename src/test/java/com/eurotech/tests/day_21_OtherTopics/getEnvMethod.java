package com.eurotech.tests.day_21_OtherTopics;

import org.testng.annotations.Test;

public class getEnvMethod {
    /**
     * environment veriablesta bulunan değişkenlere erişmek için kullanılır.
     */

    @Test

    public void test1(){
        String pass = System.getenv("passwordTest19");
        System.out.println("pass = " + pass);
    }
}
