import org.openqa.selenium.WebDriver;

public class ResultPage {

    private WebDriver driver;
    public MainPage mainPage;
    public ResultPage(WebDriver driver){
        this.driver = driver;
    }

    public ResultPage result(String text) {
        mainPage.typeWord(text);
        mainPage.clickOnSearchBtn();
        return new ResultPage(driver);
    }
}
