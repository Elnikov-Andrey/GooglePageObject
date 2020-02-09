


    import java2.LoginPage;
    import java2.SignUpPage;
    import org.junit.jupiter.api.AfterAll;
    import org.junit.jupiter.api.Assertions;
    import org.junit.jupiter.api.BeforeAll;
    import org.junit.jupiter.api.Test;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

    public class MainPageTest {

        private WebDriver driver;
        public MainPage mainPage;

        @BeforeAll
        public void setUp(){
            System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get("http://github.com");
            mainPage = new MainPage(driver);
        }

        @Test
        public void signInTest(){
            MainPage mainPage;
            mainPage = new MainPage(driver);
            LoginPage loginPage = mainPage.clickSignIn();
            String heading = loginPage.getHeadingText();
            Assertions.assertEquals("Sign in to GitHub", heading);
        }

        @Test
        public void registerFailTest(){
            SignUpPage signUpPage = mainPage.register("testuser", "testemail", "testpass");
            String error = signUpPage.getMainErrorText();
            Assertions.assertEquals("There were problems creating your account.", error);
        }

        @Test
        public void signUpEmptyUsernameTest(){
            SignUpPage signUpPage = mainPage.register("", "mail", "pass");
            String error = signUpPage.getUsernameErrorText();
            Assertions.assertEquals("Login can't be blank", error);
        }

        @Test
        public void signUpInvalidEmailTest(){
            SignUpPage signUpPage = mainPage.register("qeqwe", "qweq", "pass");
            String error = signUpPage.getEmailErrorText();
            Assertions.assertEquals("Email is invalid or already taken", error);
        }

        @AfterAll
        public void tearDown(){
            driver.quit();
        }
    }


