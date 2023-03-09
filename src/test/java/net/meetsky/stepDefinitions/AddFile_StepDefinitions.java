package net.meetsky.stepDefinitions;

import io.cucumber.java.en.*;
import net.meetsky.pages.FilesPage;
import org.junit.Assert;

public class AddFile_StepDefinitions {

    FilesPage filesPage = new FilesPage();

    @When("user clicks the add icon on the top")
    public void user_clicks_the_add_icon_on_the_top() {
        filesPage.addIcon.click();
    }

    @When("user click {string}")
    public void user_click(String menuItem) {
        filesPage.clickNewFileMenuItem(menuItem);
    }

    @When("user write a folder {string}")
    public void user_write_a_folder(String name) {
        filesPage.writeFolderName(name);
    }

    @When("the user click submit icon")
    public void the_user_click_submit_icon() {
        filesPage.submitIcon.click();
    }

    @Then("Verify the folder is displayed on the page")
    public void verify_the_folder_is_displayed_on_the_page() {
        Assert.assertTrue(filesPage.folderIsDisplayed());
    }

}
