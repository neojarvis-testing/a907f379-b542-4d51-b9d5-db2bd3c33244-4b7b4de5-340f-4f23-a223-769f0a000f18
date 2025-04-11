package runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pages.HomePageActionsTM02;
import pages.SearchResultPageActionsTM02;
import utils.ReportGenerator;
import utils.Root;

public class TestMadeInChina extends Root {
    HomePageActionsTM02 homePage;
    SearchResultPageActionsTM02 searchPage;
    ExtentReports reports;
    ExtentTest test;



    @BeforeClass
    public void createReport(){
        reports = ReportGenerator.generateExtentReport("Made-In-China Report");
    }

    @BeforeMethod
    public void openBrowser() {
        launchBrowser();
        homePage = new HomePageActionsTM02(driver);
        searchPage = new SearchResultPageActionsTM02(driver);
        homePage.closePopup();
    }
    
    @Test(priority = 1, enabled = true)
    public void checkWiresAndFurniture() {
        test = reports.createTest("Test Search Result For Wires And Furniture");
        
        homePage.searchWires(test);
        

        searchPage.verifyPageRedirects(test);
        searchPage.verifyWiresSearchResults(test);
        searchPage.verifyPagination(test);

        searchPage.clickWiresFirstProduct(test);
        searchPage.searchFurniture(test);
        searchPage.verifyFurnitureSearchResults(test);
        
        searchPage.clickMoreLinkAndVerify(test);
        searchPage.goToSecondPage(test);
        searchPage.goToHomePage(test);
        
    }
    
    @Test(priority = 2, enabled = true)
    public void checkMenuBarBuyersLink(){
        test = reports.createTest("Test Menu Bar Buyer's Link");

        homePage.hoverBuyerLink(test);
        homePage.clickNewUserGuide(test);
        homePage.verifyNewUserGuideURL(test);
        homePage.verifyNewUserGuideTitle(test);

        homePage.hoverBuyerLink(test);
        homePage.clickAuditedSupplier(test);
        homePage.verifyAuditedSupplierURL(test);
        homePage.verifyAuditedSupplierTitle(test);
        
        homePage.hoverBuyerLink(test);
        homePage.clickMeetSupplierLink(test);
        homePage.verifyMeetSupplierURL(test);
        homePage.verifyMeetSupplierTitle(test);

    }

    @AfterMethod
    public void closeBrowser() {
        try {
            Thread.sleep(3000);
            driver.quit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void flushReport(){
        reports.flush();
    }

}
