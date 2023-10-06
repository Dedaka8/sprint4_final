import static constants.Urls.*;
import static constants.Timeouts.*;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobject.MainPage;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    @Before
    public void startUp(){

        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT));
        driver.get(MAIN_PAGE_URL);
        driver.manage().window().maximize();
        MainPage mainPage = new MainPage(driver);
        mainPage.cookieButtonClick();
    }
    @After
    public void tearDown(){
        driver.quit();
    }

}
