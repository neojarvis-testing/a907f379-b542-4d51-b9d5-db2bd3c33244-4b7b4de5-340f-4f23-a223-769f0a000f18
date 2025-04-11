package uistore;

import org.openqa.selenium.By;

public class ProductsPageLocators03 {

    public static By productpageClickFirstCompanyAfterSearch = By.xpath("(//h2[@class='product-name'])[1]");
    //  public static By productpageContactSupplierButton = By.xpath("//a[contains(text(),'Contact Supplier')]");
    public static By productpageContactSupplierButton=By.xpath("(//a[@class='btns button-link-contact'])[1]");
    public static By productpageVerifyProductName = By.cssSelector("h1[class='sr-proMainInfo-baseInfoH1 J-baseInfo-name']");
    public static By productpageVerifyFormIsdisplayed = By.cssSelector("form[id='J-sendInquiry-new']");
    public static By productpageTextArea = By.id("content");
    public static By productpageEmailBox = By.cssSelector("input[id='senderMail']");
    public static By productpageSendInquiry = By.xpath("(//input[@class='btn btn-main btn-big'])[1]");
    public static By productpageVerifySuccessfulMessage = By.xpath("//div[@class='ft-result__title J-msg-h1']");
    public static By productpageSendName = By.id("senderName");
    public static By productpageSendCompanyName = By.id("comName");
    public static By productpageSendMobile = By.id("senderMobile");
    public static By productpageSendInquiryNow = By.xpath("(//input[@class='btn btn-main btn-big'])[1]");
    
}
