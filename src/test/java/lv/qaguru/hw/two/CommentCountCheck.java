package lv.qaguru.hw.two;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CommentCountCheck {

    private static WebDriver driver;
    private final By COMMENT_COUNT_MAIN_PAGE = By.xpath("(//article)[2]//*[contains(@class,'comment-count')]");
    private final By ARTICLE_TITLE = By.xpath("(//article)[2]//h1");
    private final By COMMENT_COUNT_ON_TITLE_ARTICLE_PAGE = By.xpath(".//div[contains(@class, 'article-title')]//a");
    private final By COMMENT_COUNT_PAGE_BOTTOM_FIRST = By.xpath("(//span[contains(@class, 'type-cnt')])[1]");
    private final By COMMENT_COUNT_PAGE_BOTTOM_SECOND = By.xpath("(//span[contains(@class, 'type-cnt')])[2]");

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "c:/users/jevgenija.naidenko/ideaprojects/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void delfiSecondTitleMainPageAndArticlePageCommentCountTest() {
        driver.get("http://rus.delfi.lv");

        String presenceCheck = elementPresenceCheck(COMMENT_COUNT_MAIN_PAGE);
        if (presenceCheck != "Element is present") {
            System.out.println("Second article has no comments on the main page");
        } else {

            String secondArticleCommentCountValueMainPage = driver.findElement(COMMENT_COUNT_MAIN_PAGE).getText().replaceAll("[()]", "");
            Integer secondArticleCommentCountIntValueMainPage = Integer.parseInt(secondArticleCommentCountValueMainPage);
            driver.findElement(ARTICLE_TITLE).click();

            String commentCountValueInTitleArticlePage = driver.findElement(COMMENT_COUNT_ON_TITLE_ARTICLE_PAGE).getText().replaceAll("[()]", "");
            Integer commentCountIntValueArticlePage = Integer.parseInt(commentCountValueInTitleArticlePage);
            Integer commentsCountIntValueArticlePageBottom = getCommentsCountPageBottom();

            Assertions.assertEquals(secondArticleCommentCountIntValueMainPage, commentCountIntValueArticlePage, "Main page comments count and article pagecomments count after title doesn't match!");
            Assertions.assertEquals(secondArticleCommentCountIntValueMainPage, commentsCountIntValueArticlePageBottom, "Main page comments count and comments count on article page bottom doesn't match!");
        }
    }
//
//    @Test
//    public void delfiSecondTitleMainPageAndArticleCommentPageCommentCountTest() {
//        driver.get("http://rus.delfi.lv");
//
//        String presenceCheck = commentsPresenceCheck();
//        if (presenceCheck == "Element is not present") {
//            System.out.println("Second article has no comments on the main page");
//        } else {
//            String secondArticleCommentCountValueMainPage = driver.findElement(COMMENT_COUNT_MAIN_PAGE).getText().replaceAll("[()]", "");
//            Integer secondArticleCommentCountIntValueMainPage = Integer.parseInt(secondArticleCommentCountValueMainPage);
//            driver.findElement(COMMENT_COUNT_MAIN_PAGE).click();
//
//            Integer commentsCountIntValueCommentsPage = getCommentsCountPageBottom();
//
//
//            Assertions.assertEquals(secondArticleCommentCountIntValueMainPage, commentsCountIntValueCommentsPage, "Main page comments count and comments count on comments page doesn't match!");
//        }
//    }
//
//
//    @Test
//    public void delfiSecondTitleArticlePageAndArticleCommentPageCommentCountTest() {
//        driver.get("http://rus.delfi.lv");
//
//        driver.findElement(ARTICLE_TITLE).click();
//
//        String commentCountValueInTitleArticlePage = driver.findElement(COMMENT_COUNT_ON_TITLE_ARTICLE_PAGE).getText().replaceAll("[()]", "");
//        Integer commentCountIntValueArticlePage = Integer.parseInt(commentCountValueInTitleArticlePage);
//        Integer commentsCountIntValueArticlePageBottom = getCommentsCountPageBottom();
//
//        driver.findElement(COMMENT_COUNT_ON_TITLE_ARTICLE_PAGE).click();
//
//        Integer commentsCountIntValueCommentsPage = getCommentsCountPageBottom();
//
//        Assertions.assertEquals(commentsCountIntValueCommentsPage, commentCountIntValueArticlePage, "Article page comments count after title and comments count on the comments page doesn't match");
//        Assertions.assertEquals(commentsCountIntValueCommentsPage, commentsCountIntValueArticlePageBottom, "Article page bottom comments count and comments count on the comments page doesn't match");
//    }

    private Integer getCommentsCountPageBottom() {
        String unregisteredComments = driver.findElement(COMMENT_COUNT_PAGE_BOTTOM_FIRST).getText().replaceAll("[()]", "");
        String registeredComments = driver.findElement(COMMENT_COUNT_PAGE_BOTTOM_SECOND).getText().replaceAll("[()]", "");
        return Integer.parseInt(unregisteredComments) + Integer.parseInt(registeredComments);
        }

    private String elementPresenceCheck(By xpath) {
        try {
            driver.findElement(xpath);
            return "Element is not present";
        } catch (NoSuchElementException e) {
            return "Element is present";
        }
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}

