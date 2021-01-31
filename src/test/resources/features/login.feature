@Login

Feature: MediaMonks Login Test

  Scenario: Sign In And Update Profile
    Given User navigates to login page
    When User fills the login form with "user@phptravels.com" email and "demouser" password
    Then User see "Demo User" on the dashboard
    Given User goes to their profile page
    When User changes password with "12345678" and logout
    Then User fills the login form with "user@phptravels.com" email and "12345678" password
    And User see "Demo User" on the dashboard

  Scenario: Customer should not be able to login Admin Section
    When User is registered with "erendegerli@hotmail.com" email, "123456" password, "123" phone, "Eren Degerli" full name
    Then User see "Eren Degerli" on the dashboard
    Given User navigates to the admin page
    When User fill the admin login form with "erendegerli@hotmail.com" email and "123456" password
    Then User see "Invalid Login Credentials" message on the admin page

  Scenario: Customer should not be able to login Supplier Section
    When User is registered with "erendegerli@gmail.com" email, "1234567" password, "98765" phone, "Can Degerli" full name
    Then User see "Can Degerli" on the dashboard
    Given User navigates to the supplier page
    When User fill the supplier login form with "erendegerli@gmail.com" email and "1234567" password
    Then User see "Invalid Login Credentials" message on the supplier page