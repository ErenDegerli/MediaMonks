@hotel

Feature: Adding Hotel Case

  Scenario: Adding Monks Palace
    Given User navigates to the supplier page
    When User fill the supplier login form with "supplier@phptravels.com" email and "demosupplier" password

    Given Supplier is on the "MANAGE HOTELS" section
    When Supplier adds a hotel with "Monks Palace" name, "Hotel" type, "The best hotel" description, "Hilversum" location and without Laundry Service option
    And Supplier adds Turkish translation "Saray Monks" as name
    Then Supplier see "Monks Palace" is listed

    Given Supplier is on the "ADD ROOM" section
    When Supplier adds a "Triple Rooms" for "Monks Palace" hotel with price "80"
    Then Supplier see "Triple Rooms" is added for "Monks Palace"

  Scenario: Visit Monks Palace Turkish Page
    Given User navigates to HomePage
    When User changes the language to "Turkish"
    And User makes a search for a reservation to "Saray Monks" from "11-02-2021" to "12-02-2021" for 2 adult and 1 children
    Then User see "Saray Monks" as name