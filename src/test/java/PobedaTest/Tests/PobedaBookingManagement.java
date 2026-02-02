package PobedaTest.Tests;

import PobedaTest.Pages.BookingManagementPage;
import PobedaTest.Pages.MainPage;
import PobedaTest.Pages.SearchResultsPage;
import PobedaTest.Pages.TicketSearchBlock;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 ***Задание №3. Page Object. Результаты поиска***
 */

public class PobedaBookingManagement {
    private WebDriver driver;
    private MainPage mainPage;
    private CommonUtils utils;
    private BookingManagementPage bookingPage;
    private SearchResultsPage resultsPage;

    public static class CommonUtils {
        private WebDriver driver;
        private Actions actions;

        public CommonUtils(WebDriver driver) {
            this.driver = driver;
            this.actions = new Actions(driver);
        }

        public void hover(WebElement element) {
            actions.moveToElement(element).perform();  // perform() здесь обязателен!
        }
    }

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://pobeda.aero");

        mainPage = new MainPage(driver);
        utils = new CommonUtils(driver);
        bookingPage = new BookingManagementPage(driver);
        resultsPage = new SearchResultsPage(driver);
    }

    @Test
    public void testPageTitleAndLogo() {
        String expectedTitle = "Авиакомпания «Победа» - купить авиабилеты онлайн, дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками";
        assertEquals(mainPage.getPageTitleText(), expectedTitle);
        assertTrue(mainPage.isLogoDisplayed());
    }

    @Test
    public void testBookingNavigationAndForm() {
        // Шаг 3: Скролл и клик
        mainPage.openBookingManagement();

        Assert.assertTrue(bookingPage.isOrderNumberInputDisplayed(), "Поле 'Номер заказа' отсутствует");
        Assert.assertTrue(bookingPage.isLastNameInputDisplayed(), "Поле 'Фамилия' отсутствует");
        Assert.assertTrue(bookingPage.isSearchButtonDisplayed(), "Кнопка 'Поиск' отсутствует");
    }

    @Test
    public void testNegativeTicketSearch() {
        mainPage.openBookingManagement();

        bookingPage.searchForTicket("XXXXXX", "Qwerty");

        String expectedError = "Заказ с указанными параметрами не найден";
        String actualError = resultsPage.getErrorMessageText();

        Assert.assertEquals("Заказ с указанными параметрами не найден", expectedError, actualError);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}