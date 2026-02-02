package PobedaTest.Pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultsPage extends BasePage {

    // Текст ошибки
    @FindBy(how = How.CSS, using = "div.message_error")
    private WebElement errorMessage;

    @FindBy(how = How.CSS, using = "div.customCheckbox span")
    private WebElement checkBoxSubmit;

    @FindBy(how = How.CSS, using = ".formBodyItem button")
    private WebElement searchOrder;

    @FindBy(how = How.CSS, using = "div.CheckboxCaptcha-Checkbox")
    private WebElement checkBoxCaptcha;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    /*public void handleCaptchaIfPresent() {
        try {
            // Создаем отдельное ожидание с коротким тайм-аутом (например, 2-3 секунды)
            // Мы не хотим ждать стандартные 10 секунд, если капчи нет.
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));

            // Ждем видимости элемента
            shortWait.until(ExpectedConditions.visibilityOf(checkBoxCaptcha));

            // Если элемент найден и виден — кликаем
            checkBoxCaptcha.click();
            System.out.println("Капча была обнаружена и прокликена.");

        } catch (TimeoutException e) {
            // Если за 3 секунды элемент не появился — просто продолжаем тест
            System.out.println("Капча не появилась, продолжаем тест.");
        }
    }*/

    // Получение текста ошибки с явным ожиданием
    public String getErrorMessageText() {
        // Переключаемся, если открылась новая вкладка (согласно условию задания)
        switchToNewTab();

        //handleCaptchaIfPresent();

        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(checkBoxSubmit));

        checkBoxSubmit.click();
        searchOrder.click();

        waitVisibility(errorMessage);
        return errorMessage.getText();
    }
}
