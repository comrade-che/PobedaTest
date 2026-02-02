package PobedaTest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookingManagementPage extends BasePage {

    // Поле "Номер заказа"
    @FindBy(xpath = "//input[@placeholder='Номер бронирования или билета' or contains(@name, 'pnr')]")
    private WebElement orderNumberInput;

    // Поле "Фамилия клиента"
    @FindBy(xpath = "//input[@placeholder='Фамилия клиента' or contains(@name, 'lastName')]")
    private WebElement lastNameInput;

    // Кнопка "Поиск"
    @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/main/div/div[2]/div/div[2]/form/div/div[3]/button/span")
    private WebElement searchButton;

    public BookingManagementPage(WebDriver driver) {
        super(driver);
    }

    // Проверка видимости поля номера заказа
    public boolean isOrderNumberInputDisplayed() {
        waitVisibility(orderNumberInput);
        return orderNumberInput.isDisplayed();
    }

    // Проверка видимости поля фамилии
    public boolean isLastNameInputDisplayed() {
        return lastNameInput.isDisplayed();
    }

    // Проверка видимости кнопки поиска
    public boolean isSearchButtonDisplayed() {
        return searchButton.isDisplayed();
    }

    // Ввод данных и поиск
    public void searchForTicket(String orderNumber, String lastName) {
        waitVisibility(orderNumberInput);
        orderNumberInput.sendKeys(orderNumber);
        lastNameInput.sendKeys(lastName);
        searchButton.click();
    }
}