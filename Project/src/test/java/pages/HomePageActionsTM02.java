package pages;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.HomePageLocatorsTM02;
import utils.ExcelFileHandler;
import utils.HelperUtility;
import utils.LogHelper;
import utils.Root;

public class HomePageActionsTM02 {
    public WebDriver driver;
    public HelperUtility helper;

    public HomePageActionsTM02(WebDriver driver) {
        this.driver = driver;
        this.helper = new HelperUtility(driver);
    }

    public void closePopup() {
        helper.performClick(HomePageLocatorsTM02.homepagePopUpcloseButton);

        LogHelper.info("click on close pop up button");
    }

    public void searchWires(ExtentTest test) {
        try {
            String excelSheetPath = Root.prop.getProperty("excelSheetPath");

            String searchValue = ExcelFileHandler.getCellData(excelSheetPath, "Sheet1", 1, 0);

            helper.performClick(HomePageLocatorsTM02.homePageSearchBar);
            helper.enterText(HomePageLocatorsTM02.homePageSearchBar, searchValue);
            helper.performEnter(HomePageLocatorsTM02.homePageSearchBar);

            LogHelper.info("click on search bar");
            LogHelper.info(searchValue + " entered in search bar");
            LogHelper.info("searched " + searchValue);
            test.log(Status.INFO, "click on search bar");
            test.log(Status.INFO, searchValue + " entered in search bar");
            test.log(Status.INFO, "searched " + searchValue);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void hoverBuyerLink(ExtentTest test) {
        helper.mouseHover(HomePageLocatorsTM02.menuBarBuyerLink);
        String buyerLinkText = helper.retrieveText(HomePageLocatorsTM02.menuBarBuyerLink);
        LogHelper.info("hover on " + buyerLinkText);
        test.log(Status.INFO, "hover on " + buyerLinkText);
    }

    public void clickNewUserGuide(ExtentTest test) {
        helper.performClick(HomePageLocatorsTM02.menuBarNewUserGuideLink);
        String newUserGuideLinkText = helper.retrieveText(HomePageLocatorsTM02.menuBarNewUserGuideLink);
        LogHelper.info("click on " + newUserGuideLinkText);
        test.log(Status.INFO, "click on " + newUserGuideLinkText);
    }

    public void verifyNewUserGuideURL(ExtentTest test) {
        helper.switchToNewWindow();

        String currentPageURL = Root.driver.getCurrentUrl();
        String newUserGuidePageURL = "how-to-source-products-on-made-in-china-com";
        helper.verifyAcutalAndExpected(currentPageURL, newUserGuidePageURL);

        LogHelper.info("page url verified - " + currentPageURL);
        test.log(Status.INFO, "page url verified - " + currentPageURL);
    }

    public void verifyNewUserGuideTitle(ExtentTest test) {
        String currentPageTitle = Root.driver.getTitle();
        String newUserGuidePageTitle = "How to Source Products from China on Made-in-China-com";
        helper.verifyAcutalAndExpected(currentPageTitle, newUserGuidePageTitle);

        helper.performClick(HomePageLocatorsTM02.homePageLogo);

        LogHelper.info("switched to new window - " + currentPageTitle);
        LogHelper.info("page title verified - " + currentPageTitle);
        test.log(Status.INFO, "switched to new window - " + currentPageTitle);
        test.log(Status.INFO, "page title verified - " + currentPageTitle);
    }

    public void clickAuditedSupplier(ExtentTest test) {
        helper.performClick(HomePageLocatorsTM02.menuBarAuditedSuppliersLink);
        String auditedSuplierLinkText = helper.retrieveText(HomePageLocatorsTM02.menuBarAuditedSuppliersLink);
        LogHelper.info("click on " + auditedSuplierLinkText);
        test.log(Status.INFO, "click on " + auditedSuplierLinkText);
    }

    public void verifyAuditedSupplierURL(ExtentTest test) {
        helper.switchToNewWindow();

        String currentPageURL = Root.driver.getCurrentUrl();
        String newUserGuidePageURL = "audited-suppliers";
        helper.verifyAcutalAndExpected(currentPageURL, newUserGuidePageURL);

        LogHelper.info("page url verified - " + currentPageURL);
        test.log(Status.INFO, "page url verified - " + currentPageURL);
    }

    public void verifyAuditedSupplierTitle(ExtentTest test) {
        String currentPageTitle = Root.driver.getTitle();
        String newUserGuidePageTitle = " Audited Suppliers | Choose the Reliable China Suppliers on Made-in-China.com";
        helper.verifyAcutalAndExpected(currentPageTitle, newUserGuidePageTitle);

        helper.performClick(HomePageLocatorsTM02.homePageLogo);

        LogHelper.info("page title verified - " + currentPageTitle);
        test.log(Status.INFO, "page title verified - " + currentPageTitle);
    }

    public void clickMeetSupplierLink(ExtentTest test) {
        helper.performClick(HomePageLocatorsTM02.menuBarMeetSuppliersLink);
        String meetSupplierLinkText = helper.retrieveText(HomePageLocatorsTM02.menuBarMeetSuppliersLink);

        LogHelper.info("click on " + meetSupplierLinkText);
        test.log(Status.INFO, "click on " + meetSupplierLinkText);

    }

    public void verifyMeetSupplierURL(ExtentTest test) {
        helper.switchToNewWindow();

        String currentPageURL = Root.driver.getCurrentUrl();
        String newUserGuidePageURL = "private-sourcing-meetings";
        helper.verifyAcutalAndExpected(currentPageURL, newUserGuidePageURL);

        LogHelper.info("page url verified - " + currentPageURL);
        test.log(Status.INFO, "page url verified - " + currentPageURL);

    }

    public void verifyMeetSupplierTitle(ExtentTest test) {
        String currentPageTitle = Root.driver.getTitle();
        String newUserGuidePageTitle = "Apply to Meet Suppliers- Made-in-China.com buyer services";
        helper.verifyAcutalAndExpected(currentPageTitle, newUserGuidePageTitle);

        helper.performClick(HomePageLocatorsTM02.homePageLogo);

        LogHelper.info("page title verified - " + currentPageTitle);
        test.log(Status.INFO, "page title verified - " + currentPageTitle);

    }

}
