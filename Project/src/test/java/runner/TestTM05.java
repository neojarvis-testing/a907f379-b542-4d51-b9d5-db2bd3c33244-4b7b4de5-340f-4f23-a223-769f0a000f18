package runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pages.HomePageActionsTM05;
import utils.ReportGenerator;
import utils.Root;

public class TestTM05 extends Root {
    public HomePageActionsTM05 homePageAction;
    public static ExtentReports reports;
	public static ExtentTest test;

    @BeforeClass
    public void generator() {
    	reports=ReportGenerator.generateExtentReport("MadeInChina_Report");
    }


    @BeforeMethod
    public void preConditions(){
        launchBrowser();   
        homePageAction= new HomePageActionsTM05(driver);
        homePageAction.closePopup();

    }
    @Test(priority = 1, enabled =false)
    public void testCase02() throws InterruptedException{
        homePageAction = new HomePageActionsTM05(driver);
        test=reports.createTest("TestCaseOne");
       
        homePageAction.RegisterSignIn(test);
        homePageAction.sendData(test);
    }
    @Test(priority = 2, enabled=true)
    public void testCase07(){
        homePageAction= new HomePageActionsTM05(driver);
        test=reports.createTest("TestCaseTwo");
        homePageAction.navigateBack(test);
    }
    

    @AfterMethod
    public void postConditions(){
      driver.quit(); 
    }
    @AfterClass
    public void destroyer() {
    	reports.flush();
    }
    

}
