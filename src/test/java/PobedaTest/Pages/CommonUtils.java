package PobedaTest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CommonUtils {
    private WebDriver driver;
    private Actions actions;

    public CommonUtils(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void hover(WebElement element) {
        actions.moveToElement(element).perform();
    }
}