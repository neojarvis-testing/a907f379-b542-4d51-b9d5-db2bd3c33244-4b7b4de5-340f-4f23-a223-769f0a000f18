package pages;



import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.CategoriesPageLocators;
import uistore.HomePageLocators;
import uistore.ProductsPageLocators;
import utils.ExcelFileHandler;
import utils.HelperUtility;
import utils.LogHelper;
import utils.ReportGenerator;
import utils.Root;
import utils.ScreenCapture;
import utils.WaitFor;

public class HomePageActions {
     public HelperUtility helper;
     public WebDriver driver;

     public HomePageActions(WebDriver driver){
        this.driver=driver;
        this.helper=new HelperUtility(driver);
     }

    /**
     * Author: Sushil Lodhi
     */
    public void closePopup(){
        helper.performClick(HomePageLocators.homepagePopUpcloseButton);
        LogHelper.info(Root.prop.getProperty("closePopupLog"));
    }


    

    /**
     * Author: Sushil Lodhi
     */
    public void verifyMadeInChinaLogo(){
          Assert.assertTrue(helper.isWebElementElementDisplayed(HomePageLocators.homePageLogo));
          LogHelper.info("click"+helper.retrieveDomAttribute(HomePageLocators.homePageLogoLink, "href"));
    }

    

    /**
     * Author: Sushil Lodhi
     * @param productName
     */
    public void searchProductInSearchBar(String productName){
        helper.performClick(HomePageLocators.homePageSearchBar);
        LogHelper.info(helper.retrieveDomAttribute(HomePageLocators.homePageSearchBar, "placeholder"));
        helper.enterText(HomePageLocators.homePageSearchBar, productName);
        LogHelper.info("enter value"+productName);
        helper.performClick(HomePageLocators.homePageSearchButton);
        LogHelper.info(helper.getCurrentMethodName()+" on "+HomePageLocators.homePageSearchButton);
        LogHelper.info(Thread.currentThread().getStackTrace().toString());
    } 


    public void homePageHoverOverBuyer(){
        helper.mouseHover(HomePageLocators.homePageBuyerDropdownMenu);

    }

    public void clickOnProductDirectory(){
        helper.performClick(HomePageLocators.homePageBuyerproductDirectory);
        helper.switchToWindow(1);
    }

   public void LightsLighting(ExtentTest test) {
      helper.mouseHover(HomePageLocators.homePageLightligthing);
      LogHelper.info("hover over" + helper.retrieveText(HomePageLocators.homePageLightligthing));
      test.log(Status.INFO, "hover over" + helper.retrieveText(HomePageLocators.homePageLightligthing));
   }

   public void Ledtube(ExtentTest test) {
      helper.mouseHover(HomePageLocators.homePageledtube);
      helper.performClick(HomePageLocators.homePageledtube);

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
            String expectedURL = ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet6", i - 1, 1);
            helper.verifyAcutalAndExpected(expectedURL, actualURL);
            String actualTitle = Root.driver.getTitle();
            String expectedTitle = ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet6", i - 1, 2);
            helper.verifyAcutalAndExpected(expectedTitle, actualTitle);
            Root.driver.close();
            helper.switchToWindow(0);
         }
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }
   }

public void searchProductInSearchBar() {
    try {
        helper.performClick(HomePageLocators.homePageSearchBar);
        LogHelper.info("Clicked on HomePageSearchBar");
        String productName = ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet3", 0, 0);
        helper.enterText(HomePageLocators.homePageSearchBar, productName);
        LogHelper.info("Entered Value inside the SearchBar");
        helper.performClick(HomePageLocators.homePageSearchButton);
        LogHelper.info("Click Action done on SearchBar");
    } catch (Exception e) {
        e.printStackTrace();
        LogHelper.error("Error Caught");
    }
}

public void searchWires(ExtentTest test) {
    try {
        String excelSheetPath = Root.prop.getProperty("excelpath");

        String searchValue = ExcelFileHandler.getCellData(excelSheetPath, "Sheet2", 1, 0);

        helper.performClick(HomePageLocators.homePageSearchBar);
        helper.enterText(HomePageLocators.homePageSearchBar, searchValue);
        helper.performEnter(HomePageLocators.homePageSearchBar);

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


////////////////




    ///////////

public void hoverBuyerLink(ExtentTest test) {
    helper.mouseHover(HomePageLocators.menuBarBuyerLink);
    String buyerLinkText = helper.retrieveText(HomePageLocators.menuBarBuyerLink);
    LogHelper.info("hover on " + buyerLinkText);
    test.log(Status.INFO, "hover on " + buyerLinkText);
}

public void clickNewUserGuide(ExtentTest test) {
    helper.performClick(HomePageLocators.menuBarNewUserGuideLink);
    String newUserGuideLinkText = helper.retrieveText(HomePageLocators.menuBarNewUserGuideLink);
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

    helper.performClick(HomePageLocators.homePageLogo);

    LogHelper.info("switched to new window - " + currentPageTitle);
    LogHelper.info("page title verified - " + currentPageTitle);
    test.log(Status.INFO, "switched to new window - " + currentPageTitle);
    test.log(Status.INFO, "page title verified - " + currentPageTitle);
}

public void clickAuditedSupplier(ExtentTest test) {
    helper.performClick(HomePageLocators.menuBarAuditedSuppliersLink);
    String auditedSuplierLinkText = helper.retrieveText(HomePageLocators.menuBarAuditedSuppliersLink);
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

    helper.performClick(HomePageLocators.homePageLogo);

    LogHelper.info("page title verified - " + currentPageTitle);
    test.log(Status.INFO, "page title verified - " + currentPageTitle);
}

public void clickMeetSupplierLink(ExtentTest test) {
    helper.performClick(HomePageLocators.menuBarMeetSuppliersLink);
    String meetSupplierLinkText = helper.retrieveText(HomePageLocators.menuBarMeetSuppliersLink);

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

    helper.performClick(HomePageLocators.homePageLogo);

    LogHelper.info("page title verified - " + currentPageTitle);
    test.log(Status.INFO, "page title verified - " + currentPageTitle);

}


public void RegisterSignIn(ExtentTest test) {
        helper.mouseHover(HomePageLocators.homepageSignIn);
        LogHelper.info("Hovering on signin");
        helper.mouseHover(HomePageLocators.homepagejoinfree);
        LogHelper.info("Hovering on joinfree");
        helper.performClick(HomePageLocators.homepagejoinfree);
        LogHelper.info("Clicked on joinfree");
        helper.switchToNewWindow();
    }

    public void sendData(ExtentTest test) throws InterruptedException {

        helper.mouseHover(HomePageLocators.registerPageEmail);
        LogHelper.info("Hovering on Email input box");
        test.log(Status.INFO, "Hovering on Email input box");
        helper.performClick(HomePageLocators.registerPageEmail);
        LogHelper.info("Clicked on Email input box ");
        test.log(Status.INFO, "Clicked on Email input box");
        String text=ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"),"Sheet5", 0, 0);
        LogHelper.info("Read data from Excel");
        test.log(Status.INFO, "Read data from Excel");
        helper.enterText(HomePageLocators.registerPageEmailinput,text);
        helper.performClick(HomePageLocators.registerPageAgree);
        LogHelper.info("Clicked on Agree ");
        test.log(Status.INFO, "Clicked on Agree");
        test.log(Status.FAIL, "failed");
        ReportGenerator.addScreenshotToReport("signinpage", test, "failed");

    }

    
    public void navigateBack(ExtentTest test){
        helper.mouseHover(HomePageLocators.homepageBuyer);
        LogHelper.info("Hovering on Buyer");
        test.log(Status.INFO, "Hovering on Buyer");
        helper.performClick(HomePageLocators.homepageNewUserGuide);
        LogHelper.info("Clicked on Newuserguide");
        test.log(Status.INFO, "Clicked on Newuserguide");
        helper.switchToNewWindow();
        LogHelper.info("Switched to new Tab");
        test.log(Status.INFO, "Switched to new Tab");
        String userUrl=Root.driver.getCurrentUrl();
        LogHelper.info("Getting url from current window");
        test.log(Status.INFO, "Getting url from current window");
        String text=ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"),"Sheet5", 1, 0);
        if(userUrl.contains(text)){
            Assert.assertTrue(true);
        }
        LogHelper.info("Verified the url");
        test.log(Status.INFO, "Verified the url");
        helper.performClick(HomePageLocators.homepageReturnBack);
        LogHelper.info("Returning back to homepage");
        test.log(Status.INFO, "Returning back to homepage");
        helper.mouseHover(HomePageLocators.homepageBuyer);
        helper.performClick(HomePageLocators.homepageAuditedSuppliersReports);
        LogHelper.info("Clicked on AuditedSupplierReports");
        test.log(Status.INFO, "Clicked on AuditedSupplierReports");
        helper.switchToNewWindow();
        LogHelper.info("Switched to new Tab");
        test.log(Status.INFO, "Switched to new Tab");
        String asrUrl=Root.driver.getCurrentUrl();
        String text1=ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"),"Sheet5", 2, 0);
        if(asrUrl.contains(text1)){
            Assert.assertTrue(true);
        }
        LogHelper.info("Verified the Url");
        test.log(Status.INFO, "Verified the Url");
        helper.performClick(HomePageLocators.homepageReturnBack);
        helper.mouseHover(HomePageLocators.homepageBuyer);
        helper.performClick(HomePageLocators.homepageMeetSuppliers);
        LogHelper.info("Clicked on MeetPageSuppliers");
        test.log(Status.INFO, "Clicked on MeetPageSuppliers");
        helper.switchToNewWindow();
        String meetUrl=Root.driver.getCurrentUrl();
        String text2=ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"),"Sheet5", 3, 0);
        if(meetUrl.contains(text2)){
            Assert.assertTrue(true);
        }
        LogHelper.info("Verified the url");
        test.log(Status.INFO, "Verified the url");
        helper.performClick(HomePageLocators.homepageReturnBack);
        LogHelper.info("Returning back to homepage");
        test.log(Status.INFO, "Returning back to homepage");
        ScreenCapture.takePageScreenShot("Homepage");
    }


    public void hoverOverSignInIcon(ExtentTest test) {
        try{
        helper.mouseHover(HomePageLocators.homepageNavbarSignInIcon);
        LogHelper.info("Hover  on " + helper.retrieveText(HomePageLocators.homepageNavbarSignInIcon) + " Icon");
        test.log(Status.INFO, "Hover on " + helper.retrieveText(HomePageLocators.homepageNavbarSignInIcon) + " Icon");
        }
        catch(Exception e){
            LogHelper.info(e.getMessage());
        }
    }
 
    public void clickOnJoinFreeButton(ExtentTest test) {
        helper.performClick(HomePageLocators.homepageNavbarJoinFreeButton);
        helper.switchToNewWindow();
    }
 
    public void clickOnManufacturingLink(ExtentTest test) {
try{
        helper.performClick(HomePageLocators.homePageSideBarCategoryManufacturingLink);
        LogHelper.info("Click On "+helper.retrieveText(CategoriesPageLocators.categoriesPageSideBarCategoryNameLabel)+" Link");
        test.log(Status.INFO, "Click On "+helper.retrieveText(CategoriesPageLocators.categoriesPageSideBarCategoryNameLabel) );
        helper.verifyAcutalAndExpected(ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet4", 7, 1),
               helper.retrieveText(CategoriesPageLocators.categoriesPageSideBarCategoryNameLabel));
        Thread.sleep(2000);
        helper.performClick(HomePageLocators.homePageMadeInChinaLogo);
}catch(Exception e){
    LogHelper.info(e.getMessage());
}
       
    }
 
    public void clickConsumerLink(ExtentTest test) {
        try{
        helper.performClick(HomePageLocators.homePageSideBarCategoryConsumerLink);
        LogHelper.info("Click On "+helper.retrieveText(CategoriesPageLocators.categoriesPageSideBarCategoryNameLabel)+" Link");
        test.log(Status.INFO, "Click On "+helper.retrieveText(CategoriesPageLocators.categoriesPageSideBarCategoryNameLabel) );
        ReportGenerator.addScreenshotToReport(helper.retrieveText(CategoriesPageLocators.categoriesPageSideBarCategoryNameLabel), test, "Construction Link");
        helper.verifyAcutalAndExpected(ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet4", 8, 1),
                helper.retrieveText(CategoriesPageLocators.categoriesPageSideBarCategoryNameLabel));
 
                helper.performClick(HomePageLocators.homePageMadeInChinaLogo);
        }catch(Exception e){
            LogHelper.info(e.getMessage());
        }
    }
    public void clickOnIndustrialLink() {
        try{
        helper.performClick(HomePageLocators.homePageSideBarCategoryIndustrialLink);
        LogHelper.info("Click On "+helper.retrieveText(CategoriesPageLocators.categoriesPageSideBarCategoryNameLabel)+" Link");
        helper.verifyAcutalAndExpected(ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet4", 9, 1),
                helper.retrieveText(CategoriesPageLocators.categoriesPageSideBarCategoryNameLabel));
                helper.performClick(HomePageLocators.homePageMadeInChinaLogo);
        }catch(Exception e){
            LogHelper.info(e.getMessage());
        }
    }
 
    public void clickOnElectrialLink() {
        try{
        helper.performClick(HomePageLocators.homePageSideBarCategoryElectrialLink);
        LogHelper.info("Click On "+helper.retrieveText(CategoriesPageLocators.categoriesPageSideBarCategoryNameLabel)+" Link");
        helper.verifyAcutalAndExpected(
                ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet4", 10, 1),
                helper.retrieveText(CategoriesPageLocators.categoriesPageSideBarCategoryNameLabel));
                helper.performClick(HomePageLocators.homePageMadeInChinaLogo);
        }
        catch(Exception e){
            LogHelper.info(e.getMessage());
        }
    }
 
    public void clickOnConstructionLink() {
        helper.performClick(HomePageLocators.homePageSideBarCategoryConstructionLink);
        LogHelper.info("Click On "+helper.retrieveText(CategoriesPageLocators.categoriesPageSideBarCategoryNameLabel)+" Link");
        helper.verifyAcutalAndExpected(
                ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet4", 11, 1),
                helper.retrieveText(CategoriesPageLocators.categoriesPageSideBarCategoryNameLabel));
                helper.performClick(HomePageLocators.homePageMadeInChinaLogo);
     
    }
 
    public void clickOnLightIndustryLink() {
        helper.performClick(HomePageLocators.homePageSideBarCategoryLightIndustryLink);
        LogHelper.info("Click On "+helper.retrieveText(CategoriesPageLocators.categoriesPageSideBarCategoryNameLabel)+" Link");
        helper.verifyAcutalAndExpected(
                ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet4", 12, 1),
                helper.retrieveText(CategoriesPageLocators.categoriesPageSideBarCategoryNameLabel));
                helper.performClick(HomePageLocators.homePageMadeInChinaLogo);
       
    }
 
    public void clickOnAutoMotorcycleLink() {
        helper.performClick(HomePageLocators.homePageSideBarCategoryAutoMotorcycleLink);
        LogHelper.info("Click On "+helper.retrieveText(CategoriesPageLocators.categoriesPageSideBarCategoryNameLabel)+" Link");
        helper.verifyAcutalAndExpected(
                ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet4", 13, 1),
                helper.retrieveText(CategoriesPageLocators.categoriesPageSideBarCategoryNameLabel));
                helper.performClick(HomePageLocators.homePageMadeInChinaLogo);
       
    }
 
    public void clickOnApparelAccessoriesLink() {
        helper.performClick(HomePageLocators.homePageSideBarCategoryApparelAccessoriesLink);
        LogHelper.info("Click On "+helper.retrieveText(CategoriesPageLocators.categoriesPageSideBarCategoryNameLabel)+" Link");
        helper.verifyAcutalAndExpected(
                ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet4", 14, 1),
                helper.retrieveText(CategoriesPageLocators.categoriesPageSideBarCategoryNameLabel));
                helper.performClick(HomePageLocators.homePageMadeInChinaLogo);
       
    }
 
    public void clickOnLightsLightingLink() {
        helper.performClick(HomePageLocators.homePageSideBarCategoryLightsLightingLink);
        LogHelper.info("Click On "+helper.retrieveText(CategoriesPageLocators.categoriesPageSideBarCategoryNameLabel)+" Link");
        helper.verifyAcutalAndExpected(
                ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet4", 15, 1),
                helper.retrieveText(CategoriesPageLocators.categoriesPageSideBarCategoryNameLabel));
                helper.performClick(HomePageLocators.homePageMadeInChinaLogo);
       
    }
 
    public void clickOnSportingGoodsLink() {
        helper.performClick(HomePageLocators.homePageSideBarCategorySportingGoodsLink);
        LogHelper.info("Click On "+helper.retrieveText(CategoriesPageLocators.categoriesPageSideBarCategoryNameLabel)+" Link");
        helper.verifyAcutalAndExpected(
                ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet4", 16, 1),
                helper.retrieveText(CategoriesPageLocators.categoriesPageSideBarCategoryNameLabel));
                 helper.performClick(HomePageLocators.homePageMadeInChinaLogo);
       
    }
 
    public void clickOnSideBarCategoryLinks(ExtentTest test) {
        clickOnManufacturingLink( test);
        clickConsumerLink(test);
        clickOnIndustrialLink();
        clickOnElectrialLink();
        clickOnConstructionLink();
        clickOnLightIndustryLink();
        clickOnAutoMotorcycleLink();
        clickOnApparelAccessoriesLink();
        clickOnLightsLightingLink();
        clickOnSportingGoodsLink();
    }
   



    
}
