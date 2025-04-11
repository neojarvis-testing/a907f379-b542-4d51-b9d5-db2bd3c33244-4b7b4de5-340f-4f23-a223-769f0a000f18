package pages;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.HomePageLocatorsTM02;
import uistore.SearchResultPageLocatorsTM02;
import utils.ExcelFileHandler;
import utils.HelperUtility;
import utils.LogHelper;
import utils.ReportGenerator;
import utils.Root;
import utils.ScreenCapture;
import utils.WaitFor;

public class SearchResultPageActionsTM02 {
    WebDriver driver;
    HelperUtility helper;
    WaitFor waitFor = new WaitFor();

    public SearchResultPageActionsTM02(WebDriver driver) {
        this.driver = driver;
        this.helper = new HelperUtility(Root.driver);
    }

    public void verifyPageRedirects(ExtentTest test) {
        String actualTitle = Root.driver.getTitle();
        String expectedTitle = "Wires, China wires, wires Manufacturers, China wires catalog";

        helper.verifyAcutalAndExpected(expectedTitle, actualTitle);

        LogHelper.info("page title verified - " + actualTitle);
        // test.log(Status.INFO, "page title verified - " + actualTitle);

    }

    public void verifyWiresSearchResults(ExtentTest test) {
        String actualText = helper.retrieveText(SearchResultPageLocatorsTM02.searchResultPageWiresText);
        String expectedText = "Wires";

        helper.verifyAcutalAndExpected(expectedText, actualText);
        ScreenCapture.takePageScreenShot("WiresResultPage");
        ReportGenerator.addScreenshotToReport("WiresResultPage", test, "Search result page for Wires");

        LogHelper.info("search result verfied - " + actualText);
        test.log(Status.INFO, "search result verfied - " + actualText);
    }

    public void verifyPagination(ExtentTest test) {
        try {
            helper.scrollOnPage(2000);
            // Thread.sleep(3000);

            helper.scrollOnPage(1000);
            // Thread.sleep(3000);

            helper.isWebElementElementDisplayed(SearchResultPageLocatorsTM02.searchResultPageWiresPagination);
            ScreenCapture.takePageScreenShot("WiresResultPagePagination");
            ReportGenerator.addScreenshotToReport("WiresResultPagePagination", test,
                    "Pagination for Wires search result page");

            LogHelper.info("verified pagination");
            test.log(Status.INFO, "verified pagination");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void clickWiresFirstProduct(ExtentTest test) {

        try {

            helper.scrollOnPage(-3000);
            // Thread.sleep(2000);
            helper.performClick(SearchResultPageLocatorsTM02.searchResultPageWiresFirstProduct);
            String wiresFirstProductText = helper
                    .retrieveText(SearchResultPageLocatorsTM02.searchResultPageWiresFirstProduct);
            Thread.sleep(2000);

            ScreenCapture.takePageScreenShot("WiresResultFirstProduct");
            ReportGenerator.addScreenshotToReport("WiresResultFirstProduct", test,
                    "First Product for Wires Search Result Page");

            LogHelper.info("click on " + wiresFirstProductText);
            test.log(Status.INFO, "click on " + wiresFirstProductText);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void searchFurniture(ExtentTest test) {

        try {
            helper.switchToParentWindow();
            String excelSheetPath = Root.prop.getProperty("excelpath");
            String searchValue = ExcelFileHandler.getCellData(excelSheetPath, "Sheet2", 2, 0);
            // System.out.println(searchValue);

            helper.performClick(HomePageLocatorsTM02.homePageSearchBar);
            Root.driver.findElement(HomePageLocatorsTM02.homePageSearchBar).clear();
            helper.enterText(HomePageLocatorsTM02.homePageSearchBar, searchValue);
            helper.performEnter(HomePageLocatorsTM02.homePageSearchBar);

            LogHelper.info("click on search bar");
            LogHelper.info(searchValue + "enterd in search bar");
            LogHelper.info("searched " + searchValue);
            test.log(Status.INFO, "click on search bar");
            test.log(Status.INFO, searchValue + "enterd in search bar");
            test.log(Status.INFO, "searched " + searchValue);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void verifyFurnitureSearchResults(ExtentTest test) {
        String actualText = helper.retrieveText(SearchResultPageLocatorsTM02.searchResultPageFurnitureText);
        String expectedText = "Furniture";

        helper.verifyAcutalAndExpected(expectedText, actualText);

        LogHelper.info("verfied search result for " + actualText);
        test.log(Status.INFO, "verfied search result for " + actualText);
    }

    public void clickMoreLinkAndVerify(ExtentTest test) {
        helper.performClick(SearchResultPageLocatorsTM02.searchResultPageFurnitureMoreLink);
        String moreLinkText = helper.retrieveText(SearchResultPageLocatorsTM02.searchResultPageFurnitureMoreLink);

        LogHelper.info("click on " + moreLinkText);
        test.log(Status.INFO, "click on " + moreLinkText);
    }

    public void goToSecondPage(ExtentTest test) {

        try {
            helper.scrollOnPage(3000);
            // Thread.sleep(2000);
            helper.performClick(SearchResultPageLocatorsTM02.searchResultPageFurniturePaginationPage2Link);
            String paginationPage2LinkText = helper
                    .retrieveText(SearchResultPageLocatorsTM02.searchResultPageFurniturePaginationPage2Link);

            LogHelper.info("click on " + paginationPage2LinkText);
            test.log(Status.INFO, "click on " + paginationPage2LinkText);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goToHomePage(ExtentTest test) {
        helper.performClick(HomePageLocatorsTM02.homePageLogo);
        LogHelper.info("click on home page logo");
        test.log(Status.INFO, "click on home page logo");
    }

}
