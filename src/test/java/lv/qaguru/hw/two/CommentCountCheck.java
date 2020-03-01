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
    private final By COMMENT_COUNT_MAIN_PAGE = By.xpath("(//article)[2]//*[contains(@class,'comment-count')]");
    private final By ARTICLE_TITLE = By.xpath("(//article)[2]//h1");
    private final By COMMENT_COUNT_ON_TITLE_ARTICLE_PAGE = By.xpath(".//div[contains(@class, 'article-title')]//a");
    private final By COMMENT_COUNT_ARTICLE_PAGE_BOTTOM = By.xpath(".//div[contains(@class, 'top-actions')]//span[contains(@class, 'type-cnt')]");
    private final By ALL_COMMENT_COMMENT_PAGE = By.xpath(".//div[contains(@class, 'top-actions')]//span[contains(@class, 'type-cnt')]");

    @Test
    public void delfiSecondTitleCommentCountTest() {
        System.setProperty("webdriver.chrome.driver", "c:/users/jevgenija.naidenko/ideaprojects/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://rus.delfi.lv");

        WebElement secondArticleCommentCountMain = driver.findElement(COMMENT_COUNT_MAIN_PAGE);
        String secondArticleCommentCountValueMain = secondArticleCommentCountMain.getText().replace("(", "").replace(")", "").trim();
        Integer secondArticleCommentCountMainIntValue = Integer.parseInt(secondArticleCommentCountValueMain);

        driver.findElement(ARTICLE_TITLE).click();

        WebElement commentCountArticlePage = driver.findElement(COMMENT_COUNT_ON_TITLE_ARTICLE_PAGE);
        String commentCountInTitleValueArticlePage = commentCountArticlePage.getText().replace("(", "").replace(")", "");
        Integer commentCountArticlePageIntValue = Integer.parseInt(commentCountInTitleValueArticlePage);

        List<WebElement> commentCountListArticlePageBottom = driver.findElements(COMMENT_COUNT_ARTICLE_PAGE_BOTTOM);
        WebElement unregisteredCommentCountArticlePageBottom = commentCountListArticlePageBottom.get(0);
        WebElement registeredCommentCountArticlePageBottom = commentCountListArticlePageBottom.get(1);
        String unregisteredClientsCommentCountValueArticlePage = unregisteredCommentCountArticlePageBottom.getText().replace("(", "").replace(")", "").trim();
        String registeredClientsCommentCountValueArticlePage = registeredCommentCountArticlePageBottom.getText().replace("(", "").replace(")", "").trim();
        Integer commentsCountArticlePageBottomIntValue = Integer.parseInt(unregisteredClientsCommentCountValueArticlePage) + Integer.parseInt(registeredClientsCommentCountValueArticlePage);
        commentCountArticlePage.click();

        List<WebElement> commentsListOnCommentPage = driver.findElements(ALL_COMMENT_COMMENT_PAGE);
        WebElement unregisteredClientsCommentCount = commentsListOnCommentPage.get(0);
        WebElement registeredClientsCommentCount = commentsListOnCommentPage.get(1);
        String unregisteredClientsCommentCountValue = unregisteredClientsCommentCount.getText().replace("(", "").replace(")", "").trim();
        String registeredClientsCommentCountValue = registeredClientsCommentCount.getText().replace("(", "").replace(")", "").trim();
        Integer commentsCountCommentsPageIntValue = Integer.parseInt(unregisteredClientsCommentCountValue) + Integer.parseInt(registeredClientsCommentCountValue);

        Assertions.assertEquals(secondArticleCommentCountMainIntValue, commentCountArticlePageIntValue, "Main page comments count and article page comments count doesn't macth!");
//        Assertions.assertEquals(secondArticleCommentCountMainIntValue, commentsCountCommentsPageIntValue, "Main page comments count and comments count after title on comments page doesn't match!");
        Assertions.assertEquals(secondArticleCommentCountMainIntValue, commentsCountArticlePageBottomIntValue, "Main page comments count and comments count on comments page bottom doesn't match!");
        Assertions.assertEquals(commentsCountCommentsPageIntValue, commentCountArticlePageIntValue, "Article page comments count and comments count on the comments page doesn't match");
        Assertions.assertEquals(commentsCountCommentsPageIntValue, commentsCountArticlePageBottomIntValue, "Article page bottom comments count and comments count on the comments page doesn't match");
    }
}
