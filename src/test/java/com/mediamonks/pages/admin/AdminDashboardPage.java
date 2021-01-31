package com.mediamonks.pages.admin;

import com.mediamonks.core.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminDashboardPage extends Base {

    @FindBy(css = "a[href='#CMS']")
    private WebElement CMSSection;

    public AdminDashboardPage(WebDriver driver) {
        super(driver);
    }

    public void goToSubsection(String subsection) {
        waitUntilClickable(CMSSection).click();
        waitUntilVisible(driver.findElement(By.linkText(subsection))).click();
    }
}
