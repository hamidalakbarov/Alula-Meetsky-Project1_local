package net.meetsky.stepDefinitions;

import io.cucumber.java.en.*;
import net.meetsky.pages.DashboardPage;
import net.meetsky.pages.LoginPage;
import net.meetsky.utilities.BrowserUtils;

public class Contacts_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Given("user on the dashboard page")
    public void user_on_the_dashboard_page() {
        loginPage.login();
    }

    @When("the user clicks the {string} module")
    public void the_user_clicks_the_module(String module) {
       dashboardPage.clickOnTopLeftModules(module);
    }

    @Then("verify the page title is {string}")
    public void verify_the_page_title_is(String title) {
        BrowserUtils.verifyTitle(title);
    }

}
