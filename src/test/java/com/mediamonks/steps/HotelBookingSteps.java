package com.mediamonks.steps;

import com.mediamonks.pages.customer.DashBoardPage;
import com.mediamonks.pages.customer.HomePage;
import com.mediamonks.pages.customer.LoginPage;
import com.mediamonks.pages.customer.SearchPage;
import io.cucumber.java.en.*;
import io.cucumber.java.eo.Se;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class HotelBookingSteps {

    private final LoginPage loginPage;
    private final DashBoardPage dashBoardPage;
    private final HomePage homePage;
    private final SearchPage searchPage;
    private final Logger logger;

    public HotelBookingSteps(){
        WebDriver driver = StepHooks.driver;
        loginPage = new LoginPage(driver);
        dashBoardPage = new DashBoardPage(driver);
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        logger = Logger.getLogger("HotelBookingTests");
    }

    @Given("User navigates to HomePage")
    public void user_navigates_to_homepage() throws IOException {
        homePage.navigateToHomePage();
    }

    @When("User makes a search for a reservation to {string} from {string} to {string} for {int} adult and {int} children")
    public void user_makes_a_search_for_a_reservation_to_from_to_for_adult_and_children(String location, String checkInDate, String checkOutDate, int adultNumber, int childrenNumber) throws IOException {
        homePage.makeASearch(location, checkInDate, checkOutDate, adultNumber, childrenNumber);
    }

    @Then("User see hotels are listed in {string}")
    public void user_see_hotels_are_listed_in(String location) {
        logger.info(searchPage.getNumberOfListedHotels());
        logger.info(searchPage.getTitle());

        assertAll(
                () -> assertTrue(searchPage.getTitle().contains(location)),
                () -> assertTrue(searchPage.getNumberOfListedHotels() > 0)
        );
    }

    @When("User filters with only {int} star hotels")
    public void user_filters_with_only_star_hotels(Integer stars) {
        searchPage.makeStarFilteredSearch(stars);
    }

    @Then("User see {string} hotel is listed")
    public void user_see_hotel_is_listed(String hotelName) {
        assertEquals(hotelName, searchPage.getHotelName());
    }

    @Given("User goes to hotel detail page")
    public void user_goes_to_hotel_detail_page() {
        searchPage.goToHotelDetail();
    }

    @When("User picks the best price")
    public void user_picks_the_best_price() {

    }

    @When("User selects a room")
    public void user_selects_a_room() {

    }

    @When("confirms the booking")
    public void confirms_the_booking() {

    }

    @Then("User see the booking details")
    public void user_see_the_booking_details() {

    }

    @When("User chooses to make purchase with pay on arrival option")
    public void user_chooses_to_make_purchase_with_pay_on_arrival_option() {

    }

    @Then("User see {string} message")
    public void user_see_message(String message) {

    }

    @Then("User can see the booking {string} on their profile")
    public void user_can_see_the_booking_on_their_profile(String reservationStatus) {

    }
}