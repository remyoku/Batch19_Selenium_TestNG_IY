package com.eurotech.tests.day_12_Wait.day_19_extent_reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class C01_ExtentReportsDemo {

    //bu class rapor oluşturmak ve rapor ile ilgili metadatayı tanımlamak için kullanılır.
    ExtentReports report;

    //bu class raporumuzun html formatında olmasını sağlar
    ExtentHtmlReporter htmlReporter;

    //Her test ile ilgili log kayıtları almamızı ve test adımlarını tanımlamamızı sağlar.
    ExtentTest extentLogger;

    @BeforeMethod
    public void before(){
        //rapor objemizi initialize edelim
        report = new ExtentReports();

        //raporun kayıt edileceği yeri berlirleyelim.(path)
        String projectPath = System.getProperty("user.dir");
        String reportPath = projectPath + "/test-output/report.html";

        //html raporumuzu path ile oluşturalım
        htmlReporter = new ExtentHtmlReporter(reportPath);

        //html raporumuz report objesi ile ilişkilendirelim(attach)
        report.attachReporter(htmlReporter);

        //raporumuzu başlık verelim.
        htmlReporter.config().setReportName("Smoke Test");

        //raporumuzun environment(metadata) bilgilerini düzenleyelim.
        report.setSystemInfo("Environment","QA");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));
        report.setSystemInfo("Test Engineer",ConfigurationReader.get("userName"));
        report.setSystemInfo("PO","Süleyman Süleyman");

    }
    @Test
    public void test1(){

        //mevcut bu testimizin adını girelim
        extentLogger = report.createTest("TC001 Demo Test");

        //test adımlarını teker teker firelim
        extentLogger.info("chrome browserı aç");
        //kod buraya yazılacak -- code here

        extentLogger.info("Web sayfasına git");
        //kod buraya yazılacak -- code here

        extentLogger.info("email gir");
        //kod buraya yazılacak -- code here

        extentLogger.info("password gir");
        //kod buraya yazılacak -- code here

        extentLogger.info("login butona click yap");
        //kod buraya yazılacak -- code here

        extentLogger.info("login olduğumuzu kullanıcı adı ile doğrula : " +ConfigurationReader.get("userName"));
        //kod buraya yazılacak -- code here

        extentLogger.pass("Passed....!");
    }
    @AfterMethod
    public void after(){

        //raporun gerçek anlamda oluşturulduğu yer
        report.flush();
    }
}
