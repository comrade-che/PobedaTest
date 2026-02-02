package PobedaTest.Tests;

import PobedaTest.Pages.InfoMenu;
import PobedaTest.Pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import java.time.Duration;  // <-- Добавьте этот импорт

import static org.testng.Assert.*;

/**
***Задание №1. Page Object. Всплывающее окно***
 */

public class PobedaPop_upInfo {
    private WebDriver driver;
    private MainPage mainPage;
    private CommonUtils utils;
    private InfoMenu infoMenu;

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
        infoMenu = new InfoMenu(driver);
        utils = new CommonUtils(driver);
    }

    @Test
    public void testPageTitleAndLogo() {
        String expectedTitle = "Авиакомпания «Победа» - купить авиабилеты онлайн, дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками";
        assertEquals(mainPage.getPageTitleText(), expectedTitle);
        assertTrue(mainPage.isLogoDisplayed());
    }

    @Test
    public void testInfoMenuPopupNavigationDisplay() {
        utils.hover(InfoMenu.getInfoMenu());
        assertTrue(InfoMenu.isPopupMenuDisplayed());
    }

    @Test
    public void testToPreparationSectionDisplay() {
        utils.hover(InfoMenu.getInfoMenu());

        String popupText1 = InfoMenu.getPopupHeaderText1();
        assertEquals("Подготовка к полёту", popupText1);
        String popupText2 = InfoMenu.getPopupHeaderText2();
        assertEquals("Полезная информация", popupText2);
        String popupText3 = InfoMenu.getPopupHeaderText3();
        assertEquals("О компании", popupText3);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}