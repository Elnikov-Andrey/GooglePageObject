import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private WebDriver driver;
    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    WebElement searchField = driver.findElement(By.name("q"));
    WebElement searchButton = driver.findElement(By.name("btnK"));

    public MainPage typeWord(String text) {
        searchField.sendKeys(text);
        return this;
    }

//    public ResultPage clickOnSearchBtn(){
//        searchButton.click();
//        return new ResultPage(driver);
//    }

    public MainPage result(String text) {
        this.typeWord(text);
        this.searchButton.click();
        return new MainPage(driver);
    }
}

