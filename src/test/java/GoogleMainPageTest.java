import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.ProtocolHandshake;

public class GoogleMainPageTest {

    private static ChromeDriver driver;
    private static MainPage mainPage;
    private static ResultPage resultPage;

    @BeforeAll
    static void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://google.com");
        mainPage = new MainPage(driver);
    }
    @AfterAll
    static void closeBrowser(){
        driver.close();
    }
    @Test
    void searchShouldReturn(){
        mainPage.result("key");
    }
}
