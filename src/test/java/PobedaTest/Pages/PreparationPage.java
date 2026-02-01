package PobedaTest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PreparationPage extends BasePage {  // Исправлено: BaseNewton → BasePage

    @FindBy(how = How.TAG_NAME, using = "h2")
    private WebElement sectionTitle;

    public PreparationPage(WebDriver driver) {
        super(driver);
    }

    public String getSectionTitle() {
        return sectionTitle.getText();
    }
}