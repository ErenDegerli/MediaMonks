package com.mediamonks.pages.admin;

import com.mediamonks.core.Base;
import com.mediamonks.core.PropKey;
import com.mediamonks.core.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.io.IOException;

public class AdminHomePage extends Base {

    @FindBy(css = "input[name='email']")
    private WebElement emailInputField;

    @FindBy(css = "input[name='password']")
    private WebElement passwordInputField;

    @FindBy(css = "button[type='submit']")
    private WebElement loginBtn;

    @FindBy(css = "div.alert.alert-danger.loading.wow.fadeIn.animated.animated")
    private WebElement validationMessage;

    public AdminHomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToAdminPage() throws IOException {
        driver.get(PropertyReader.getInstance().getProperty(PropKey.ADMIN_URL.getPropVal()));
    }

    public void doLogin(String email, String password) {
        waitUntilClickable(emailInputField).sendKeys(email);
        passwordInputField.sendKeys(password);
        loginBtn.click();
    }

    public String getValidationMessage() {
        return waitUntilVisible(validationMessage).getText();
    }
}