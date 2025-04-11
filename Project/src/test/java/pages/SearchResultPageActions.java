package pages;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.HomePageLocators;
import uistore.SearchResultPageLocators;
import utils.ExcelFileHandler;
import utils.HelperUtility;
import utils.LogHelper;
import utils.ReportGenerator;
import utils.Root;
import utils.ScreenCapture;
import utils.WaitFor;

public class SearchResultPageActions {
    WebDriver driver;
    HelperUtility helper;
    WaitFor waitFor = new WaitFor();

    public SearchResultPageActions(WebDriver driver) {
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
        String actualText = helper.retrieveText(SearchResultPageLocators.searchResultPageWiresText);
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

            helper.isWebElementElementDisplayed(SearchResultPageLocators.searchResultPageWiresPagination);
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
            helper.performClick(SearchResultPageLocators.searchResultPageWiresFirstProduct);
            String wiresFirstProductText = helper
                    .retrieveText(SearchResultPageLocators.searchResultPageWiresFirstProduct);
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

            helper.performClick(HomePageLocators.homePageSearchBar);
            Root.driver.findElement(HomePageLocators.homePageSearchBar).clear();
            helper.enterText(HomePageLocators.homePageSearchBar, searchValue);
            helper.performEnter(HomePageLocators.homePageSearchBar);

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
        String actualText = helper.retrieveText(SearchResultPageLocators.searchResultPageFurnitureText);
        String expectedText = "Furniture";

        helper.verifyAcutalAndExpected(expectedText, actualText);

        LogHelper.info("verfied search result for " + actualText);
        test.log(Status.INFO, "verfied search result for " + actualText);
    }

    public void clickMoreLinkAndVerify(ExtentTest test) {
        helper.performClick(SearchResultPageLocators.searchResultPageFurnitureMoreLink);
        String moreLinkText = helper.retrieveText(SearchResultPageLocators.searchResultPageFurnitureMoreLink);

        LogHelper.info("click on " + moreLinkText);
        test.log(Status.INFO, "click on " + moreLinkText);
    }

    public void goToSecondPage(ExtentTest test) {

        try {
            helper.scrollOnPage(3000);
            // Thread.sleep(2000);
            helper.performClick(SearchResultPageLocators.searchResultPageFurniturePaginationPage2Link);
            String paginationPage2LinkText = helper
                    .retrieveText(SearchResultPageLocators.searchResultPageFurniturePaginationPage2Link);

            LogHelper.info("click on " + paginationPage2LinkText);
            test.log(Status.INFO, "click on " + paginationPage2LinkText);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goToHomePage(ExtentTest test) {
        helper.performClick(HomePageLocators.homePageLogo);
        LogHelper.info("click on home page logo");
        test.log(Status.INFO, "click on home page logo");
    }

}

