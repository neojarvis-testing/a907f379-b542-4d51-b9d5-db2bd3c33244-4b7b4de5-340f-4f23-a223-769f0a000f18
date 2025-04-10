package uistore;

import org.openqa.selenium.By;

public class HomePageLocatorsTM02 {

    // TestCase4
    public static By homepagePopUpcloseButton = By.cssSelector("span[class='campaign-pop-close J-campaign-pop-close']");
    public static By homePageSearchBar = By.name("word");
    public static By homePageLogo = By.cssSelector("a[title='Manufacturers & Suppliers']");

    // TestCase7
    public static By menuBarBuyerLink = By.xpath("//a[@href='https://www.made-in-china.com/help/faq/']");
    public static By menuBarNewUserGuideLink = By.linkText("New User Guide");
    public static By menuBarAuditedSuppliersLink = By.linkText("Audited Suppliers' Reports");
    public static By menuBarMeetSuppliersLink = By.linkText("Meet Suppliers");

}
