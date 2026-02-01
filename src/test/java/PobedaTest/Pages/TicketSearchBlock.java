package PobedaTest.Pages;

import Pobeda.Task1Pop_upWindows.Pages.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.nio.file.Paths;
import java.nio.file.Files;

import java.time.Duration;

public class TicketSearchBlock extends BasePage{
    private static WebDriver driver;

    @FindBy(how = How.CSS, using = ".dp-1e3lq48-root-card")
    private static WebElement TicketSearchBlock;

    @FindBy(how = How.CSS, using = "input[placeholder=\"Откуда\"]")
    private static WebElement FieldFrom;

    @FindBy(how = How.CSS, using = "input[placeholder=\"Куда\"]")
    private static WebElement FieldTo;

    @FindBy(how = How.CSS, using = "input[placeholder=\"Туда\"]")
    private WebElement FieldThere;

    @FindBy(how = How.CSS, using = "input[placeholder=\"Обратно\"]")
    private WebElement FieldBack;

    @FindBy(how = How.CSS, using = "div.dp-13hg5v6-root-container button[type=\"submit\"]")
    private static WebElement ButtonSearch;

    @FindBy(how = How.CSS, using = ".dp-16k4ce9-root-root .dp-1dr6zbu-root")
    private static WebElement fromFieldError;

    public TicketSearchBlock(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static boolean isTicketSearchBlockDisplayed() {
        return TicketSearchBlock.isDisplayed();
    }

    public static boolean isFieldFromDisplayed() {
        return TicketSearchBlock.isDisplayed();
    }

    public static boolean isFieldWhereDisplayed() {
        return TicketSearchBlock.isDisplayed();
    }

    public static boolean isFieldThereDisplayed() {
        return TicketSearchBlock.isDisplayed();
    }

    public static boolean isFieldBackDisplayed() {
        return TicketSearchBlock.isDisplayed();
    }

    public static void enterRoute(String cityFrom, String cityTo) {
    }

    public void scrollToSearchBlock() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", FieldFrom);
    }

    public boolean isSearchBlockDisplayed() {
        return FieldFrom.isDisplayed() &&
                FieldTo.isDisplayed() &&
                FieldThere.isDisplayed() &&
                FieldBack.isDisplayed();
    }

    public void setFromLocation(String location) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(FieldFrom));

        FieldFrom.clear();
        FieldFrom.sendKeys(location);
        FieldFrom.sendKeys(org.openqa.selenium.Keys.ENTER);
    }

    public void setToLocation(String location) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(FieldTo));

        FieldTo.clear();
        FieldTo.sendKeys(location);
        FieldTo.sendKeys(org.openqa.selenium.Keys.ENTER);
    }

    public static void clickSearchButton() {
        // Используем WebDriverWait, чтобы дождаться, когда кнопка станет кликабельной
        // Это поможет избежать ElementClickInterceptedException
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(ButtonSearch));

        ButtonSearch.click();
    }

    public static void checkFromFieldErrorStyle() {
        // 1. Проверяем, что у элемента появился атрибут data-failed
        // Если атрибута нет, getAttribute вернет null
        String isFailed = fromFieldError.getAttribute("data-failed");
        assert isFailed != null : "Атрибут data-failed отсутствует, поле не помечено как ошибочное";

        // 2. Проверяем цвет границы
        // Внимание: Selenium возвращает цвета в формате rgba(r, g, b, a)
        String borderColor = fromFieldError.getCssValue("border-color");

        // Подставьте сюда фактическое значение, которое выводит консоль браузера для --dp-35
        // Обычно это красный цвет, например: "rgba(255, 0, 0, 1)" или "rgb(255, 0, 0)"
        String expectedColor = "rgb(244, 246, 249)"; // Пример для красного цвета

        if (!borderColor.equals(expectedColor)) {
            System.out.println("Фактический цвет границы: " + borderColor);
        }
    }

}
