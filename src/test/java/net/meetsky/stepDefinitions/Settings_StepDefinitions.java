package net.meetsky.stepDefinitions;

import io.cucumber.java.en.*;
import net.meetsky.pages.FilesPage;
import org.junit.Assert;

public class Settings_StepDefinitions {

    FilesPage filesPage = new FilesPage();
    @When("user clicks Settings on the left bottom corner")
    public void user_clicks_settings_on_the_left_bottom_corner() {
        filesPage.settings.click();
    }
    @Then("the user should be able to click any checkbox")
    public void the_user_should_be_able_to_click_any_checkbox() {
        Assert.assertTrue(filesPage.checkBoxIsSelected());
    }
}
