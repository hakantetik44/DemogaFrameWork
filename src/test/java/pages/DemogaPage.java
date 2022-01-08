package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


public class DemogaPage {

    public DemogaPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[text()='red satin round neck backless maxi dress']")
    public WebElement Article;

    @FindBy(id = "pa_color")
    public WebElement colorArticle;

    @FindBy(css = "select[name='attribute_pa_size']")
    public WebElement sizeArticle;

    @FindBy(xpath = "//button[text()='Add to cart']")
    public WebElement AddToCart;

    @FindBy(css = "div[role='alert']")
    public WebElement articleName;

    @FindBy(xpath = "//span[@class='cart-name-and-total']")
    public WebElement viewCart;

    @FindBy(css = ".cart-name-and-total bdi")
    public WebElement totalPrice;

    @FindBy(linkText = "PROCEED TO CHECKOUT")
    public WebElement buttonProceed;

    @FindBy(xpath = "//h3[text()='Billing details']")
    public WebElement billingDetails;

    @FindBy(name = "billing_first_name")
    public WebElement firstName;
    @FindBy(name = "billing_last_name")
    public WebElement lastName;

    @FindBy(id = "billing_company")
    public WebElement company;
    @FindBy(xpath = "//span[@class='select2-selection__arrow']")
    public WebElement drop;
    @FindBy(xpath = "//input[@class='select2-search__field']")
    public WebElement dropdownCountry;

    @FindBy(css = "input[name='billing_address_1']")
    public WebElement StreetAddress;
    @FindBy(css = "input[name='billing_address_2']")
    public WebElement StreetAddress2;
    @FindBy(id = "billing_postcode")
    public WebElement postcode;

    @FindBy(id = "billing_city")
    public WebElement billingCity;

    @FindBy(id = "billing_phone")
    public WebElement billingPhone;

    @FindBy(id = "billing_email")
    public WebElement billingEmail;

    @FindBy(css=".woocommerce-terms-and-conditions-checkbox-text")
    public WebElement check;

    @FindBy(xpath="//button[text()='Place order']")
    public WebElement buttonPlaceOrder;

    @FindBy(css = ".woocommerce-thankyou-order-received")
    public WebElement successMessage;


}
