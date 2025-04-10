package runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import pages.HomePageActions04;
import pages.RegisteredPageActions04;
import pages.SignInPageActions04;
import utils.ReportGenerator;
import utils.Root;

public class TestRunner extends Root {
    public static ExtentReports reports;
    public static ExtentTest test;
    public HomePageActions04 homePageAction;
    public RegisteredPageActions04 registeredPageAction;
    public SignInPageActions04 signInPageAction;

    
    @BeforeMethod
    public void preConditions() {
        launchBrowser();
        homePageAction=new HomePageActions04(driver);
        registeredPageAction=new RegisteredPageActions04(driver);
        signInPageAction=new SignInPageActions04(driver);
        homePageAction.closePopup();
    }


    @BeforeClass
    public void generator() {
        reports = ReportGenerator.generateExtentReport("Made In China");
    }

    @Test(enabled = true)
    public void testCase5() {
        test=reports.createTest(Thread.currentThread().getName());
        homePageAction.hoverOverSignInIcon(test);
        homePageAction.clickOnJoinFreeButton(test);
        registeredPageAction.clickOnSignInNowLink();
        signInPageAction.languageChange(test);
    }

    @Test(enabled = true)
    public void testCase9()
    {
        test=reports.createTest(Thread.currentThread().getName());
        homePageAction.clickOnSideBarCategoryLinks(test);

    }


    @AfterClass
    public void closeReport() {

        reports.flush();
    }

    @AfterMethod
    public void postConditions() {
        driver.quit();
    }

}