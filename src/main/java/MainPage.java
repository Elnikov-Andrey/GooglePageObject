import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    public ResultPage clickOnSearchBtn(){
        searchButton.click();
        return new ResultPage(driver);
    }

    public ResultPage result(String text) {
        this.typeWord(text);
        this.clickOnSearchBtn();
        return new ResultPage(driver);
    }
}

