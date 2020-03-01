package lv.qaguru.hw.two;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TitlesCheck {

    private static WebDriver driver;
    private final By ARTICLE_TITLE = By.xpath("(//article)[2]//h1");
    private final By ARTICLE_PAGE_TITLE = By.xpath(".//div[contains(@class, 'article-title')]//h1");
    private final By COMMENT_PAGE_LINK = By.xpath(".//button[contains(@class, 'input-read')]");
    private final By COMMENT_PAGE_TITLE = By.xpath(".//div[@id='commentPlaceholderAnimation']//h1");

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "c:/users/jevgenija.naidenko/ideaprojects/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void delfiSecondTitleTest() {
        driver.get("http://rus.delfi.lv");

        String secondTitleTextMainPage = driver.findElement(ARTICLE_TITLE).getText().trim();
        driver.findElement(ARTICLE_TITLE).click();

        String articleTitleTextArticlePage = driver.findElement(ARTICLE_PAGE_TITLE).getText().trim();
        Assertions.assertEquals(secondTitleTextMainPage, articleTitleTextArticlePage, "Main page second article title and article page article title doesn't match!");

        driver.findElement(COMMENT_PAGE_LINK).click();

        String articleTitleTextCommentPage = driver.findElement(COMMENT_PAGE_TITLE).getAttribute("textContent").trim();

        Assertions.assertEquals(secondTitleTextMainPage, articleTitleTextCommentPage, "Main page second article title doesn't match article title on comments page!");
        Assertions.assertEquals(articleTitleTextCommentPage, articleTitleTextArticlePage, "Article page article title doesn't match article title on the comments page!");

    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
