package net.meetsky.stepDefinitions;

import io.cucumber.java.en.*;
import net.meetsky.pages.FilesPage;
import net.meetsky.utilities.BrowserUtils;
import net.meetsky.utilities.ConfigurationReader;
import org.junit.Assert;

public class Comments_StepDefinitions {

    FilesPage filesPage = new FilesPage();

    @When("user click action-icon from any file on the page")
    public void user_click_action_icon_from_any_file_on_the_page() {
        filesPage.firstActionIcon.click();
    }

    @When("user choose the {string} option")
    public void user_choose_the_option(String option) {
        filesPage.chooseOption(option);
    }

    @When("user write a comment inside the input box")
    public void user_write_a_comment_inside_the_input_box() {
        filesPage.commentsSection.click();
        filesPage.inputBox.sendKeys(ConfigurationReader.getProperty("comment"));
    }

    @When("user click the submit button to post it")
    public void user_click_the_submit_button_to_post_it() {
        filesPage.submitButton.click();
    }

    @Then("Verify the comment is displayed in the comment section.")
    public void verify_the_comment_is_displayed_in_the_comment_section() {
        Assert.assertTrue(filesPage.commentIsDisplayed());
    }


}
