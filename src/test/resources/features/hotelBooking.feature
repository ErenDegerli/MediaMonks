@search
Feature: Hotel Room Booking Case

  Background: Signing in for room booking
    Given User navigates to login page
    When User fills the login form with "user@phptravels.com" email and "demouser" password
    Then User see "Demo User" on the dashboard

  Scenario: User should be able to book a hotel room
    Given User navigates to HomePage
    When User makes a search for a reservation to "Messe Basel" from "10-02-2021" to "15-02-2021" for 3 adult and 1 children
    Then User see hotels are listed in "Messe-Basel"

    When User filters with only 4 star hotels
    Then User see "Swissotel Le Plaza Basel" hotel is listed

    Given User goes to hotel detail page
    When User selects a room
    And confirms the booking
    Then User see the "Booking Details"

    When User chooses to make purchase with pay on arrival option
    Then User see "Your booking status is Reserved" message
    And User can see the booking "Reserved" on their profile