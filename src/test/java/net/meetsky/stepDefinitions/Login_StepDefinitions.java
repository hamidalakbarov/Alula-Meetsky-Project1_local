package net.meetsky.stepDefinitions;

import io.cucumber.java.en.*;
import net.meetsky.pages.LoginPage;
import net.meetsky.utilities.BrowserUtils;
import org.junit.Assert;

import static net.meetsky.utilities.ConfigurationReader.*;

import static net.meetsky.utilities.Driver.*;

public class Login_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    @Given("user on the login page")
    public void user_on_the_login_page() {
        getDriver().get(getProperty("env"));
    }

    @When("user use username {string} and passcode {string}")
    public void user_use_username_and_passcode(String username, String password) {
       loginPage.login(username,password);
    }

    @When("user click the login button")
    public void user_click_the_login_button() {
        loginPage.logInButton.click();
    }
    @Then("verify the user should be at the {string} page")
    public void verify_the_user_should_be_at_the_page(String text) {
        BrowserUtils.verifyUrlContains(text);
    }

    @When("user enter invalid {string} and {string}")
    public void user_enter_invalid_and(String username, String password) {
        loginPage.login(username,password);
    }
    @Then("verify {string} message should be displayed")
    public void verify_message_should_be_displayed(String message) {
        Assert.assertEquals(message,loginPage.warningMessage.getText());
    }


}
