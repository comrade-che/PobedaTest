package PobedaTest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;  // <-- Добавьте этот импорт

public class BasePage {
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // <-- Исправлено
        PageFactory.initElements(driver, this);
    }
}
