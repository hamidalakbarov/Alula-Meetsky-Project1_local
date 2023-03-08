package net.meetsky.stepDefinitions;

import io.cucumber.java.en.*;
import net.meetsky.pages.DashboardPage;
import net.meetsky.pages.LoginPage;

public class ContactList_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Given("user on the home page")
    public void user_on_the_home_page() {
        loginPage.login();
    }

    @When("the user clicks the contacts module")
    public void the_user_clicks_the_contacts_module() {
       dashboardPage.contactsMenu.click();
    }

    @Then("verify the contact names are in the list")
    public void verify_the_contact_names_are_in_the_list() {
        dashboardPage.verifyContactNames();
    }

}
