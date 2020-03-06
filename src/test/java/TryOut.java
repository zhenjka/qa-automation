import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.NoSuchElementException;

public class TryOut {
    private final By COMMENT_COUNT_MAIN_PAGE = By.xpath("(//article)[1]//*[contains(@class,'comment-count')]");

    @Test
    public void elementPresenceCheck() {
        System.setProperty("webdriver.chrome.driver", "c:/users/jevgenija.naidenko/ideaprojects/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://rus.delfi.lv");


//        WebElement commentCount =  driver.findElement(COMMENT_COUNT_MAIN_PAGE);

//        if (commentCount.equals(null)){
//            System.out.println("Element not present");
//        }else{
//            System.out.println("Element is present");
//        }
////
        try {
            driver.findElement(COMMENT_COUNT_MAIN_PAGE);
            System.out.println("ElementPresent");
        } catch (NoSuchElementException e) {
            System.out.println("Element not present");
        }

//        if (driver.findElement(COMMENT_COUNT_MAIN_PAGE) != null) {
//            System.out.println("Element present");
//        }else{
//            System.out.println("Element not present");
//        }


    }
}
