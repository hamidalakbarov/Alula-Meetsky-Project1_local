package net.meetsky.stepDefinitions;

import io.cucumber.java.en.*;
import net.meetsky.pages.DashboardPage;
import net.meetsky.pages.LoginPage;
import net.meetsky.utilities.ConfigurationReader;
import org.junit.Assert;

public class Search_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Given("user logged in to the app")
    public void user_logged_in_to_the_app() {
        loginPage.login();
    }

    @When("the user clicks the magnifier icon on the right top")
    public void the_user_clicks_the_magnifier_icon_on_the_right_top() {
        dashboardPage.searchMagnifier.click();
    }

    @When("users search any existing file or folder or user name")
    public void users_search_any_existing_file_or_folder_or_user_name() {
        dashboardPage.searchInput.sendKeys(ConfigurationReader.getProperty("searchKeyword"));
    }

    @Then("verify the app displays the expected result option")
    public void verify_the_app_displays_the_expected_result_option() {
        Assert.assertTrue(dashboardPage.searchContentIsDisplayed());
    }

}
