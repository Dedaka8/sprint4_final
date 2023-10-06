import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobject.MainPage;
import pageobject.OrderPage;

@RunWith(Parameterized.class)
public class CheckNewOrderTest extends BaseTest {

    private final String orderName;
    private final String orderSurname;
    private final String orderAddress;
    private final String orderPhone;
    private final String orderMetro;
    private final String orderDate;
    private final int orderRentPeriod;
    private final int orderScooterColor;
    private final String orderComment;
    private final boolean expectedResult;

    public CheckNewOrderTest(String orderName, String orderSurname, String orderAddress, String orderPhone, String orderMetro,
                             String orderDate, int orderRentPeriod, int orderScooterColor, String orderComment, boolean expectedResult) {
        this.orderName = orderName;
        this.orderSurname = orderSurname;
        this.orderAddress = orderAddress;
        this.orderPhone = orderPhone;
        this.orderMetro = orderMetro;
        this.orderDate = orderDate;
        this.orderRentPeriod = orderRentPeriod;
        this.orderScooterColor = orderScooterColor;
        this.orderComment = orderComment;
        this.expectedResult = expectedResult;
    }

    // Тестовые данные
    @Parameterized.Parameters
    public static Object[][] getCredentials() {

        return new Object[][]{
                {"Иван", "Петров", "Москва", "+79175823483", "Сокольники", "15-10-2023", 1, 1,"Оставить у Вахтера", true },
                {"Петр", "Смирнов", "Москва, Черкизовская д.5", "+79258841233", "Текстильщики", "16-10-2023", 3, 0, "", true },
        };
    }

    @Test
    public void checkOrderStatusNotExistTes(){

       MainPage mainPage = new MainPage(driver);
       OrderPage orderPage = new OrderPage(driver);

       mainPage.headerOrderButtonClick();
       orderPage.setOrderName(orderName);
       orderPage.setOrderSurname(orderSurname);
       orderPage.setOrderAddress(orderAddress);
       orderPage.setOrderPhone(orderPhone);
       orderPage.setOrderMetro(orderMetro);
       orderPage.nextButtonClick();
       orderPage.setOrderDate(orderDate);
       orderPage.setRentPeriod(orderRentPeriod);
       orderPage.setScooterColor(orderScooterColor);
       orderPage.setCommentInput(orderComment);
       orderPage.clickOrderMiddleButton();
       orderPage.clickConfirmationYesButton();
       Assert.assertEquals(expectedResult,orderPage.isDisplayedSuccessOrder());
    }
}
