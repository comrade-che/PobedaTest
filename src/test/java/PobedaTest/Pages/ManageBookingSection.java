package PobedaTest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// POM Файл 3
public class ManageBookingSection {
    private WebDriver driver;

    @FindBy(xpath = "//input[@placeholder='Номер заказа' or contains(@name, 'recordLocator')]")
    private WebElement orderNumberInput;

    @FindBy(xpath = "//input[@placeholder='Фамилия' or contains(@name, 'lastName')]")
    private WebElement lastNameInput;

    @FindBy(xpath = "//button[contains(text(), 'Поиск')]")
    private WebElement searchButton;

    public ManageBookingSection(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isOrderNumberFieldVisible() {
        return orderNumberInput.isDisplayed();
    }

    public boolean isLastNameFieldVisible() {
        return lastNameInput.isDisplayed();
    }

    public boolean isSearchButtonVisible() {
        return searchButton.isDisplayed();
    }

    public void searchForTicket(String orderNumber, String lastName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(orderNumberInput));

        orderNumberInput.sendKeys(orderNumber);
        lastNameInput.sendKeys(lastName);
        searchButton.click();
    }
}
