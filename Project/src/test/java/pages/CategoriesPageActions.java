package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import uistore.CategoriesPageLocators;
import utils.ExcelFileHandler;
import utils.HelperUtility;
import utils.ReportGenerator;
import utils.Root;

public class CategoriesPageActions {

    

     public HelperUtility helper;
     public WebDriver driver;

     public CategoriesPageActions(WebDriver driver){
        this.driver=driver;
        this.helper=new HelperUtility(driver);
     }


    public void iterateItemsClickAndVerify(ExtentTest test){
            List<WebElement> elements=helper.getElementsByXPath(CategoriesPageLocators.commonLocator);
            for(int i=1;i<=9;i++){
                WebElement element=Root.driver.findElement(By.xpath("(//a[@class='item-anchor'])["+i+"]"));
                element.click();
                //upto here it is working
                helper.switchToWindow(2);
                helper.verifyAcutalAndExpected(ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet1", i, 3),Root.driver.getCurrentUrl());
                Root.driver.close();
                helper.switchToWindow(1);
            }
            ReportGenerator.addScreenshotToReport("agricultural_machinery",test,"agricultural_machinery");

            
    }

}
