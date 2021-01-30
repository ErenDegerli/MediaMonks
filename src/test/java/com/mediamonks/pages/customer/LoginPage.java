package com.mediamonks.pages.customer;

import com.mediamonks.core.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPage extends Base {

    @FindBy(css = "input[name='username']")
    private WebElement emailInputField;

    @FindBy(css = "input[name='password']")
    private WebElement passwordInputField;

    @FindBy(css = "button[type='submit']")
    private WebElement loginBtn;

    @FindBy(tagName = "h3")
    private WebElement pageTitle;

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void doLogin(String email, String password){
        waitUntilClickable(emailInputField).sendKeys(email);
        passwordInputField.sendKeys(password);
        loginBtn.click();
    }

    public void assertLoginPageTitle() {
        assertEquals("Login",pageTitle.getText());
    }
}