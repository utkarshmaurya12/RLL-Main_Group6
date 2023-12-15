@contact
Feature: Contact Functionality

  Scenario: User submits the Contact Us Form Valid Data
    Given User navigates to the Contact Us page
    When User fills in the contact form
    And User submits the form
    Then User should see a confirmation message

  Scenario: User submits the Contact Us Form InValid Data
    Given User navigates to the Contact Us page
    When User fills in the contact form With Invalid Data
    And User submits the form Invalid Data
