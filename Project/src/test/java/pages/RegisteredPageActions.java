package pages;

import org.openqa.selenium.WebDriver;

import uistore.RegisteredPageLocators;
import utils.ExcelFileHandler;
import utils.HelperUtility;
import utils.LogHelper;
import utils.Root;

public class RegisteredPageActions {

    
 public WebDriver driver;
    public HelperUtility helper;
    

    public RegisteredPageActions(WebDriver driver){
        this.driver=driver;
        this.helper=new HelperUtility(driver);
    }


public void clickOnSignInNowLink(){
try{
    helper.verifyAcutalAndExpected(ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet4", 1, 0), Root.driver.getTitle());
    helper.performClick(RegisteredPageLocators.registerPageSignInNowLink);
}catch(Exception e){
    LogHelper.info(e.getMessage());
}



}


}
