package com.mediamonks.pages.admin;

import com.mediamonks.core.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CMSManagementPage extends Base {

    @FindBy(css = "#content > div.panel.panel-default > form > button")
    private WebElement addButton;

    @FindBy(css = "#content > div.panel.panel-default > div.panel-body > div > div > div.xcrud-ajax > div.xcrud-list-container > table > tbody > tr:nth-child(1) > td:nth-child(3)")
    private WebElement lastPageTitle;

    public CMSManagementPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToAddPage() {
        waitUntilClickable(addButton).click();
    }

    public String getLastCreatedPageTitle() {
        return waitUntilVisible(lastPageTitle).getText();
    }
}
