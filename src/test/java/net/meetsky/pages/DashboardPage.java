package net.meetsky.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DashboardPage extends BasePage {

    @FindBy(xpath = "//div[@class='contact']")
    public List<WebElement> contacts;

    public boolean verifyContactNames() {
        boolean result = true;
        if (contacts.size() >= 2) {
            for (WebElement eachContact : contacts) {
                if (!eachContact.isDisplayed()) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}
