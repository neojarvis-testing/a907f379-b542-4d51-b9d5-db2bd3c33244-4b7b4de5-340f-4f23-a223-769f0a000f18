package pages;

import org.openqa.selenium.WebDriver;

import uistore.RegisteredPageLocators04;
import utils.ExcelFileHandler;
import utils.HelperUtility;
import utils.LogHelper;
import utils.Root;
import utils.ScreenCapture;

public class RegisteredPageActions04 {

    
 public WebDriver driver;
    public HelperUtility helper;
    

    public RegisteredPageActions04(WebDriver driver){
        this.driver=driver;
        this.helper=new HelperUtility(driver);
    }


public void clickOnSignInNowLink(){
try{
    helper.verifyAcutalAndExpected(ExcelFileHandler.getCellData(Root.prop.getProperty("ExcelPath"), "Sheet1", 1, 0), Root.driver.getTitle());
    helper.performClick(RegisteredPageLocators04.registerPageSignInNowLink);
}catch(Exception e){
    LogHelper.info(e.getMessage());
}



}


}
