package runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


import pages.HomepageAction06;
import pages.ProductpageAction06;
import pages.SendInqueryAction06;
import utils.ExcelFileHandler;
import utils.ReportGenerator;
import utils.Root;

public class TestTM06 extends Root{

    public static ExtentReports reports;
    public static ExtentTest test;
    public HomepageAction06 homepageAction;
    public ProductpageAction06 productpageAction;
    public SendInqueryAction06 sendInqueryAction;

    @BeforeClass
    public void generator()
    {
        reports=ReportGenerator.generateExtentReport("Made in china");
    }
    
    @BeforeMethod
    public void preCondition()
    {

        launchBrowser();
        homepageAction=new HomepageAction06(driver);
        productpageAction= new ProductpageAction06(driver);
        sendInqueryAction= new SendInqueryAction06(driver);
        homepageAction.closePopup();
    
    }
    @Test(priority = 1,enabled = true)
    public void test6()
    {
        test=reports.createTest(Thread.currentThread().getName());
        homepageAction.searchProductInSearchBar(ExcelFileHandler.getCellData(Root.prop.getProperty("path"), "Sheet1", 0, 0));
        productpageAction.clickOnLedLightAndContact(test);
        sendInqueryAction.Inqueryandfillform(test);
        homepageAction.hoverandclickLedtube(test);
        productpageAction.ledlighttubefilter(test);
    }
    
    @Test(priority = 2,enabled = true)
    public void test8()
    {
        test=reports.createTest(Thread.currentThread().getName());
        homepageAction.hotItemsList(test);
          
    }
    @AfterMethod
    public void postCondition()
    {
         driver.quit();
    }

    @AfterClass
    public void closereport()
    {
    reports.flush();
    }

}
