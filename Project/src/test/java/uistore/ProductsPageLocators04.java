package uistore;

import org.openqa.selenium.By;

public class ProductsPageLocators04 {


    public static By productPageSupplierListMenu=By.cssSelector("a[href='//www.made-in-china.com/companysearch.do?subaction=hunt&mode=and&code=0&style=b&isOpenCorrection=1&word=Electronics&comProvice=nolimit']");
    public static By consumerElectronicsCatagory=By.xpath("//a[contains(@href,'Consumer-Electronics-Catalog')]");
    public static By selectedCatagoryFilter=By.xpath("(//span[@class='refine-selected'])[1]");
    public static By iso9000= By.cssSelector("a[href='//www.made-in-china.com/company-search/Electronics/C1--CD_Consumer-Electronics-Catalog--MC_9/1.html']");
    public static By selectedIso9000=By.xpath("(//span[@class='refine-selected'])[2]");
    public static By diamondMember=By.cssSelector("a[href='//www.made-in-china.com/company-search/Electronics/C1--CD_Consumer-Electronics-Catalog--MC_9--CL_DM/1.html']");
    public static By firstProduct=By.xpath("(//h2[@class='company-name'])[1]");
    public static By diamondTextLocator=By.cssSelector("span[class='shop-sign__text']");
}
