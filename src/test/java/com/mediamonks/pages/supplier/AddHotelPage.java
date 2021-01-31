package com.mediamonks.pages.supplier;

import com.mediamonks.core.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddHotelPage extends Base {

    @FindBy(css = "input.form-control")
    private WebElement hotelNameInputField;

    @FindBy(css = "iframe.cke_wysiwyg_frame.cke_reset")
    private WebElement descriptionInputField;

    @FindBy(css = "body.cke_editable.cke_editable_themed.cke_contents_ltr.cke_show_borders")
    private WebElement textInput;

    @FindBy(css = "select[name='hoteltype']")
    private WebElement hotelTypeDropdown;

    @FindBy(id = "s2id_searching")
    private WebElement locationDropDown;

    @FindBy(xpath = "//*[@id='select2-drop']/div/input")
    private WebElement locationInputField;

    @FindBy(className = "select2-result-label")
    private WebElement locationResult;

    @FindBy(css = "a[href='#FACILITIES']")
    private WebElement facilitiesSection;

    @FindBy(css = "a[href='#TRANSLATE']")
    private WebElement translateSection;

    @FindBy(className = "icheckbox_square-grey")
    private WebElement selectAllCheckBox;

    @FindBy(xpath = "/html/body/div[3]/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[8]/label")
    private WebElement laundryServiceCheckBox;

    @FindBy(css = "input[name='translated[tr][title]']")
    private WebElement turkishHotelNameInputField;

    @FindBy(css = "Rich Text Editor, translated[vi][desc]")
    private WebElement turkishDescriptionInputField;

    @FindBy(css = "iframe[title='Rich Text Editor, translated[tr][desc]'] > body.cke_editable.cke_editable_themed.cke_contents_ltr.cke_show_borders")
    private WebElement turkishDescriptionTextInput;

    @FindBy(id = "add")
    private WebElement addButton;

    public AddHotelPage(WebDriver driver) {
        super(driver);
    }

    public void setHotelDetails(String hotelName, String type, String description, String location) {
        setHotelName(hotelName);
        setHotelType(type);
        setLocation(location);
        setHotelDescription(description);
    }

    public void goToFacilitiesSection() {
        facilitiesSection.click();
    }

    public void setAllFacilitiesButLaundry() {
        goToFacilitiesSection();
        waitUntilClickable(selectAllCheckBox).click();
        mouseHoverAndClick(laundryServiceCheckBox);
    }

    public void addTurkishTranslation(String name) {
        goToTranslateSection();
        scrollToElement(waitUntilClickable(turkishHotelNameInputField)).sendKeys(name);
    }

    public void goToTranslateSection() {
        translateSection.click();
    }

    public void addHotel() {
        scrollToElement(addButton).click();
    }

    public void setHotelName(String hotelName) {
        waitUntilClickable(hotelNameInputField).sendKeys(hotelName);
    }

    public void setHotelDescription(String description) {
        driver.switchTo().frame(waitUntilVisible(descriptionInputField));
        waitUntilClickable(textInput).click();
        textInput.sendKeys(description);
        driver.switchTo().defaultContent();
    }

    public void setHotelType(String type) {
        Select hotelType = new Select(hotelTypeDropdown);
        hotelType.selectByVisibleText(type);
    }

    public void setLocation(String location) {
        waitUntilClickable(locationDropDown).click();
        waitUntilVisible(locationInputField).sendKeys(location);
        waitUntilVisible(locationResult).click();
    }
}
