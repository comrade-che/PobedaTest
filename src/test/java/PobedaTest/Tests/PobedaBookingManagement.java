package PobedaTest.Tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import PobedaTest.Pages.BasePage;
import PobedaTest.Pages.BookingResultPage;
import PobedaTest.Pages.ManageBookingSection;
import PobedaTest.Pages.MainPage;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

// Тестовый Файл 5
public class PobedaBookingManagement extends BasePage {

    public PobedaBookingManagement(WebDriver driver) {
        super(driver);
    }

    // Шаг 1: Before метод (открывает сайт перед каждым тестом)
    @BeforeEach
    public void setUpPage() {
        new MainPage(driver).open();
    }

    // Шаг After: Формально требуется заданием, используем для логирования или очистки
    @AfterEach
    public void tearDownPage() {
        System.out.println("Тест завершен.");
    }

    @org.testng.annotations.Test
    public void testPageTitleAndLogo() {
        String expectedTitle = "Авиакомпания «Победа» - купить авиабилеты онлайн, дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками";
        assertEquals(MainPage.getPageTitleText(), expectedTitle);
        assertTrue(MainPage.isLogoDisplayed());
    }

    @Test
    public void testManageBookingFormFields() {
        MainPage homePage = new MainPage(driver);
        ManageBookingSection bookingSection = new ManageBookingSection(driver);

        MainPage.clickManageBooking();

        Assertions.assertTrue(bookingSection.isOrderNumberFieldVisible());
        Assertions.assertTrue(bookingSection.isLastNameFieldVisible());
        Assertions.assertTrue(bookingSection.isSearchButtonVisible());
    }

    @Test
    public void testInvalidBookingSearchError() {
        MainPage MainPage = new MainPage(driver);
        ManageBookingSection bookingSection = new ManageBookingSection(driver);
        BookingResultPage resultPage = new BookingResultPage(driver);

        MainPage.clickManageBooking();
        bookingSection.searchForTicket("XXXXXX", "Qwerty");

        // Переключение вкладки (если логика сайта открывает новую)
        BookingResultPage.switchToNewTab();

        String expectedError = "Заказ с указанными параметрами не найден";
        Assertions.assertEquals(expectedError, BookingResultPage.getErrorText());
    }
}