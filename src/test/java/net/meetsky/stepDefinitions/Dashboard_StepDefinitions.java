package net.meetsky.stepDefinitions;

import io.cucumber.java.en.*;
import net.meetsky.pages.DashboardPage;
import net.meetsky.pages.LoginPage;
import org.junit.Assert;

public class Dashboard_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Given("user on the home page")
    public void user_on_the_home_page() {
        loginPage.login();
    }

    @When("the user clicks the {string} module")
    public void the_user_clicks_the_module(String module) {
        dashboardPage.clickOnModule(module);
    }

    @Then("verify the contact names are in the list")
    public void verify_the_contact_names_are_in_the_list() {
        Assert.assertTrue(dashboardPage.verifyContactNames());
    }

}
