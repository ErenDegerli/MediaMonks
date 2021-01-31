package com.mediamonks.pages.customer;

import com.mediamonks.core.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HotelDetailPage extends Base {

    @FindBy(css = "div.room-item-wrapper")
    private WebElement roomList;

    @FindBy(css = "label.custom-control-label.text-left.go-left")
    private WebElement classicRoomCheckBox;

    @FindBy(css = "button.book_button.btn.btn-success.btn-block.btn-lg.chk")
    private WebElement bookNowBtn;

    @FindBy(css = "button.btn.btn-success.btn-lg.btn-block.completebook")
    private WebElement confirmBookingBtn;

    @FindBy(id = "detail-content-sticky-nav-00")
    private WebElement hotelNameTitle;

    public HotelDetailPage(WebDriver driver) {
        super(driver);
    }

    public void bookARoom() {
        scrollToElement(roomList);
        waitUntilClickable(classicRoomCheckBox).click();
        bookNowBtn.click();
    }

    public void confirmBooking() {
        waitUntilClickable(scrollToElement(confirmBookingBtn)).click();
    }

    public String getHotelNameTitle() {
        return waitUntilVisible(hotelNameTitle).getText();
    }
}
