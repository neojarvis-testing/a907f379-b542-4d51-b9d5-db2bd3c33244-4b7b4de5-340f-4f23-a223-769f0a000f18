package pages;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import uistore.SignInPageLocators;
import utils.ExcelFileHandler;
import utils.HelperUtility;
import utils.LogHelper;
import utils.Root;
import utils.ScreenCapture;

public class SignInPageActions {

 public WebDriver driver;
    public HelperUtility helper;
    

    public SignInPageActions(WebDriver driver){
        this.driver=driver;
        this.helper=new HelperUtility(driver);
    }

    public void clickOnLanguage(){
        try{
        helper.mouseHover(SignInPageLocators.signInPageLanguageDropdown);
        ScreenCapture.takePageScreenShot(driver.getTitle());
        }catch(Exception e){
            LogHelper.info(e.getMessage());
        }
        
    }
    public void verifySpanish(ExtentTest test)
    {
        helper.performClick(SignInPageLocators.signInPageEspanolLink);
        LogHelper.info("Click on "+helper.retrieveText(SignInPageLocators.signInPageLanguageDropdown));
        test.log(Status.INFO, "Click on "+helper.retrieveText(SignInPageLocators.signInPageLanguageDropdown));
   helper.verifyAcutalAndExpected(ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet4", 1, 1), helper.retrieveText(SignInPageLocators.signInPageLanguageDropdown));
        helper.mouseHover(SignInPageLocators.signInPageLanguageDropdown);
        ScreenCapture.takePageScreenShot(Root.driver.getTitle());
      

    }
    public void verifyFrench(ExtentTest test){
        try{
        helper.performClick(SignInPageLocators.signInPageFranceLink);
        LogHelper.info("Click on "+helper.retrieveText(SignInPageLocators.signInPageLanguageDropdown));
        test.log(Status.INFO, "Click on "+helper.retrieveText(SignInPageLocators.signInPageLanguageDropdown));
        helper.verifyAcutalAndExpected(ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet4", 2, 1), helper.retrieveText(SignInPageLocators.signInPageLanguageDropdown));
        helper.mouseHover(SignInPageLocators.signInPageLanguageDropdown);
        }catch(Exception e){
            LogHelper.info(e.getMessage());
        }
    }

    public void verifyGerman(){
        try{
        helper.performClick(SignInPageLocators.signInPageGermanLink);
        LogHelper.info("Click on "+helper.retrieveText(SignInPageLocators.signInPageLanguageDropdown));
        helper.verifyAcutalAndExpected(ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet4", 3, 1), helper.retrieveText(SignInPageLocators.signInPageLanguageDropdown));
        helper.mouseHover(SignInPageLocators.signInPageLanguageDropdown);
        }
        catch(Exception e){
            LogHelper.info(e.getMessage());
        }
    }

    public void verifyRussian()
    {
        try{
        helper.performClick(SignInPageLocators.signInPageRussianLink);
        LogHelper.info("Click on "+helper.retrieveText(SignInPageLocators.signInPageLanguageDropdown));
        helper.verifyAcutalAndExpected(ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet4", 4, 1), helper.retrieveText(SignInPageLocators.signInPageLanguageDropdown));
        helper.mouseHover(SignInPageLocators.signInPageLanguageDropdown);
        }catch(Exception e){
            LogHelper.info(e.getMessage());
        }
    }

    public void verifyJapanese(){

        try{
        helper.performClick(SignInPageLocators.signInPageJapaneseLink);
        LogHelper.info("Click on "+helper.retrieveText(SignInPageLocators.signInPageLanguageDropdown));
        helper.verifyAcutalAndExpected(ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet4", 5, 1), helper.retrieveText(SignInPageLocators.signInPageLanguageDropdown));
        helper.mouseHover(SignInPageLocators.signInPageLanguageDropdown);
        }
        catch(Exception e){
            LogHelper.info(e.getMessage());
        }
    }

    public void verifyEnglish(){
        try{
        helper.performClick(SignInPageLocators.signInPageEnglishLink);
        LogHelper.info("Click on "+helper.retrieveText(SignInPageLocators.signInPageLanguageDropdown));
        helper.verifyAcutalAndExpected(ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet4", 6, 1), helper.retrieveText(SignInPageLocators.signInPageLanguageDropdown));
        }catch(Exception e){
            LogHelper.info(e.getMessage());
        }
    }

    public void languageChange(ExtentTest test){
        clickOnLanguage();
        verifySpanish(test);
        verifyFrench(test);
        verifyGerman();
        verifyRussian();
        verifyJapanese();
        verifyEnglish();

    }

}
 