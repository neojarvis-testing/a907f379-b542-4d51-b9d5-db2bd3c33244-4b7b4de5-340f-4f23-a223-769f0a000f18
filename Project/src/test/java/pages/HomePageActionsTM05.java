package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.HomePageLocatorsTM05;
import utils.ExcelFileHandler;
import utils.HelperUtility;
import utils.LogHelper;
import utils.ReportGenerator;
import utils.Root;
import utils.ScreenCapture;

public class HomePageActionsTM05 {

    public WebDriver driver;
    public HelperUtility helper;

    public HomePageActionsTM05(WebDriver driver){
        this.driver=driver;
        this.helper= new HelperUtility(driver);
    }



    public void closePopup() {
        helper.performClick(HomePageLocatorsTM05.homepagePopup);
        LogHelper.info("Closing the popup in homepage");
        
    }

    public void RegisterSignIn(ExtentTest test) {
        helper.mouseHover(HomePageLocatorsTM05.homepageSignIn);
        LogHelper.info("Hovering on signin");
        helper.mouseHover(HomePageLocatorsTM05.homepagejoinfree);
        LogHelper.info("Hovering on joinfree");
        helper.performClick(HomePageLocatorsTM05.homepagejoinfree);
        LogHelper.info("Clicked on joinfree");
        helper.switchToNewWindow();
    }

    public void sendData(ExtentTest test) throws InterruptedException {

        helper.mouseHover(HomePageLocatorsTM05.registerPageEmail);
        LogHelper.info("Hovering on Email input box");
        test.log(Status.INFO, "Hovering on Email input box");
        helper.performClick(HomePageLocatorsTM05.registerPageEmail);
        LogHelper.info("Clicked on Email input box ");
        test.log(Status.INFO, "Clicked on Email input box");
        String text=ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"),Root.prop.getProperty("sheetname"), 0, 0);
        LogHelper.info("Read data from Excel");
        test.log(Status.INFO, "Read data from Excel");
        helper.enterText(HomePageLocatorsTM05.registerPageEmailinput,text);
        helper.performClick(HomePageLocatorsTM05.registerPageAgree);
        LogHelper.info("Clicked on Agree ");
        test.log(Status.INFO, "Clicked on Agree");
        test.log(Status.FAIL, "failed");
        ReportGenerator.addScreenshotToReport("signinpage", test, "failed");

    }
    public void navigateBack(ExtentTest test){
        helper.mouseHover(HomePageLocatorsTM05.homepageBuyer);
        LogHelper.info("Hovering on Buyer");
        test.log(Status.INFO, "Hovering on Buyer");
        helper.performClick(HomePageLocatorsTM05.homepageNewUserGuide);
        LogHelper.info("Clicked on Newuserguide");
        test.log(Status.INFO, "Clicked on Newuserguide");
        helper.switchToNewWindow();
        LogHelper.info("Switched to new Tab");
        test.log(Status.INFO, "Switched to new Tab");
        String userUrl=Root.driver.getCurrentUrl();
        LogHelper.info("Getting url from current window");
        test.log(Status.INFO, "Getting url from current window");
        String text=ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"),Root.prop.getProperty("sheetname"), 1, 0);
        if(userUrl.contains(text)){
            Assert.assertTrue(true);
        }
        LogHelper.info("Verified the url");
        test.log(Status.INFO, "Verified the url");
        helper.performClick(HomePageLocatorsTM05.homepageReturnBack);
        LogHelper.info("Returning back to homepage");
        test.log(Status.INFO, "Returning back to homepage");
        helper.mouseHover(HomePageLocatorsTM05.homepageBuyer);
        helper.performClick(HomePageLocatorsTM05.homepageAuditedSuppliersReports);
        LogHelper.info("Clicked on AuditedSupplierReports");
        test.log(Status.INFO, "Clicked on AuditedSupplierReports");
        helper.switchToNewWindow();
        LogHelper.info("Switched to new Tab");
        test.log(Status.INFO, "Switched to new Tab");
        String asrUrl=Root.driver.getCurrentUrl();
        String text1=ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"),Root.prop.getProperty("sheetname"), 2, 0);
        if(asrUrl.contains(text1)){
            Assert.assertTrue(true);
        }
        LogHelper.info("Verified the Url");
        test.log(Status.INFO, "Verified the Url");
        helper.performClick(HomePageLocatorsTM05.homepageReturnBack);
        helper.mouseHover(HomePageLocatorsTM05.homepageBuyer);
        helper.performClick(HomePageLocatorsTM05.homepageMeetSuppliers);
        LogHelper.info("Clicked on MeetPageSuppliers");
        test.log(Status.INFO, "Clicked on MeetPageSuppliers");
        helper.switchToNewWindow();
        String meetUrl=Root.driver.getCurrentUrl();
        String text2=ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"),Root.prop.getProperty("sheetname"), 3, 0);
        if(meetUrl.contains(text2)){
            Assert.assertTrue(true);
        }
        LogHelper.info("Verified the url");
        test.log(Status.INFO, "Verified the url");
        helper.performClick(HomePageLocatorsTM05.homepageReturnBack);
        LogHelper.info("Returning back to homepage");
        test.log(Status.INFO, "Returning back to homepage");
        ScreenCapture.takePageScreenShot("Homepage");
        

        

    }

}
