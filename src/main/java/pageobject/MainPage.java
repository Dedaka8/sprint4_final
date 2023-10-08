package pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static pageobject.constants.Buttons.HEADER_ORDER_BUTTON;
import static pageobject.constants.Buttons.MIDDLE_ORDER_BUTTON;


public class MainPage {
    protected WebDriver driver;
    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    private final By headerOrderButton = By.xpath(".//div[@class='Header_Nav__AGCXC']//button[@class='Button_Button__ra12g']");
    private final By middleOrderButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");
    private final By faqQuestions = By.xpath(".//div[@class='accordion__item']");
    private final By faqAnswer = By.xpath(".//div[@class='accordion__panel' and not(@hidden)]//p");
    private final By cookieButton = By.id("rcc-confirm-button");

    public void orderButtonClick(String orderButton){
        switch (orderButton) {
            case  (HEADER_ORDER_BUTTON):
                driver.findElement(headerOrderButton).click();
                break;
            case (MIDDLE_ORDER_BUTTON):
            new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.elementToBeClickable(middleOrderButton));

                ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(middleOrderButton));
                driver.findElement(middleOrderButton).click();
                break;
            default:
                break;
        }
    }

    public void faqQuestionClick(int numberQuestion){


        WebElement question = driver.findElements(faqQuestions).get(numberQuestion);

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(question));

       ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", question);
        question.click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(faqAnswer));


    }
    public boolean checkFaqAnswer(String answer){

        return answer.equals(driver.findElement(faqAnswer).getText());
    }

    public void cookieButtonClick(){
        driver.findElement(cookieButton).click();
    }
}
