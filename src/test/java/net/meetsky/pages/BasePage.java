package net.meetsky.pages;

import net.meetsky.utilities.Driver;
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

    @FindBy(xpath = "//div[@class='header-right']//span")
    public List<WebElement> rightMenuApps;

    public void clickOnModule(String module) {
        leftMenuApps.stream().filter(p -> p.getText().equalsIgnoreCase(module)).forEach(c -> c.click());
        rightMenuApps.stream().filter(p -> p.getText().equalsIgnoreCase(module)).forEach(c -> c.click());
       /* boolean clicked = false;
        for (WebElement eachLeftMenuApp : leftMenuApps) {
            if (eachLeftMenuApp.getText().equalsIgnoreCase(module)) {
                eachLeftMenuApp.click();
                clicked = true;
                break;
            }
            if (false) {
                for (WebElement eachRightMenuApp : rightMenuApps) {
                    if (eachRightMenuApp.getText().equalsIgnoreCase(module)) {
                        eachRightMenuApp.click();
                        break;
                    }
                }
            }
        }*/
    }
}
