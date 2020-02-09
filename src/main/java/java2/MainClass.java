package java2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;



    public class MainClass {

        static WebDriver driver;
        public static void main(String[] args) {
            System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");

            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get("http://github.com");

            MainPage mainPage = new MainPage(driver);

            mainPage.register("testusername", "qweqew@cxcv.com", "qweqwe2SDD33");
        }
    }


