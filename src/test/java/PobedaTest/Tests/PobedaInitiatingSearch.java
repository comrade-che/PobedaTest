package PobedaTest.Tests;

import PobedaTest.Pages.MainPage;
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
 ***Задание №2. Page Object. Инициирование поиска***
 */

public class PobedaInitiatingSearch {
    private WebDriver driver;
    private MainPage mainPage;
    private CommonUtils utils;

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
        // Автоматически скачает и настроит chromedriver
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://pobeda.aero");

        mainPage = new MainPage(driver);
        utils = new CommonUtils(driver);
    }

    @Test
    public void testPageTitleAndLogo() {
        String expectedTitle = "Авиакомпания «Победа» - купить авиабилеты онлайн, дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками";
        assertEquals(mainPage.getPageTitleText(), expectedTitle);
        assertTrue(mainPage.isLogoDisplayed());
    }

    @Test
    public void testTicketSearchBlockDisplayed() {
        assertTrue(TicketSearchBlock.isTicketSearchBlockDisplayed());
        assertTrue(TicketSearchBlock.isFieldFromDisplayed());
        assertTrue(TicketSearchBlock.isFieldWhereDisplayed());
        assertTrue(TicketSearchBlock.isFieldThereDisplayed());
        assertTrue(TicketSearchBlock.isFieldBackDisplayed());
    }

    @Test
    public void testTicketSearchInput() {
        String cityFrom = "Москва";
        String cityTo = "Санкт-Петербург";
        TicketSearchBlock.enterRoute(cityFrom, cityTo);
        TicketSearchBlock.clickSearchButton();

        TicketSearchBlock.checkFromFieldErrorStyle();

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}