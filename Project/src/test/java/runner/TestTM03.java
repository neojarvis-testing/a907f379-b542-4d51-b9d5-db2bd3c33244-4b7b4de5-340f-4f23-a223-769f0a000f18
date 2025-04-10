package runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pages.HomePageActions03;
import pages.ProductsPageActions03;
import utils.LogHelper;
import utils.ReportGenerator;
import utils.Root;

public class TestTM03 extends Root {

    public HomePageActions03 homePageActions;
    public ProductsPageActions03 productsPageActions;

    public ExtentReports extentReports;
    public ExtentTest extentTest;

    @BeforeClass
    public void startReport() {
        extentReports = ReportGenerator.generateExtentReport("madeinchina");
    }

    @BeforeMethod
    public void preConditions() {
        launchBrowser();
        homePageActions = new HomePageActions03(driver);
        productsPageActions = new ProductsPageActions03(driver);
        homePageActions.closePopup();
    }

    @Test
    public void testCase03() {
        try {
            extentTest = extentReports.createTest("TestCase03");
            homePageActions.searchProductInSearchBar();
            productsPageActions.productSearchAndSendInquiryForm(extentTest);
        } catch (Exception e) {
            e.printStackTrace();
            LogHelper.error("Error Caught");
        }
    }

    @AfterMethod
    public void postConditions() {
        driver.quit();
    }

    @AfterClass
    public void endReport() {
        extentReports.flush();
    }

}
