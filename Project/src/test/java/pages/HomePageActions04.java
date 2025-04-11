package pages;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import uistore.CategoriesPageLocators04;
import uistore.HomePageLocators04;
import utils.ExcelFileHandler;
import utils.HelperUtility;
import utils.LogHelper;
import utils.ReportGenerator;
import utils.Root;
import utils.ScreenCapture;


public class HomePageActions04{
    
    public WebDriver driver;
    public HelperUtility helper;
    

    public HomePageActions04(WebDriver driver){
        this.driver=driver;
        this.helper=new HelperUtility(driver);
    }

    public  void closePopup() {
        try{
        helper.performClick(HomePageLocators04.homepagePopUpcloseButton);
        ScreenCapture.takePageScreenShot(driver.getTitle());
        }catch(Exception e){
            LogHelper.info(e.getMessage());
        }
    }

    public void hoverOverSignInIcon(ExtentTest test) {
        try{
        helper.mouseHover(HomePageLocators04.homepageNavbarSignInIcon);
        LogHelper.info("Hover  on " + helper.retrieveText(HomePageLocators04.homepageNavbarSignInIcon) + " Icon");
        test.log(Status.INFO, "Hover on " + helper.retrieveText(HomePageLocators04.homepageNavbarSignInIcon) + " Icon");
        }
        catch(Exception e){
            LogHelper.info(e.getMessage());
        }
    }

    public void clickOnJoinFreeButton(ExtentTest test) {
        helper.performClick(HomePageLocators04.homepageNavbarJoinFreeButton);
        helper.switchToNewWindow();
    }

    public void clickOnManufacturingLink(ExtentTest test) {
try{
        helper.performClick(HomePageLocators04.homePageSideBarCategoryManufacturingLink);
        LogHelper.info("Click On "+helper.retrieveText(CategoriesPageLocators04.categoriesPageSideBarCategoryNameLabel)+" Link");
        test.log(Status.INFO, "Click On "+helper.retrieveText(CategoriesPageLocators04.categoriesPageSideBarCategoryNameLabel) );
        helper.verifyAcutalAndExpected(ExcelFileHandler.getCellData(Root.prop.getProperty("ExcelPath"), "Sheet4", 7, 1),
               helper.retrieveText(CategoriesPageLocators04.categoriesPageSideBarCategoryNameLabel));
               helper.performClick(HomePageLocators04.homePageMadeInChinaLogo);
}catch(Exception e){
    LogHelper.info(e.getMessage());
}
        
    }

    public void clickConsumerLink(ExtentTest test) {
        try{
        helper.performClick(HomePageLocators04.homePageSideBarCategoryConsumerLink);
        LogHelper.info("Click On "+helper.retrieveText(CategoriesPageLocators04.categoriesPageSideBarCategoryNameLabel)+" Link");
        test.log(Status.INFO, "Click On "+helper.retrieveText(CategoriesPageLocators04.categoriesPageSideBarCategoryNameLabel) );
        ReportGenerator.addScreenshotToReport(helper.retrieveText(CategoriesPageLocators04.categoriesPageSideBarCategoryNameLabel), test, "Construction Link");
        helper.verifyAcutalAndExpected(ExcelFileHandler.getCellData(Root.prop.getProperty("ExcelPath"), "Sheet4", 8, 1),
                helper.retrieveText(CategoriesPageLocators04.categoriesPageSideBarCategoryNameLabel));

                helper.performClick(HomePageLocators04.homePageMadeInChinaLogo);
        }catch(Exception e){
            LogHelper.info(e.getMessage());
        }
    }
    public void clickOnIndustrialLink() {
        try{
        helper.performClick(HomePageLocators04.homePageSideBarCategoryIndustrialLink);
        LogHelper.info("Click On "+helper.retrieveText(CategoriesPageLocators04.categoriesPageSideBarCategoryNameLabel)+" Link");
        helper.verifyAcutalAndExpected(ExcelFileHandler.getCellData(Root.prop.getProperty("ExcelPath"), "Sheet4", 9, 1),
                helper.retrieveText(CategoriesPageLocators04.categoriesPageSideBarCategoryNameLabel));
                helper.performClick(HomePageLocators04.homePageMadeInChinaLogo);
        }catch(Exception e){
            LogHelper.info(e.getMessage());
        }
    }

    public void clickOnElectrialLink() {
        try{
        helper.performClick(HomePageLocators04.homePageSideBarCategoryElectrialLink);
        LogHelper.info("Click On "+helper.retrieveText(CategoriesPageLocators04.categoriesPageSideBarCategoryNameLabel)+" Link");
        helper.verifyAcutalAndExpected(
                ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet4", 10, 1),
                helper.retrieveText(CategoriesPageLocators04.categoriesPageSideBarCategoryNameLabel));
                helper.performClick(HomePageLocators04.homePageMadeInChinaLogo);
        }
        catch(Exception e){
            LogHelper.info(e.getMessage());
        }
    }

    public void clickOnConstructionLink() {
        helper.performClick(HomePageLocators04.homePageSideBarCategoryConstructionLink);
        LogHelper.info("Click On "+helper.retrieveText(CategoriesPageLocators04.categoriesPageSideBarCategoryNameLabel)+" Link");
        helper.verifyAcutalAndExpected(
                ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet4", 11, 1),
                helper.retrieveText(CategoriesPageLocators04.categoriesPageSideBarCategoryNameLabel));
                helper.performClick(HomePageLocators04.homePageMadeInChinaLogo);
      
    }

    public void clickOnLightIndustryLink() {
        helper.performClick(HomePageLocators04.homePageSideBarCategoryLightIndustryLink);
        LogHelper.info("Click On "+helper.retrieveText(CategoriesPageLocators04.categoriesPageSideBarCategoryNameLabel)+" Link");
        helper.verifyAcutalAndExpected(
                ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet4", 12, 1),
                helper.retrieveText(CategoriesPageLocators04.categoriesPageSideBarCategoryNameLabel));
                helper.performClick(HomePageLocators04.homePageMadeInChinaLogo);
       
    }

    public void clickOnAutoMotorcycleLink() {
        helper.performClick(HomePageLocators04.homePageSideBarCategoryAutoMotorcycleLink);
        LogHelper.info("Click On "+helper.retrieveText(CategoriesPageLocators04.categoriesPageSideBarCategoryNameLabel)+" Link");
        helper.verifyAcutalAndExpected(
                ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet4", 13, 1),
                helper.retrieveText(CategoriesPageLocators04.categoriesPageSideBarCategoryNameLabel));
                helper.performClick(HomePageLocators04.homePageMadeInChinaLogo);
        
    }

    public void clickOnApparelAccessoriesLink() {
        helper.performClick(HomePageLocators04.homePageSideBarCategoryApparelAccessoriesLink);
        LogHelper.info("Click On "+helper.retrieveText(CategoriesPageLocators04.categoriesPageSideBarCategoryNameLabel)+" Link");
        helper.verifyAcutalAndExpected(
                ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet4", 14, 1),
                helper.retrieveText(CategoriesPageLocators04.categoriesPageSideBarCategoryNameLabel));
                helper.performClick(HomePageLocators04.homePageMadeInChinaLogo);
       
    }

    public void clickOnLightsLightingLink() {
        helper.performClick(HomePageLocators04.homePageSideBarCategoryLightsLightingLink);
        LogHelper.info("Click On "+helper.retrieveText(CategoriesPageLocators04.categoriesPageSideBarCategoryNameLabel)+" Link");
        helper.verifyAcutalAndExpected(
                ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet4", 15, 1),
                helper.retrieveText(CategoriesPageLocators04.categoriesPageSideBarCategoryNameLabel));
                helper.performClick(HomePageLocators04.homePageMadeInChinaLogo);
        
    }

    public void clickOnSportingGoodsLink() {
        helper.performClick(HomePageLocators04.homePageSideBarCategorySportingGoodsLink);
        LogHelper.info("Click On "+helper.retrieveText(CategoriesPageLocators04.categoriesPageSideBarCategoryNameLabel)+" Link");
        helper.verifyAcutalAndExpected(
                ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet4", 16, 1),
                helper.retrieveText(CategoriesPageLocators04.categoriesPageSideBarCategoryNameLabel));
                 helper.performClick(HomePageLocators04.homePageMadeInChinaLogo);
       
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
