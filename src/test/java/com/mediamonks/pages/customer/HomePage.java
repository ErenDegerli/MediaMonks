package com.mediamonks.pages.customer;

import com.mediamonks.core.Base;
import com.mediamonks.core.PropKey;
import com.mediamonks.core.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.io.IOException;

public class HomePage extends Base {

    @FindBy(css ="div[class='dropdown dropdown-login dropdown-tab']")
    private WebElement myAccountDropdown;

    @FindBy(css = "div[class='dropdown-menu dropdown-menu-right show']")
    private WebElement loginOption;

    @FindBy(css = "div.dropdown-menu.dropdown-menu-right.show > div > a:nth-child(2)")
    private WebElement signUpOption;

    @FindBy(id = "checkin")
    private WebElement checkInDatePicker;

    @FindBy(id = "checkout")
    private WebElement checkOutDatePicker;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToHomePage() throws IOException {
        driver.get(PropertyReader.getInstance().getProperty(PropKey.URL.getPropVal()));
    }

    public void navigateToRegisterPage() {
        waitUntilClickable(myAccountDropdown).click();
        waitUntilVisible(signUpOption).click();
    }

    public void navigateToLoginPage() {
        waitUntilClickable(myAccountDropdown).click();
        waitUntilVisible(loginOption).click();
    }
}