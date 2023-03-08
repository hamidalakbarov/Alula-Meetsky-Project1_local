package net.meetsky.pages;

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

    public void clickOnTopLeftModules(String module) {
        Driver.getDriver().findElement(By.xpath("//ul[@id='appmenu']//li[@data-id='" + module.toLowerCase() + "']"));
    }
}
