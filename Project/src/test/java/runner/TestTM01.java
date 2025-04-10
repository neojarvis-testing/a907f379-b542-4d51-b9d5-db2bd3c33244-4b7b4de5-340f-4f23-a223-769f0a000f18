package runner;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pages.CategoriesPageActions;
import pages.HomePageActions;
import pages.ProductsPageActions;
import utils.ExcelFileHandler;
import utils.Root;

public class TestTM01 extends Root{
    public static ExtentReports reports;
    public static ExtentTest test;
    public HomePageActions homePageActions;
    public ProductsPageActions productsPageActions;
    public CategoriesPageActions categoriesPageActions;


    @BeforeMethod
    public void preConditions(){
           launchBrowser();
           homePageActions=new HomePageActions(driver);
           productsPageActions=new ProductsPageActions(driver);
           categoriesPageActions=new CategoriesPageActions(driver);
           homePageActions.closePopup();

    }

    @Test(enabled = true)
    public void testCase01(){
         homePageActions.verifyMadeInChinaLogo();
         homePageActions.searchProductInSearchBar(ExcelFileHandler.getCellData(prop.getProperty("excelpath"), prop.getProperty("sheetname"), 1, 0));
         productsPageActions.verifyElectronicsPageTitle();
         productsPageActions.clickOnSupplierListMenu();
         productsPageActions.selectConsumerElectronicsFilterandVerify();
         productsPageActions.selectISO9000andVerify();
         productsPageActions.selectDiamondMemberandVerify();
         productsPageActions.clickFirstProductandVerify();
    }

    @Test(enabled = true)
    public void testCase10(){
        homePageActions.homePageHoverOverBuyer();
        homePageActions.clickOnProductDirectory();
        categoriesPageActions.iterateItemsClickAndVerify();
    }


    @AfterMethod
    public void postConditions(){
        driver.quit();
    }
}
