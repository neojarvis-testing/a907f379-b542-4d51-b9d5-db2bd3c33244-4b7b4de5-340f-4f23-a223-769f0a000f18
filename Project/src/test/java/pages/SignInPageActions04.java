package pages;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import uistore.SignInPageLocators04;
import utils.ExcelFileHandler;
import utils.HelperUtility;
import utils.LogHelper;
import utils.Root;
import utils.ScreenCapture;

public class SignInPageActions04 {

 public WebDriver driver;
    public HelperUtility helper;
    

    public SignInPageActions04(WebDriver driver){
        this.driver=driver;
        this.helper=new HelperUtility(driver);
    }

    public void clickOnLanguage(){
        try{
        helper.mouseHover(SignInPageLocators04.signInPageLanguageDropdown);
        ScreenCapture.takePageScreenShot(driver.getTitle());
        }catch(Exception e){
            LogHelper.info(e.getMessage());
        }
        
    }
    public void verifySpanish(ExtentTest test)
    {
        helper.performClick(SignInPageLocators04.signInPageEspanolLink);
        LogHelper.info("Click on "+helper.retrieveText(SignInPageLocators04.signInPageLanguageDropdown));
        test.log(Status.INFO, "Click on "+helper.retrieveText(SignInPageLocators04.signInPageLanguageDropdown));
   helper.verifyAcutalAndExpected(ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet4", 1, 1), helper.retrieveText(SignInPageLocators04.signInPageLanguageDropdown));
        helper.mouseHover(SignInPageLocators04.signInPageLanguageDropdown);
        ScreenCapture.takePageScreenShot(Root.driver.getTitle());
      

    }
    public void verifyFrench(ExtentTest test){
        try{
        helper.performClick(SignInPageLocators04.signInPageFranceLink);
        LogHelper.info("Click on "+helper.retrieveText(SignInPageLocators04.signInPageLanguageDropdown));
        test.log(Status.INFO, "Click on "+helper.retrieveText(SignInPageLocators04.signInPageLanguageDropdown));
        helper.verifyAcutalAndExpected(ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet4", 2, 1), helper.retrieveText(SignInPageLocators04.signInPageLanguageDropdown));
        helper.mouseHover(SignInPageLocators04.signInPageLanguageDropdown);
        }catch(Exception e){
            LogHelper.info(e.getMessage());
        }
    }

    public void verifyGerman(){
        try{
        helper.performClick(SignInPageLocators04.signInPageGermanLink);
        LogHelper.info("Click on "+helper.retrieveText(SignInPageLocators04.signInPageLanguageDropdown));
        helper.verifyAcutalAndExpected(ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet4", 3, 1), helper.retrieveText(SignInPageLocators04.signInPageLanguageDropdown));
        helper.mouseHover(SignInPageLocators04.signInPageLanguageDropdown);
        }
        catch(Exception e){
            LogHelper.info(e.getMessage());
        }
    }

    public void verifyRussian()
    {
        try{
        helper.performClick(SignInPageLocators04.signInPageRussianLink);
        LogHelper.info("Click on "+helper.retrieveText(SignInPageLocators04.signInPageLanguageDropdown));
        helper.verifyAcutalAndExpected(ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet4", 4, 1), helper.retrieveText(SignInPageLocators04.signInPageLanguageDropdown));
        helper.mouseHover(SignInPageLocators04.signInPageLanguageDropdown);
        }catch(Exception e){
            LogHelper.info(e.getMessage());
        }
    }

    public void verifyJapanese(){

        try{
        helper.performClick(SignInPageLocators04.signInPageJapaneseLink);
        LogHelper.info("Click on "+helper.retrieveText(SignInPageLocators04.signInPageLanguageDropdown));
        helper.verifyAcutalAndExpected(ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet4", 5, 1), helper.retrieveText(SignInPageLocators04.signInPageLanguageDropdown));
        helper.mouseHover(SignInPageLocators04.signInPageLanguageDropdown);
        }
        catch(Exception e){
            LogHelper.info(e.getMessage());
        }
    }

    public void verifyEnglish(){
        try{
        helper.performClick(SignInPageLocators04.signInPageEnglishLink);
        LogHelper.info("Click on "+helper.retrieveText(SignInPageLocators04.signInPageLanguageDropdown));
        helper.verifyAcutalAndExpected(ExcelFileHandler.getCellData(Root.prop.getProperty("excelpath"), "Sheet4", 6, 1), helper.retrieveText(SignInPageLocators04.signInPageLanguageDropdown));
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
