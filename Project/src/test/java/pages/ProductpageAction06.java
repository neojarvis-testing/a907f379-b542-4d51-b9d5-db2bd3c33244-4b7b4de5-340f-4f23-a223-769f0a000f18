package pages;


import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.ProductsPageLocators06;

import utils.HelperUtility;
import utils.LogHelper;
import utils.ReportGenerator;
import utils.ScreenCapture;
import utils.WaitFor;

public class ProductpageAction06 {

    public WebDriver driver;
    public HelperUtility helper;

    public ProductpageAction06(WebDriver driver) {
        this.driver = driver;
        this.helper = new HelperUtility(driver);
    }

    public void ledstripLight() {
        helper.mouseHover(ProductsPageLocators06.ProductsPageLEDStripLight);

        WaitFor.waitForElemetToBeVisible(ProductsPageLocators06.ProductsPageLEDStripLight);
        WaitFor.waitForElemetToBeClickable(ProductsPageLocators06.ProductsPageLEDStripLight);

        helper.performClick(ProductsPageLocators06.ProductsPageLEDStripLight);

    }

    public void contactnow(ExtentTest test) {
        helper.performClick(ProductsPageLocators06.ProductsPageLcontact);
        LogHelper.info("clicked over" + helper.retrieveText(ProductsPageLocators06.ProductsPageLcontact));
        test.log(Status.INFO,
                "clicked over" + helper.retrieveText(ProductsPageLocators06.ProductsPageLcontact));
    }

    public void clickOnLedLightAndContact(ExtentTest test) {
        ledstripLight();
        contactnow(test);
    }

    public void ledlighttubefilter(ExtentTest test) {
        helper.performClick(ProductsPageLocators06.ProductsPageLedlight);
        LogHelper.info("clicked over" + helper.retrieveText(ProductsPageLocators06.ProductsPageLedlight));
        ScreenCapture.takePageScreenShot(driver.getTitle());
        helper.performClick(ProductsPageLocators06.ProductsPageColourtemp);
        LogHelper.info("clicked over" + helper.retrieveText(ProductsPageLocators06.ProductsPageColourtemp));
        ScreenCapture.takePageScreenShot(driver.getTitle());
        ReportGenerator.addScreenshotToReport(helper.retrieveText(ProductsPageLocators06.ProductsPageColourtemp), test,
                "colourtemp");

    }

}
