package pages;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.SendInqueryPageLocators06;
import utils.ExcelFileHandler;
import utils.HelperUtility;
import utils.LogHelper;
import utils.Root;

public class SendInqueryAction06 {

    public WebDriver driver;
    public HelperUtility helper;

    public SendInqueryAction06(WebDriver driver) {
        this.driver = driver;
        this.helper = new HelperUtility(driver);
    }

    public void contentBox() {
        helper.switchToNewWindow();
        helper.performClick(SendInqueryPageLocators06.SendInqueryPageText);
        helper.enterText(SendInqueryPageLocators06.SendInqueryPageText,
                ExcelFileHandler.getCellData(Root.prop.getProperty("path"), "Sheet1", 1, 0));
    }

    public void email() {
        helper.performClick(SendInqueryPageLocators06.SendInqueryPageEmail);
        helper.enterText(SendInqueryPageLocators06.SendInqueryPageEmail,
                ExcelFileHandler.getCellData(Root.prop.getProperty("path"), "Sheet1", 2, 0));

    }

    public void sendInquery(ExtentTest test) {
        helper.performClick(SendInqueryPageLocators06.SendInqueryPageSend);

    }

    public void form(ExtentTest test) {
        helper.performClick(SendInqueryPageLocators06.SendInqueryPageName);
        helper.enterText(SendInqueryPageLocators06.SendInqueryPageName,
                ExcelFileHandler.getCellData(Root.prop.getProperty("path"), "Sheet1", 3, 0));
        helper.performClick(SendInqueryPageLocators06.SendInqueryPageCompanyname);
        helper.enterText(SendInqueryPageLocators06.SendInqueryPageCompanyname,
                ExcelFileHandler.getCellData(Root.prop.getProperty("path"), "Sheet1", 4, 0));
        helper.performClick(SendInqueryPageLocators06.SendInqueryPageMobilename);
        helper.enterText(SendInqueryPageLocators06.SendInqueryPageMobilename,
                ExcelFileHandler.getCellData(Root.prop.getProperty("path"), "Sheet1", 5, 0));
        helper.performClick(SendInqueryPageLocators06.SendInqueryPageinquiry);
        helper.mouseHover(SendInqueryPageLocators06.SendInqueryPagelogo);
        helper.performClick(SendInqueryPageLocators06.SendInqueryPagelogo);

    }

    public void Inqueryandfillform(ExtentTest test) {
        contentBox();
        email();
        sendInquery(test);
        form(test);

    }

}
