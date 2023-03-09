package net.meetsky.stepDefinitions;

import io.cucumber.java.en.*;
import net.meetsky.pages.FilesPage;
import org.junit.Assert;

public class DeleteFile_StepDefinitions {

    FilesPage filesPage = new FilesPage();

    @When("user choose the \"Delete file or folder“ option")
    public void user_choose_the_delete_file_or_folder_option() {
        filesPage.getFileText();
        filesPage.deleteOption.click();
    }
    @When("the user clicks the \"Deleted file or folder” sub-module on the left side")
    public void the_user_clicks_the_deleted_file_or_folder_sub_module_on_the_left_side() {
        filesPage.deletedFileSubModule.click();
    }
    @Then("Verify the deleted file is displayed on the Deleted Files page.")
    public void verify_the_deleted_file_is_displayed_on_the_deleted_files_page() {
        Assert.assertTrue(filesPage.deletedFileIsDisplayed());
    }


}
