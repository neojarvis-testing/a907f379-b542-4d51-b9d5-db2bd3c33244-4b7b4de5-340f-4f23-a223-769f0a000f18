package uistore;

import org.openqa.selenium.By;

public class HomePageLocators06 {

    public static By homepagePopUpcloseButton = By.cssSelector("span[class='campaign-pop-close J-campaign-pop-close']");
    public static By homePageSearchBar = By.name("word");
    public static By homePageSearchButton = By.id("J-nail-search-submit");

    public static By homePageLightligthing = By.xpath("(//span[contains(text(),'Lights & Lighting')])[3]");
    public static By homePageledtube = By
            .cssSelector("a[href='//www.made-in-china.com/Lights-Lighting-Catalog/LED-Tube.html']");

}
