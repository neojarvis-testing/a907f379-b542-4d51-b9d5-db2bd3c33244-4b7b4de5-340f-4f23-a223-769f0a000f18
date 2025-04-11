package pages;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.HomePageLocators06;

import utils.ExcelFileHandler;
import utils.HelperUtility;
import utils.LogHelper;
import utils.ReportGenerator;
import utils.Root;
import utils.ScreenCapture;

public class HomepageAction06 {

   public WebDriver driver;
   public HelperUtility helper;

   public HomepageAction06(WebDriver driver) {
      this.driver = driver;
      this.helper = new HelperUtility(driver);
   }

   public void closePopup() {
      helper.performClick(HomePageLocators06.homepagePopUpcloseButton);
   }

   public void searchProductInSearchBar(String productName) {
      helper.performClick(HomePageLocators06.homePageSearchBar);
      helper.enterText(HomePageLocators06.homePageSearchBar, productName);
      helper.performClick(HomePageLocators06.homePageSearchButton);
   }

   public void LightsLighting(ExtentTest test) {
      helper.mouseHover(HomePageLocators06.homePageLightligthing);
      LogHelper.info("hover over" + helper.retrieveText(HomePageLocators06.homePageLightligthing));
      test.log(Status.INFO, "hover over" + helper.retrieveText(HomePageLocators06.homePageLightligthing));
   }

   public void Ledtube(ExtentTest test) {
      helper.mouseHover(HomePageLocators06.homePageledtube);
      helper.performClick(HomePageLocators06.homePageledtube);

   }

   public void hoverandclickLedtube(ExtentTest test) {
      LightsLighting(test);
      Ledtube(test);
   }

   public void hotItemsList(ExtentTest test) {
      try {
         helper.scrollOnPage(6000);
         String parent = Root.driver.getWindowHandle();
         List<WebElement> elem = Root.driver.findElements(By.xpath("//div[@class='hot-item']/a"));
         for (int i = 1; i <= 12; i++) {
            elem.get(i - 1).click();
            helper.switchToWindow(1);
            ScreenCapture.takePageScreenShot(driver.getTitle());
            ReportGenerator.addScreenshotToReport(driver.getTitle(), test, "product list");
            String actualURL = Root.driver.getCurrentUrl();
            String expectedURL = ExcelFileHandler.getCellData(Root.prop.getProperty("path"), "Sheet1", i - 1, 1);
            helper.verifyAcutalAndExpected(expectedURL, actualURL);
            String actualTitle = Root.driver.getTitle();
            String expectedTitle = ExcelFileHandler.getCellData(Root.prop.getProperty("path"), "Sheet1", i - 1, 2);
            helper.verifyAcutalAndExpected(expectedTitle, actualTitle);
            Root.driver.close();
            helper.switchToWindow(0);
         }
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }

   }
}
