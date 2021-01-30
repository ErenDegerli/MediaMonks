Feature: Hotel Room Booking Case

  Background: User is on the HomePage

  Scenario: User should be able to book a hotel room
    When User makes a search for a reservation to "Messe-Basel" from "10 February 2021" to "15 February 2021" for 2 adult and 1 children
    Then User see hotels are listed in Messe-Basel

    When User picks the best price
    And selects a room
    And confirms the booking
    Then User see the booking details

    When User chooses to make purchase with pay on arrival option
    Then User see "Your booking status is Reserved" message
    And User can see the booking "Reserved" on their profile