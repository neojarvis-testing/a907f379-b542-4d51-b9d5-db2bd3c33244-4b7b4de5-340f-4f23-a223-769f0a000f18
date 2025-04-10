package pages;

import org.openqa.selenium.WebDriver;

import uistore.HomePageLocators03;
import utils.ExcelFileHandler;
import utils.HelperUtility;
import utils.LogHelper;
import utils.Root;

public class HomePageActions03 {

    public WebDriver driver;
    public HelperUtility helper;

    public HomePageActions03(WebDriver driver) {
        this.driver = driver;
        this.helper = new HelperUtility(driver);
    }

    public void closePopup() {
        try {
            helper.performClick(HomePageLocators03.homepagePopUpcloseButton);
            LogHelper.info("Clicked on Close Popup Button");
            
        } catch (Exception e) {
            e.printStackTrace();
            LogHelper.error("Error Caught");
        }
    }

    public void searchProductInSearchBar() {
        try {
            helper.performClick(HomePageLocators03.homePageSearchBar);
            LogHelper.info("Clicked on HomePageSearchBar");
            String productName = ExcelFileHandler.getCellData(Root.prop.getProperty("excel"), "Sheet1", 0, 0);
            helper.enterText(HomePageLocators03.homePageSearchBar, productName);
            LogHelper.info("Entered Value inside the SearchBar");
            helper.performClick(HomePageLocators03.homePageSearchButton);
            LogHelper.info("Click Action done on SearchBar");
        } catch (Exception e) {
            e.printStackTrace();
            LogHelper.error("Error Caught");
        }
    }

}
