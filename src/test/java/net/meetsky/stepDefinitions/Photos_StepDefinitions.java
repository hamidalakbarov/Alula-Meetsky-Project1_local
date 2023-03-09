package net.meetsky.stepDefinitions;

import io.cucumber.java.en.*;
import net.meetsky.pages.LoginPage;
import net.meetsky.pages.PhotosPage;
import org.junit.Assert;

import java.util.List;

public class Photos_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    PhotosPage photosPage = new PhotosPage();

    @Given("users login to the app")
    public void users_login_to_the_app() {
        loginPage.login();
    }

    @Then("verify there are following sub-modules")
    public void verify_there_are_following_sub_modules(List<String> expectedSubModules) {
        Assert.assertTrue(photosPage.getSubModules().containsAll(expectedSubModules));
    }

}
