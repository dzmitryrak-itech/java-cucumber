package utils;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
public class JavascriptUtilities {

    public void scrollToTop(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("scroll(250, 0);");
    }

    public void scrollDown(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 4000)");
    }

    public void scrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void clickJs(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

}
