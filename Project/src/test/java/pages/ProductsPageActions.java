package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import uistore.ProductsPageLocators;
import utils.ExcelFileHandler;
import utils.HelperUtility;
import utils.Root;
import utils.WaitFor;

public class ProductsPageActions {

    public HelperUtility helper;
     public WebDriver driver;

     public ProductsPageActions(WebDriver driver){
        this.driver=driver;
        this.helper=new HelperUtility(driver);
     }

    public void verifyElectronicsPageTitle(){
        String electronicsPageTitle=Root.driver.getTitle();
        helper.verifyAcutalAndExpected(electronicsPageTitle, ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), Root.prop.getProperty("sheetname"), 1, 1));
    }

    public void clickOnSupplierListMenu(){
        WaitFor.waitForElemetToBeClickable(ProductsPageLocators.productPageSupplierListMenu);
        helper.performClick(ProductsPageLocators.productPageSupplierListMenu);
    }

    // public void selectISOFilterandVerify(){
    //     WaitFor.waitForElemetToBeVisible(ProductsPageLocators.consumerElectronicsCatagory);
    //     WaitFor.waitForElemetToBeClickable(ProductsPageLocators.consumerElectronicsCatagory);
    //     helper.performClick(ProductsPageLocators.consumerElectronicsCatagory);
    //     Root.driver.navigate().refresh();
    //     WaitFor.waitForElemetToBeVisible(ProductsPageLocators.selectedCatagoryFilter);
    //     verifyFilterSelected(ProductsPageLocators.selectedCatagoryFilter,ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), Root.prop.getProperty("sheetname"), 1, 2));
    // }

    public void selectConsumerElectronicsFilterandVerify(){
        WaitFor.waitForElemetToBeVisible(ProductsPageLocators.consumerElectronicsCatagory);
        WaitFor.waitForElemetToBeClickable(ProductsPageLocators.consumerElectronicsCatagory);
        helper.performClick(ProductsPageLocators.consumerElectronicsCatagory);
        Root.driver.navigate().refresh();
        WaitFor.waitForElemetToBeVisible(ProductsPageLocators.selectedCatagoryFilter);
        verifyFilterSelected(ProductsPageLocators.selectedCatagoryFilter,ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), Root.prop.getProperty("sheetname"), 1, 2));
    }

    public void selectISO9000andVerify(){
        WaitFor.waitForElemetToBeVisible(ProductsPageLocators.iso9000);
        WaitFor.waitForElemetToBeClickable(ProductsPageLocators.iso9000);
        helper.performClick(ProductsPageLocators.iso9000);
        Root.driver.navigate().refresh();
        WaitFor.waitForElemetToBeVisible(ProductsPageLocators.selectedIso9000);
        verifyFilterSelected(ProductsPageLocators.selectedIso9000,ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), Root.prop.getProperty("sheetname"), 2, 2));
    }

    public void selectDiamondMemberandVerify(){
        WaitFor.waitForElemetToBeVisible(ProductsPageLocators.diamondMember);
        WaitFor.waitForElemetToBeClickable(ProductsPageLocators.diamondMember);
        helper.performClick(ProductsPageLocators.diamondMember);
        Root.driver.navigate().refresh();
        // verifyFilterSelected(ProductsPageLocators.selectedIso9000,ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), Root.prop.getProperty("sheetname"), 2, 2));
    }


  
    public void verifyFilterSelected(By expectedLocator,String verifierText){
               String expectedText=helper.retrieveText(expectedLocator);
               helper.verifyAcutalAndExpected(verifierText, expectedText);
    }

    public void clickFirstProductandVerify(){
        WaitFor.waitForElemetToBeClickable(ProductsPageLocators.firstProduct);
        helper.performClick(ProductsPageLocators.firstProduct);
        helper.switchToNewWindow();
        helper.verifyAcutalAndExpected(helper.retrieveText(ProductsPageLocators.diamondTextLocator),ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), Root.prop.getProperty("sheetname"), 3, 2));
    }





}
