package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.ProductsPageLocators03;
import utils.ExcelFileHandler;
import utils.HelperUtility;
import utils.LogHelper;
import utils.ReportGenerator;
import utils.Root;
import utils.ScreenCapture;

public class ProductsPageActions03 {

    public WebDriver driver;
    public HelperUtility helper;

    public ProductsPageActions03(WebDriver driver) {
        this.driver = driver;
        this.helper = new HelperUtility(driver);
    }
    /**
     * Creator : Bharanidharan S
     * Used to Click the first Product From the Search
     */
    public void clickFirstProductCompany() {
        try {
            helper.performClick(ProductsPageLocators03.productpageClickFirstCompanyAfterSearch);
            LogHelper.info("Clicked on The First Product After Search");
            helper.switchToNewWindow();
            LogHelper.info("Window Handled From Parent To Child");
        } catch (Exception e) {
            e.printStackTrace();
            LogHelper.error("Error Caught");
        }
    }
    
    /**
     * Creator : Bharanidharan S
     * Used to verify the page title using contains
     */
    public void verifyProductDetailPageTitle() {
        try {
            String productName = Root.driver.findElement(ProductsPageLocators03.productpageVerifyProductName)
                    .getText();
                    LogHelper.info("Got the text from the Page for Assert");
            String pageTitle = Root.driver.getTitle();
            LogHelper.info("The PageTitle :" + pageTitle);
            Assert.assertTrue(pageTitle.contains(productName));
            LogHelper.info("Assertion done");
        } catch (Exception e) {
            e.printStackTrace();
            LogHelper.error("Error Caught");
        }
    }
    

    /**
     * Creator : Bharanidharan S
     * Used to Click the contact Supplier button
     */
    public void clickContactSupplier() {
        try {
            // Root.driver.switchTo().defaultContent();
            // WaitFor waitfor = new WaitFor();
            // waitfor.waitForElemetToBeVisible(ProductsPageLocators.productpageContactSupplierButton);
            LogHelper.info("Wait Has been initialised");
            helper.mouseHover(ProductsPageLocators03.productpageContactSupplierButton);
            LogHelper.info("Hovered on ContactSupplier Button");
            helper.performClick(ProductsPageLocators03.productpageContactSupplierButton);
            LogHelper.info("Clicked on ContactSupplier Button");
            helper.switchToNewWindow();
            LogHelper.info("Window Switched from First Child To the Second Child");
        } catch (Exception e) {
            e.printStackTrace();
            LogHelper.error("Error Caught");
        }
    }
    
    /**
     * Creator : Bharanidharan S
     * Used to Verify the send Inquiry form is visible
     */
    public void verifySendInquiryFormDisplayed() {
        try {
            WebElement form = Root.driver.findElement(ProductsPageLocators03.productpageVerifyFormIsdisplayed);
            LogHelper.info("Verified the Presence of Form : Send Inquiry Form");
            String errorMessage = ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet3", 6, 0);
            Assert.assertTrue(form.isDisplayed(), errorMessage);
        } catch (Exception e) {
            e.printStackTrace();
        } catch (AssertionError e) {
            e.printStackTrace();
            LogHelper.error("Error Caught");
        }
    }
    
    /**
     * Creator : Bharanidharan S
     * Used to send the data to the textarea of the form
     */
    public void sendDataToTextArea() {
        try {
            helper.performClick(ProductsPageLocators03.productpageTextArea);
            LogHelper.info("Clicked on ProductArea Content");
            String inValidData = ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet3", 1, 0);
            // String inValidData = "Size: 10x10 cm" +
            // "Application: Industrial machinery" +
            // "Specifications: Grade 304, thickness 2 mm" +
            // "Other Requirements: Need a quote for 500 units";
            helper.enterText(ProductsPageLocators03.productpageTextArea, inValidData);
            LogHelper.info("Sent the Text To Content Area");
        } catch (Exception e) {
            e.printStackTrace();
            LogHelper.error("Error Caught");
        }
    }
    
    /**
     * Creator : Bharanidharan S
     * Used to enter the email
     */
    public void enterEmail() {
        try {
            helper.performClick(ProductsPageLocators03.productpageEmailBox);
            String emailSent = ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet3", 2, 0);
            // String emailSent = "mjdtest@gmail.com";
            helper.enterText(ProductsPageLocators03.productpageEmailBox, emailSent);
            LogHelper.info("Sent The Text For Email");
        } catch (Exception e) {
            e.printStackTrace();
            LogHelper.error("Error Caught");
        }
    }
    
    /**
     * Creator : Bharanidharan S
     * Used to Click the sendInquiry Button
     */
    public void clickSendInquiry() {
        try {
            helper.performClick(ProductsPageLocators03.productpageSendInquiry);
            LogHelper.info("Clicked on Send Inquiry");
        } catch (Exception e) {
            e.printStackTrace();
            LogHelper.error("Error Caught");
        }
    }
    
    /**
     * Creator : Bharanidharan S
     * Used to send the form details
     */
    public void sendFormDetails() {
        try {
            helper.performClick(ProductsPageLocators03.productpageSendName);
            String name = ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet3", 3, 0);
            // String name = "Raja";
            helper.enterText(ProductsPageLocators03.productpageSendName, name);
            helper.performClick(ProductsPageLocators03.productpageSendCompanyName);
            // String company = "LTI";
            String company = ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet3", 4, 0);
            helper.enterText(ProductsPageLocators03.productpageSendCompanyName, company);
            helper.performClick(ProductsPageLocators03.productpageSendMobile);
            String mobile = ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet3", 5, 0);
            // String mobile = "9090909090";
            helper.enterText(ProductsPageLocators03.productpageSendMobile, mobile);
            LogHelper.info("Filled the Form");
        } catch (Exception e) {
            e.printStackTrace();
            LogHelper.error("Error Caught");
        }
    }
    
    /**
     * Creator : Bharanidharan S
     * Used to Click the sendInquiry Now After completing the Actions
     */
    public void enterSendInquiryNow(ExtentTest test) {
        try {
            helper.mouseHover(ProductsPageLocators03.productpageSendInquiryNow);
            test.log(Status.INFO,"Hovered on Send Inquiry");
            helper.performClick(ProductsPageLocators03.productpageSendInquiryNow);
            LogHelper.info("Entered SendInquiry Button");
            test.log(Status.INFO,"Entered SendInquiry Button");
            ScreenCapture.takePageScreenShot("Verification_Page");
            ReportGenerator.addScreenshotToReport("Verification_Page",test, "Final Page Of the Action");
        } catch (Exception e) {
            e.printStackTrace();
            LogHelper.error("Error Caught");
        }
    }
    
    /**
     * Creator : Bharanidharan S
     * Used to verify the successful message after filling the form
     */
    public void verifySuccessfulMessage() {
        try {
            String verifyMessage = helper.retrieveText(ProductsPageLocators03.productpageVerifySuccessfulMessage);
            helper.verifyAcutalAndExpected("Sent Successfully!", verifyMessage);
            LogHelper.info("Message got for Verification :" +verifyMessage);
            LogHelper.info("Verification done on SuccessfullMessage");
        } catch (Exception e) {
            e.printStackTrace();
            LogHelper.error("Error Caught");
        }
    }
    
    /**
     * Creator : Bharanidharan S
     * Used to combined methods to call in the runner
     */
    public void productSearchAndSendInquiryForm(ExtentTest test) {
        try {
            clickFirstProductCompany();
            verifyProductDetailPageTitle();
            clickContactSupplier();
            verifySendInquiryFormDisplayed();
            sendDataToTextArea();
            enterEmail();
            clickSendInquiry();
            sendFormDetails();
            enterSendInquiryNow(test);
            // verifySuccessfulMessage();
        } catch (Exception e) {
            e.printStackTrace();
            LogHelper.error("Error Caught");
        }
    }

}
