package uistore;

import org.openqa.selenium.By;

public class HomePageLocators04 {

    public static By homepagePopUpcloseButton = By.cssSelector("span[class='campaign-pop-close J-campaign-pop-close']");
    public static By homepageNavbarSignInIcon = By.className("login-link");
    public static By homepageNavbarJoinFreeButton = By.xpath("(//a[@class='nail-btn'])[1]");
	public static By homePageMadeInChinaLogo = By.className("nail-logo-wrap"); 



    public static By homePageSideBarCategoryManufacturingLink=By.xpath("(//span[text()='Manufacturing & Processing Machinery'])[3]");
	public static By homePageSideBarCategoryConsumerLink=By.xpath("(//span[text()='Consumer Electronics'])[3]");
	public static By homePageSideBarCategoryIndustrialLink=By.xpath("(//span[text()='Industrial Equipment & Components'])[3]");
	public static By homePageSideBarCategoryElectrialLink=By.xpath("(//span[text()='Electrical & Electronics'])[3]");
	public static By homePageSideBarCategoryConstructionLink=By.xpath("(//span[text()='Construction & Decoration'])[3]");
	public static By homePageSideBarCategoryLightIndustryLink=By.xpath("(//span[text()='Light Industry & Daily Use'])[3]");
	public static By homePageSideBarCategoryAutoMotorcycleLink=By.xpath("(//span[text()='Auto, Motorcycle Parts & Accessories'])[3]");
	public static By homePageSideBarCategoryApparelAccessoriesLink=By.xpath("(//span[text()='Apparel & Accessories'])[3]");
	public static By homePageSideBarCategoryLightsLightingLink=By.xpath("(//span[text()='Lights & Lighting'])[3]");
	public static By homePageSideBarCategorySportingGoodsLink=By.xpath("(//span[text()='Sporting Goods & Recreation'])[3]");

	// sushil
	public static By homePageLogo = By.className("nail-logo-wrap");
    public static By homePageSearchBar = By.name("word");
    public static By homePageSearchButton = By.id("J-nail-search-submit");
    public static By homePageLogoLink=By.cssSelector("a[href='//www.made-in-china.com']");
 
    
 
   public static By homePageBuyerDropdownMenu=By.cssSelector("a[href='https://www.made-in-china.com/help/faq/']");
   public static By homePageBuyerproductDirectory=By.xpath("//a[text()='Product Directory']");
}
