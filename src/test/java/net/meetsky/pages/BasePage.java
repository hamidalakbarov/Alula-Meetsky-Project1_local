package net.meetsky.pages;

import net.meetsky.utilities.ConfigurationReader;
import net.meetsky.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//ul[@id='appmenu']//span")
    public List<WebElement> leftMenuApps;

    @FindBy(id = "contactsmenu")
    public WebElement contactsMenu;

    @FindBy(xpath = "//div[@class='contact']")
    public List<WebElement> contactNames;

    @FindBy(xpath = "//a[@aria-label='Search']")
    public WebElement searchMagnifier;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement searchInput;

    public void clickOnTopLeftModules(String module) {
        Driver.getDriver().findElement(By.xpath("//ul[@id='appmenu']//li[@data-id='" + module.toLowerCase() + "']")).click();
    }

    public boolean searchContentIsDisplayed() {
        String searchContent = ConfigurationReader.getProperty("searchKeyword");
        return Driver.getDriver().findElement(By.xpath("//h3[.='" + searchContent + "']")).isDisplayed();
    }
}
