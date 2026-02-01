package PobedaTest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class InfoMenu extends BasePage {
    private static WebDriver driver;

    @FindBy(how = How.CSS, using = "a[href=\"/information\"]")
    private static WebElement infoMenu;

    @FindBy(how = How.CSS, using = "div[class=\"dp-51aygc-inner\"] div[class=\"dp-wmdw9t-root\"]")
    private static WebElement popupMenu;

    @FindBy(how = How.CSS, using = "a[href=\"/information#flight\"]")
    private static WebElement popupMenuInformationFlight;

    @FindBy(how = How.CSS, using = "a[href=\"/information#useful\"]")
    private static WebElement popupMenuInformationUseful;

    @FindBy(how = How.CSS, using = "a[href=\"/information#company\"]")
    private static WebElement popupMenuInformationCompany;

    public InfoMenu(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static WebElement getInfoMenu() {
        return infoMenu;
    }

    public void hoverOverInfoMenu() {
       infoMenu.click();
    }

    public static boolean isPopupMenuDisplayed() {
        return popupMenu.isEnabled();
    }

    public static String getPopupHeaderText1() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(popupMenuInformationFlight));
        String text = popupMenuInformationFlight.getText().trim();
        System.out.println("Текст popupMenuInformationFlight: '" + text + "'");
        return text;
    }
    public static String getPopupHeaderText2() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(popupMenuInformationUseful));
        String text = popupMenuInformationUseful.getText().trim();
        System.out.println("Текст popupMenuInformationUseful: '" + text + "'");
        return text;
    }
    public static String getPopupHeaderText3() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(popupMenuInformationCompany));
        String text = popupMenuInformationCompany.getText().trim();
        System.out.println("Текст popupMenuInformationCompany: '" + text + "'");
        return text;
    }

}
