package lv.qaguru.hw.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TaskOne {
    private final By ARTICLE_TITLE = By.xpath(".//h1[contains(@class, 'headline__title')]");
    private final By ARTICLE_PAGE_TITLE = By.xpath(".//div[contains(@class, 'article-title')]//h1");
    private final By COMMENT_PAGE_LINK = By.xpath(".//button[contains(@class, 'input-read')]");
    private final By COMMENT_PAGE_TITLE = By.xpath(".//div[@id='commentPlaceholderAnimation']//h1");

    @Test
    public void delfiSecondTitleTest() {
        System.setProperty("webdriver.chrome.driver", "c:/users/jevgenija.naidenko/ideaprojects/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://rus.delfi.lv");

        //Get elements list
        List<WebElement> titleList = driver.findElements(ARTICLE_TITLE);

        //Find 2nd title element
        WebElement secondTitle = titleList.get(1);

        //Get and save this element text
        String secondTitleText = secondTitle.getText();

        //Click on this element
        secondTitle.click();

        //Find article's title element
        WebElement articleTitle = driver.findElement(ARTICLE_PAGE_TITLE);

        //Get and save this element text
        String articleTitleText = articleTitle.getText();

        //Find comment page link
        WebElement commentPageLink = driver.findElement(COMMENT_PAGE_LINK);

        //Click on this element
        commentPageLink.click();

        //Find comment page title
        WebElement commentPageTitle = driver.findElement(COMMENT_PAGE_TITLE);

        //Article title text
        String articleTitleTextCommentPage = commentPageTitle.getText();

        //Check
        Assertions.assertEquals(secondTitleText, articleTitleText, "Main page second article title and article page article title doesn't macth!");
        Assertions.assertEquals(secondTitleText, articleTitleTextCommentPage, "Main page second article title doesn't match article title on comments page!");
        Assertions.assertEquals(articleTitleTextCommentPage, articleTitleText, "Article page article title doesn't match article title on the comments page!");

    }
}
