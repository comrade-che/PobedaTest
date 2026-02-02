package PobedaTest.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage extends BasePage {
    private TicketSearchBlock ticketSearchBlock;

    @FindBy(how = How.CSS, using = "title")
    private WebElement pageTitle;

   @FindBy(how = How.CSS, using = "img[src=\"/_next/static/media/logo-rus-white.b9d69d0a.svg\"]")
    private static WebElement logo;

    // Вкладка "Управление бронированием"
    @FindBy(xpath = "(//*[@id=\"__next\"]/div[2]/main/div/div[2]/div/div[1]/div/div/button[3]/span[2])")
    private static WebElement bookingManagementButton;

    public MainPage(WebDriver driver) {
        super(driver);
        this.ticketSearchBlock = new TicketSearchBlock(driver);
    }

    public TicketSearchBlock getTicketSearchBlock() {
        return ticketSearchBlock;
    }

    public static String getPageTitleText() {
        return driver.getTitle();
    }

    public static boolean isLogoDisplayed() {
        return logo.isEnabled();
    }

    // Скролл и клик по управлению бронированием
    public void openBookingManagement() {
        // Скроллим страницу чуть ниже (как в задании)
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bookingManagementButton);
        waitVisibility(bookingManagementButton);
        bookingManagementButton.click();
    }

    public void open() {
    }
}