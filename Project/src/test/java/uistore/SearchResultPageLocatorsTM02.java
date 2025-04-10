package uistore;

import org.openqa.selenium.By;

public class SearchResultPageLocatorsTM02 {

    public static By searchResultPageWiresText = By.className("product_word");

    public static By searchResultPageWiresPagination = By.className("pager");

    public static By searchResultPageWiresFirstProduct = By.cssSelector(
            "a[title='Factory UL83 Electric Power Electrical Cable Thhn Wire 14/12/10AWG Power Aluminum Copper UL Certification Cable']");

    public static By searchResultPageFurnitureText = By.className("product_word");

    public static By searchResultPageFurnitureMoreLink = By
            .xpath("//a[@class='more-less']//span[contains(text(), 'More')]");

    public static By searchResultPageFurnitureLinks = By.xpath("//div[@class='J-tags']//a");

    public static By searchResultPageFurniturePaginationPage2Link = By.linkText("2");

}
