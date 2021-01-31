package com.mediamonks.utils;

import com.mediamonks.core.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AttributeHelper extends Base {

    @FindBy(css = "meta[name='keywords']")
    private WebElement metaKeywords;

    @FindBy(css = "meta[name='description']")
    private WebElement metaDescription;

    public AttributeHelper(WebDriver driver) {
        super(driver);
    }

    public String getMetaKeywordContentOfCurrentPage() {
        return metaKeywords.getAttribute("content");
    }

    public String getMetaDescriptionContentOfCurrentPage() {
        return metaDescription.getAttribute("content");
    }

    public String getPageTitleOfCurrentPage() {
        return driver.getTitle();
    }
}
