package net.meetsky.pages;

import static net.meetsky.utilities.ConfigurationReader.*;

import static net.meetsky.utilities.Driver.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(id = "user")
    public WebElement usernameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(id = "submit-form")
    public WebElement logInButton;

    @FindBy(xpath = "//p[contains(@class,'warning')]")
    public WebElement warningMessage;

    public void login() {
        getDriver().get(getProperty("env"));
        usernameInput.sendKeys(getProperty("login"));
        passwordInput.sendKeys(getProperty("password"));
        logInButton.click();
    }

    public void login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
    }
}
