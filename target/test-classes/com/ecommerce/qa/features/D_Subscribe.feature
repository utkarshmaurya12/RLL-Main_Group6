@subscribe
Feature: Subscribe to Email

  Scenario: User subscribe with valid email
    Given user is on landing page
    Given the user is on the subscription page
    When the user enters thier "email"
    And clicks on the subscribe button
    Then they should see a confirmation message

  Scenario: user subscribe with Invalid email
    Given user is on landing page
    Given the user is on the subscription page
    When the user enters their Invalid "email"
    And clicks on the subscribe button
    Then system shows fill the requirement
