package net.meetsky.stepDefinitions;

import io.cucumber.java.en.*;
import net.meetsky.pages.FilesPage;
import net.meetsky.utilities.BrowserUtils;
import org.junit.Assert;

public class Files_StepDefinitions {

    FilesPage filesPage = new FilesPage();

    @When("user click the top-left checkbox of the table")
    public void user_click_the_top_left_checkbox_of_the_table() {
        filesPage.allFilesCheckbox.click();
    }

    @Then("verify all the files are selected")
    public void verify_all_the_files_are_selected() {
        Assert.assertTrue(filesPage.allFilesSelected());
    }


}
