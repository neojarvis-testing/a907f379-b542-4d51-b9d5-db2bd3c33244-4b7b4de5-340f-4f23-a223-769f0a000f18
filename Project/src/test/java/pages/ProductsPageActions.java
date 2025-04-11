package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.ProductsPageLocators;
import utils.ExcelFileHandler;
import utils.HelperUtility;
import utils.LogHelper;
import utils.ReportGenerator;
import utils.Root;
import utils.ScreenCapture;
import utils.WaitFor;

public class ProductsPageActions {

    // public HelperUtility helper;
    //  public WebDriver driver;

    //  public ProductsPageActions(WebDriver driver){
    //     this.driver=driver;
    //     this.helper=new HelperUtility(driver);
    //  }

    public HelperUtility helper;
    public WebDriver driver;

    public ProductsPageActions(WebDriver driver){
       this.driver=driver;
       this.helper=new HelperUtility(driver);
    }

    public void verifyElectronicsPageTitle(){
        String electronicsPageTitle=driver.getTitle();
        helper.verifyAcutalAndExpected(electronicsPageTitle, ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), Root.prop.getProperty("sheetname"), 1, 1));
    }

    public void clickOnSupplierListMenu(){
        try {
            WaitFor.waitForElemetToBeClickable(ProductsPageLocators.productPageSupplierListMenu);
            helper.performClick(ProductsPageLocators.productPageSupplierListMenu);
        } catch (Exception e) {
           e.printStackTrace();
        }
        
    }

    public void clickOnProductListMenu(){
        try {
            WaitFor.waitForElemetToBeClickable(ProductsPageLocators.productPageProductListMenu);
            helper.performClick(ProductsPageLocators.productPageProductListMenu);
        } catch (Exception e) {
           e.printStackTrace();
        }
        
    }

    public void selectConsumerElectronicsFilterandVerify(){
        WaitFor.waitForElemetToBeVisible(ProductsPageLocators.consumerElectronicsCatagory);
        WaitFor.waitForElemetToBeClickable(ProductsPageLocators.consumerElectronicsCatagory);
        helper.performClick(ProductsPageLocators.consumerElectronicsCatagory);
        driver.navigate().refresh();
        WaitFor.waitForElemetToBeVisible(ProductsPageLocators.selectedCatagoryFilter);
        verifyFilterSelected(ProductsPageLocators.selectedCatagoryFilter,ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), Root.prop.getProperty("sheetname"), 1, 2));
    }

    public void selectISO9000andVerify(){
        WaitFor.waitForElemetToBeVisible(ProductsPageLocators.iso9000);
        WaitFor.waitForElemetToBeClickable(ProductsPageLocators.iso9000);
        helper.performClick(ProductsPageLocators.iso9000);
        driver.navigate().refresh();
        WaitFor.waitForElemetToBeVisible(ProductsPageLocators.selectedIso9000);
        verifyFilterSelected(ProductsPageLocators.selectedIso9000,ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), Root.prop.getProperty("sheetname"), 2, 2));
    }

    public void selectDiamondMemberandVerify(){
        WaitFor.waitForElemetToBeVisible(ProductsPageLocators.diamondMember);
        WaitFor.waitForElemetToBeClickable(ProductsPageLocators.diamondMember);
        helper.performClick(ProductsPageLocators.diamondMember);
        driver.navigate().refresh();
        // verifyFilterSelected(ProductsPageLocators.selectedIso9000,ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), Root.prop.getProperty("sheetname"), 2, 2));
    }


  
    public void verifyFilterSelected(By expectedLocator,String verifierText){
               String expectedText=helper.retrieveText(expectedLocator);
               helper.verifyAcutalAndExpected(verifierText, expectedText);
    }

    public void clickFirstProductandVerify(){
        WaitFor.waitForElemetToBeClickable(ProductsPageLocators.firstProduct);
        helper.performClick(ProductsPageLocators.firstProduct);
        helper.switchToNewWindow();
        helper.verifyAcutalAndExpected(helper.retrieveText(ProductsPageLocators.diamondTextLocator),ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), Root.prop.getProperty("sheetname"), 3, 2));
    }


    public void ledstripLight() {
        helper.mouseHover(ProductsPageLocators.ProductsPageLEDStripLight);

        WaitFor.waitForElemetToBeVisible(ProductsPageLocators.ProductsPageLEDStripLight);
        WaitFor.waitForElemetToBeClickable(ProductsPageLocators.ProductsPageLEDStripLight);

        helper.performClick(ProductsPageLocators.ProductsPageLEDStripLight);
    }

    public void contactnow(ExtentTest test) {
        helper.performClick(ProductsPageLocators.ProductsPageLcontact);
        LogHelper.info("clicked over" + helper.retrieveText(ProductsPageLocators.ProductsPageLcontact));
        test.log(Status.INFO,
                "clicked over" + helper.retrieveText(ProductsPageLocators.ProductsPageLcontact));
    }

    public void clickOnLedLightAndContact(ExtentTest test) {
        ledstripLight();
        contactnow(test);
    }

    public void ledlighttubefilter(ExtentTest test) {
        helper.performClick(ProductsPageLocators.ProductsPageLedlight);
        LogHelper.info("clicked over" + helper.retrieveText(ProductsPageLocators.ProductsPageLedlight));
        test.log(Status.INFO, "click on casting");
        ScreenCapture.takePageScreenShot(driver.getTitle());
        LogHelper.info("navigate back to product directory");
        helper.performClick(ProductsPageLocators.ProductsPageColourtemp);
        LogHelper.info("clicked over" + helper.retrieveText(ProductsPageLocators.ProductsPageColourtemp));
        ScreenCapture.takePageScreenShot(driver.getTitle());
        ReportGenerator.addScreenshotToReport(helper.retrieveText(ProductsPageLocators.ProductsPageColourtemp), test,
                "colourtemp");

    }


    

    public void clickFirstProductCompany() {
        try {
            helper.performClick(ProductsPageLocators.productpageClickFirstCompanyAfterSearch);
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
            String productName = driver.findElement(ProductsPageLocators.productpageVerifyProductName)
                    .getText();
                    LogHelper.info("Got the text from the Page for Assert");
            String pageTitle = driver.getTitle();
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
            
            LogHelper.info("Wait Has been initialised");
            helper.mouseHover(ProductsPageLocators.productpageContactSupplierButton);
            LogHelper.info("Hovered on ContactSupplier Button");
            helper.performClick(ProductsPageLocators.productpageContactSupplierButton);
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
            WebElement form = driver.findElement(ProductsPageLocators.productpageVerifyFormIsdisplayed);
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
            helper.performClick(ProductsPageLocators.productpageTextArea);
            LogHelper.info("Clicked on ProductArea Content");
            String inValidData = ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet3", 1, 0);
            // String inValidData = "Size: 10x10 cm" +
            // "Application: Industrial machinery" +
            // "Specifications: Grade 304, thickness 2 mm" +
            // "Other Requirements: Need a quote for 500 units";
            helper.enterText(ProductsPageLocators.productpageTextArea, inValidData);
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
            helper.performClick(ProductsPageLocators.productpageEmailBox);
            String emailSent = ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet3", 2, 0);
            // String emailSent = "mjdtest@gmail.com";
            helper.enterText(ProductsPageLocators.productpageEmailBox, emailSent);
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
            helper.performClick(ProductsPageLocators.productpageSendInquiry);
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
            helper.performClick(ProductsPageLocators.productpageSendName);
            String name = ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet3", 3, 0);
            // String name = "Raja";
            helper.enterText(ProductsPageLocators.productpageSendName, name);
            helper.performClick(ProductsPageLocators.productpageSendCompanyName);
            // String company = "LTI";
            String company = ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet3", 4, 0);
            helper.enterText(ProductsPageLocators.productpageSendCompanyName, company);
            helper.performClick(ProductsPageLocators.productpageSendMobile);
            String mobile = ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet3", 5, 0);
            // String mobile = "9090909090";
            helper.enterText(ProductsPageLocators.productpageSendMobile, mobile);
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
            helper.mouseHover(ProductsPageLocators.productpageSendInquiryNow);
            test.log(Status.INFO,"Hovered on Send Inquiry");
            helper.performClick(ProductsPageLocators.productpageSendInquiryNow);
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
            String verifyMessage = helper.retrieveText(ProductsPageLocators.productpageVerifySuccessfulMessage);
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
