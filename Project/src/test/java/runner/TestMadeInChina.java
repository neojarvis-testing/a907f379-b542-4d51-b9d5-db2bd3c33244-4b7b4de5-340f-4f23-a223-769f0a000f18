package runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pages.CategoriesPageActions;
import pages.HomePageActions;
import pages.ProductsPageActions;
import pages.RegisteredPageActions;
import pages.SearchResultPageActions;
import pages.SendInqueryActions;
import pages.SignInPageActions;
import utils.ExcelFileHandler;
import utils.LogHelper;
import utils.ReportGenerator;
import utils.Root;

public class TestMadeInChina extends Root{
    public static ExtentReports extentreports;
    public static ExtentTest extentTest;
    public HomePageActions homePageActions;
    public ProductsPageActions productsPageActions;
    public CategoriesPageActions categoriesPageActions;
    public SearchResultPageActions searchPage;
    public SignInPageActions signInPageActions;
    public RegisteredPageActions registeredPageActions;
    public SendInqueryActions sendInqueryActions;

     @BeforeClass
    public void startReport() {
        extentreports = ReportGenerator.generateExtentReport("madeinchina");
    }
    


    @BeforeMethod
    public void preConditions(){
        if(driver==null || driver.toString().contains("null")){
            launchBrowser();
        }
           homePageActions=new HomePageActions(driver);
           productsPageActions=new ProductsPageActions(driver);
           categoriesPageActions=new CategoriesPageActions(driver);
           searchPage = new SearchResultPageActions(driver);
           signInPageActions=new SignInPageActions(driver);
           registeredPageActions=new RegisteredPageActions(driver);
           sendInqueryActions= new SendInqueryActions(driver);
           homePageActions.closePopup();

    }

    @Test(priority = 6, enabled =true)
    public void testCase01(){
         homePageActions.verifyMadeInChinaLogo();
         homePageActions.searchProductInSearchBar(ExcelFileHandler.getCellData(prop.getProperty("excelpath"), prop.getProperty("sheetname"), 1, 0));
         System.out.println("Test Case 1 Successfullll !!!!");
    }

    @Test(priority = 6, enabled =true)
    public void testCase02() throws InterruptedException{
        extentTest=extentreports.createTest("TestCaseOne");
       
        homePageActions.RegisterSignIn(extentTest);
        homePageActions.sendData(extentTest);
        System.out.println("Test Case 2 Successfullll !!!!");
    }

    @Test(priority = 3, enabled =true)
    public void testCase03() {
        try {
            extentTest = extentreports.createTest("TestCase03");
            homePageActions.searchProductInSearchBar();
            productsPageActions.productSearchAndSendInquiryForm(extentTest);
            System.out.println("Test Case 3 Successfullll !!!!");
        } catch (Exception e) {
            e.printStackTrace();
            LogHelper.error("Error Caught");
        }
    }

    @Test(priority = 4, enabled =true)
    public void testCase04() {
        extentTest = extentreports.createTest("Test Search Result For Wires And Furniture");
        
        homePageActions.searchWires(extentTest);
        

        searchPage.verifyPageRedirects(extentTest);
        searchPage.verifyWiresSearchResults(extentTest);
        searchPage.verifyPagination(extentTest);

        searchPage.clickWiresFirstProduct(extentTest);
        searchPage.searchFurniture(extentTest);
        searchPage.verifyFurnitureSearchResults(extentTest);
        
        searchPage.clickMoreLinkAndVerify(extentTest);
        searchPage.goToSecondPage(extentTest);
        searchPage.goToHomePage(extentTest);
        System.out.println("Test Case 4 Successfullll !!!!");
        
    }

    @Test(priority = 5, enabled =true)
    public void testCase5() {
        extentTest=extentreports.createTest(Thread.currentThread().getName());
        homePageActions.hoverOverSignInIcon(extentTest);
        homePageActions.clickOnJoinFreeButton(extentTest);
        registeredPageActions.clickOnSignInNowLink();
        signInPageActions.languageChange(extentTest);
        System.out.println("Test Case 5 Successfullll !!!!");
    }

    @Test(priority = 1, enabled =true)
    public void test6()
    {
        extentTest=extentreports.createTest(Thread.currentThread().getName());
        homePageActions.searchProductInSearchBar(ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet6", 0, 0));
        productsPageActions.clickOnSupplierListMenu();
        productsPageActions.clickOnProductListMenu();
        productsPageActions.clickOnLedLightAndContact(extentTest);
        sendInqueryActions.Inqueryandfillform(extentTest);
        homePageActions.hoverandclickLedtube(extentTest);
        productsPageActions.ledlighttubefilter(extentTest);
        System.out.println("Test Case 6 Successfullll !!!!");
    }




    @Test(priority = 7, enabled =true)
    public void testCase07(){
        extentTest=extentreports.createTest("TestCaseTwo");
        homePageActions.navigateBack(extentTest);
        System.out.println("Test Case 7 Successfullll !!!!");
    }

    @Test(priority = 8, enabled =true)
    public void test8()
    {
        extentTest=extentreports.createTest(Thread.currentThread().getName());
        homePageActions.hotItemsList(extentTest);
        System.out.println("Test Case 8 Successfullll !!!!");
          
    }

    @Test(priority = 9, enabled =true)
    public void testCase9()
    {
        extentTest=extentreports.createTest(Thread.currentThread().getName());
        homePageActions.clickOnSideBarCategoryLinks(extentTest);
        System.out.println("Test Case 9 Successfullll !!!!");

    }


    @Test(priority = 10, enabled =true)
    public void testCase10(){
        extentTest=extentreports.createTest(Thread.currentThread().getName());
        homePageActions.homePageHoverOverBuyer();
        homePageActions.clickOnProductDirectory();
        categoriesPageActions.iterateItemsClickAndVerify(extentTest);
        System.out.println("Test Case 10 Successfullll !!!!");
    }


    @AfterMethod
    public void postConditions(){
        if(driver!=null){
        driver.quit();
        }
    }

    @AfterClass
    public void endReport() {
        extentreports.flush();
    }
}
 