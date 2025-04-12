package uistore;

import org.openqa.selenium.By;

public class SignInPageLocators {
    public static By productPageSupplierListMenu=By.cssSelector("a[href='//www.made-in-china.com/companysearch.do?subaction=hunt&mode=and&code=0&style=b&isOpenCorrection=1&word=Electronics&comProvice=nolimit']");
    public static By consumerElectronicsCatagory=By.xpath("//a[contains(@href,'Consumer-Electronics-Catalog')]");
    public static By selectedCatagoryFilter=By.xpath("(//span[@class='refine-selected'])[1]");
    public static By iso9000= By.cssSelector("a[href='//www.made-in-china.com/company-search/Electronics/C1--CD_Consumer-Electronics-Catalog--MC_9/1.html']");
    public static By selectedIso9000=By.xpath("(//span[@class='refine-selected'])[2]");
    public static By diamondMember=By.cssSelector("a[href='//www.made-in-china.com/company-search/Electronics/C1--CD_Consumer-Electronics-Catalog--MC_9--CL_DM/1.html']");
    public static By firstProduct=By.xpath("(//h2[@class='company-name'])[1]");
    public static By diamondTextLocator=By.cssSelector("span[class='shop-sign__text']");
    public static By signInPageLanguageDropdown = By.xpath("//div[@class='language-switch pc-show']");
    public static By signInPageEspanolLink = By.xpath("(//a[contains(text(),'Español')])[1]");
    public static By signInPageFranceLink = By.xpath("(//a[contains(text(),'Français')])[1]");
    public static By signInPageGermanLink = By.xpath("(//a[contains(text(),'Deutsch')])[1]");
    public static By signInPageRussianLink = By.xpath("(//a[contains(text(),'Русский язык')])[1]");
    public static By signInPageJapaneseLink = By.xpath("(//a[contains(text(),'日本語')])[1]");
    public static By signInPageEnglishLink = By.xpath("(//a[contains(text(),'English')])[1]");
}
 