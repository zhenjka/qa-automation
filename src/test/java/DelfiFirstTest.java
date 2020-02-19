import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DelfiFirstTest {
    private final By ARTICLE_TITLE = By.xpath(".//h1[contains(@class, 'headline__title')]");
    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[contains(@class,'d-inline')]");

    @Test
    public void delfiFirstTitleTest() {
        System.setProperty("webdriver.chrome.driver", "c:/users/jevgenija.naidenko/ideaprojects/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://delfi.lv");

        //Find 1st title element
        WebElement firstTitle = driver.findElement(ARTICLE_TITLE);

        //Get and save this element text
        String firstTitleText = firstTitle.getText();

        //Click on this element
        firstTitle.click();

        //Find article's title element
        WebElement articleTitle = driver.findElement(ARTICLE_PAGE_TITLE);

        //Get and save this element text
        String articleTitleText = articleTitle.getText();

        //Check
        Assertions.assertEquals(firstTitleText, articleTitleText, "Wrong article title!");

    }
}
