package net.meetsky.pages;

import net.meetsky.utilities.BrowserUtils;
import net.meetsky.utilities.ConfigurationReader;
import net.meetsky.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilesPage extends BasePage {

    @FindBy(css = "button.settings-button")
    public WebElement settings;

    /*@FindBy(xpath = "//label[@for='recommendationsEnabledToggle']")
    public WebElement secondCHeckBox;*/

    @FindBy(css = "div#rich-workspace")
    public WebElement workSpace;

    @FindBy(xpath = "//label[@for='showRichWorkspacesToggle']")
    public WebElement firstCheckbox;

    public boolean checkBoxIsSelected() {
        // System.out.println(secondCHeckBox.isEnabled()); //TODO: remove this code after discussion
        BrowserUtils.sleep(2);
        try {
            if (workSpace.isDisplayed()) {
                firstCheckbox.click();
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        firstCheckbox.click();
        return workSpace.isDisplayed();
    }

    @FindBy(xpath = "(//a[@data-action='menu'])[1]")
    public WebElement firstActionIcon;

    @FindBy(xpath = "(//span[@class='nametext'])[1]")
    public WebElement firstFIleOrFolder;

    public void chooseOption(String option) {
        Driver.getDriver().findElement(By.xpath(" //span[.='" + option + "']")).click();
    }

    @FindBy(css = "a#comments")
    public WebElement commentsSection;

    @FindBy(css = "a#comments")
    public WebElement commentsInput;

    @FindBy(xpath = "//div[@role='textbox']")
    public WebElement inputBox;

    @FindBy(xpath = "//input[contains(@class,'comment__submit')]")
    public WebElement submitButton;

    public boolean commentIsDisplayed() {
        String comment = ConfigurationReader.getProperty("comment");
        return Driver.getDriver().findElement(By.xpath("//div[.='" + comment + "']")).isDisplayed();
    }

    @FindBy(xpath = "//a[@data-action='Delete']")
    public WebElement deleteOption;

    @FindBy(linkText = "Deleted files")
    public WebElement deletedFileSubModule;

    String deletedFileText;

    public void getFileText() {
        deletedFileText = firstFIleOrFolder.getText();
    }

    public boolean deletedFileIsDisplayed() {
        return Driver.getDriver().findElement(By.xpath("//span[@title='" + deletedFileText + "']")).isDisplayed();
    }


}
