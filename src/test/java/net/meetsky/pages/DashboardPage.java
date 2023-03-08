package net.meetsky.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DashboardPage extends BasePage {

    public void verifyContactNames() {
        if (contactNames.size()>=2) {
            for (WebElement eachContactName : contactNames) {
                Assert.assertTrue(eachContactName.isDisplayed());
            }
        }
    }

}
