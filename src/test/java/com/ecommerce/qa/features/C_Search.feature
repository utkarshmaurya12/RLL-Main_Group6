@search
Feature: Search,Filter & Add To Cart Functionality

  Scenario: E-shop search page Positive testcase
    #Given User open the chrome browser and open webpage
    And User enters product
    Then User click on search button
    # Filter
    #Then User Enters minimun price
    Then User Enters maximun price
    Then Choose the colour
    # Add to cart
    Then User added Product1 to cart
    And User click on continue shopping1
    Then User added Product2 to cart
    And User click on continue shopping2
    Then User added Product3 to cart
    And User click on continue shopping3

  Scenario: E-shop search page Negative testcase
    And User enters Wrong product
    Then User click on search button1
    Then User checks for Display message
