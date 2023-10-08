package pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrderPage extends MainPage{

     public OrderPage(WebDriver driver){
        super(driver);
    }

    private final By orderNameInput = By.xpath(".//input[@placeholder='* Имя']");
    private final By orderSurnameInput = By.xpath(".//input[@placeholder='* Фамилия']");

    private final By orderAddressInput = By.xpath(".//input[contains(@placeholder,'Адрес')]");
    private final By orderPhoneInput = By.xpath(".//input[contains(@placeholder,'Телефон')]");
    private final By orderMetroInput = By.xpath(".//input[contains(@placeholder,'метро')]");
    private final String metroOptionTemplate = ".//div[@class='select-search__select']//*[text()='%s']";
    private final By nextButton = By.xpath(".//div[@class='Order_NextButton__1_rCA']//Button[contains(@class,'Button_Middle__1CSJM')]");
    private final By deliveryDateInput = By.xpath(".//input[contains(@placeholder,'Когда привезти')]");
    private final By rentPeriodInput = By.xpath(".//Div[@class='Dropdown-placeholder']");
    private final By rentPeriodOptions = By.xpath(".//div[@class='Dropdown-option']");
    private final By scooterColorCheckBox = By.xpath(".//label[@class='Checkbox_Label__3wxSf']");
    private final By  commentInput = By.xpath(".//input[contains(@placeholder,'Комментарий для курьера')]");
    private final By orderMiddleButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']//button[text()='Заказать']");
    private final By confirmationYesButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']//button[text()='Да']");

    private final By orderSuccessDiv = By.xpath(".//div[text()='Заказ оформлен']");

    public void setOrderName(String orderName) {

        driver.findElement(orderNameInput).clear();
        driver.findElement(orderNameInput).sendKeys(orderName);
    }
    public void setOrderSurname(String orderSurname) {

        driver.findElement(orderSurnameInput).clear();
        driver.findElement(orderSurnameInput).sendKeys(orderSurname);
    }
    public void setOrderAddress(String orderAddress) {

        driver.findElement(orderAddressInput).clear();
        driver.findElement(orderAddressInput).sendKeys(orderAddress);
    }
    public void setOrderPhone(String orderPhone) {

        driver.findElement(orderPhoneInput).clear();
        driver.findElement(orderPhoneInput).sendKeys(orderPhone);
    }
    public void setOrderMetro(String orderMetro) {

        driver.findElement(orderMetroInput).clear();
        driver.findElement(orderMetroInput).sendKeys(orderMetro);
        driver.findElements(By.xpath(String.format(metroOptionTemplate, orderMetro))).get(0).click();

    }

    public void nextButtonClick(){
        driver.findElement(nextButton).click();
    }
    public void setOrderDate(String orderDate){
       driver.findElement(deliveryDateInput).clear();
       driver.findElement(deliveryDateInput).sendKeys(orderDate);
       driver.findElement(deliveryDateInput).sendKeys(Keys.ENTER);

    }

    public void setRentPeriod(int rentPeriod){
        driver.findElement(rentPeriodInput).click();
        driver.findElements(rentPeriodOptions).get(rentPeriod).click();
    }
    public void setScooterColor(int scooterColor){
        driver.findElements(scooterColorCheckBox).get(scooterColor).click();
    }
    public void setCommentInput(String comment){
        driver.findElement(commentInput).clear();
        driver.findElement(commentInput).sendKeys(comment);
    }
    public void clickOrderMiddleButton(){
        driver.findElement(orderMiddleButton).click();
    }
    public void clickConfirmationYesButton(){
        driver.findElement(confirmationYesButton).click();
    }

    public Boolean isDisplayedSuccessOrder(){
        return driver.findElement(orderSuccessDiv).isDisplayed();
    }
}

