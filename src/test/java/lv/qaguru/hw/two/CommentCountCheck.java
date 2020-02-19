package lv.qaguru.hw.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CommentCountCheck {
    private final By COMMENT_COUNT_ALL_ARTICLES_MAIN = By.xpath(".//a[contains(@class, 'comment-count')]");
    private final By ARTICLE_TITLE = By.xpath(".//h1[contains(@class, 'headline__title')]");
    private final By COMMENT_COUNT_ARTICLE_PAGE = By.xpath(".//div[contains(@class, 'article-title')]//a");
    private final By ALL_COMMENT_COMMENT_PAGE = By.xpath(".//div[contains(@class, 'top-actions')]//span[contains(@class, 'type-cnt')]");

    @Test
    public void delfiSecondTitleCommentCountTest() {
        System.setProperty("webdriver.chrome.driver", "c:/users/jevgenija.naidenko/ideaprojects/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://rus.delfi.lv");

        //Get comments count elements list
        List<WebElement> commentsCountList = driver.findElements(COMMENT_COUNT_ALL_ARTICLES_MAIN);

        //Get 2nd comment count list element
        WebElement secondArticleCommentCountMain = commentsCountList.get(1);

        String secondArticleCommentCountValueMain = secondArticleCommentCountMain.getText().replace("(", "").replace(")", "");

        Integer secondArticleCommentCountMainIntegerValue = Integer.parseInt(secondArticleCommentCountValueMain);

        //Get elements list
        List<WebElement> titleList = driver.findElements(ARTICLE_TITLE);

        //Find 2nd title element
        WebElement secondTitle = titleList.get(1);

        //Click on this element
        secondTitle.click();

        //Find article's title element
        WebElement commentCountArticlePage = driver.findElement(COMMENT_COUNT_ARTICLE_PAGE);

        String commentCountValueArticlePage = commentCountArticlePage.getText().replace("(", "").replace(")", "");

        Integer commentCountArticlePageIntegerValue = Integer.parseInt(commentCountValueArticlePage);

        //Click on this element
        commentCountArticlePage.click();

        List<WebElement> commentsListOnCommentPage = driver.findElements(ALL_COMMENT_COMMENT_PAGE);

        WebElement unregisteredClientsCommentCount = commentsListOnCommentPage.get(0);

        WebElement registeredClientsCommentCount = commentsListOnCommentPage.get(1);

        String unregisteredClientsCommentCountValue = unregisteredClientsCommentCount.getText().replace("(", "").replace(")", "");

        String registeredClientsCommentCountValue = registeredClientsCommentCount.getText().replace("(", "").replace(")", "");

        Integer commentsCountCommentsPageIntegerValue =  Integer.parseInt(unregisteredClientsCommentCountValue) + Integer.parseInt(registeredClientsCommentCountValue);



        //Check
        Assertions.assertEquals(secondArticleCommentCountMainIntegerValue, commentCountArticlePageIntegerValue, "Main page comments count and article page comments count doesn't macth!");
        Assertions.assertEquals(secondArticleCommentCountMainIntegerValue, commentsCountCommentsPageIntegerValue, "Main page comments count and comments count on comments page doesn't match!");
        Assertions.assertEquals(commentsCountCommentsPageIntegerValue, commentCountArticlePageIntegerValue, "Article page comments count and comments count on the comments page doesn't match");

    }
}
