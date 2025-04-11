package pages;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.SendInqueryPageLocators;
import utils.ExcelFileHandler;
import utils.HelperUtility;
import utils.LogHelper;
import utils.Root;

public class SendInqueryActions {

    public WebDriver driver;
    public HelperUtility helper;

    public SendInqueryActions(WebDriver driver) {
        this.driver = driver;
        this.helper = new HelperUtility(driver);
    }

    public void contentBox() {
        helper.switchToNewWindow();
        helper.performClick(SendInqueryPageLocators.SendInqueryPageText);
        helper.enterText(SendInqueryPageLocators.SendInqueryPageText,
                ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet6", 1, 0));
    }

    public void email() {
        helper.performClick(SendInqueryPageLocators.SendInqueryPageEmail);
        helper.enterText(SendInqueryPageLocators.SendInqueryPageEmail,
                ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet6", 2, 0));

    }

    public void sendInquery(ExtentTest test) {
        helper.performClick(SendInqueryPageLocators.SendInqueryPageSend);

    }

    public void form(ExtentTest test) {
        helper.performClick(SendInqueryPageLocators.SendInqueryPageName);
        helper.enterText(SendInqueryPageLocators.SendInqueryPageName,
                ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet6", 3, 0));
        helper.performClick(SendInqueryPageLocators.SendInqueryPageCompanyname);
        helper.enterText(SendInqueryPageLocators.SendInqueryPageCompanyname,
                ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet6", 4, 0));
        helper.performClick(SendInqueryPageLocators.SendInqueryPageMobilename);
        helper.enterText(SendInqueryPageLocators.SendInqueryPageMobilename,
                ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet6", 5, 0));
        helper.performClick(SendInqueryPageLocators.SendInqueryPageinquiry);
        helper.mouseHover(SendInqueryPageLocators.SendInqueryPagelogo);
        helper.performClick(SendInqueryPageLocators.SendInqueryPagelogo);

    }

    public void Inqueryandfillform(ExtentTest test) {
        contentBox();
        email();
        sendInquery(test);
        form(test);

    }

}

