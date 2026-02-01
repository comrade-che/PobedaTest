package PobedaTest.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage extends BasePage {
    private TicketSearchBlock ticketSearchBlock;

    @FindBy(how = How.CSS, using = "title")
    private WebElement pageTitle;

   @FindBy(how = How.CSS, using = "img[src=\"/_next/static/media/logo-rus-white.b9d69d0a.svg\"]")
    private WebElement logo;

    public MainPage(WebDriver driver) {
        super(driver);
        this.ticketSearchBlock = new TicketSearchBlock(driver);
    }

    public TicketSearchBlock getTicketSearchBlock() {
        return ticketSearchBlock;
    }

    public String getPageTitleText() {
        return driver.getTitle();
    }

    public boolean isLogoDisplayed() {
        return logo.isEnabled();
    }




}