package net.meetsky.pages;

import net.meetsky.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PhotosPage extends BasePage {

    @FindBy(xpath = "//span[@class='app-navigation-entry__title']")
    public List<WebElement> subModules;

    public List<String> getSubModules() {
        return subModules.stream().map(f -> f.getText()).collect(Collectors.toList());
    }
}
