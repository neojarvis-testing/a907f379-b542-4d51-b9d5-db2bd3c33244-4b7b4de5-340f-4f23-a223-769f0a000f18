package pages;



import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import uistore.HomePageLocators;
import utils.HelperUtility;
import utils.LogHelper;
import utils.Root;

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
    
}
