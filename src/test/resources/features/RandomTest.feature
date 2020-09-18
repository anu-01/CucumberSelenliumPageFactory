#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@PartsUnlimited
Feature: Parts Unlimited
  I want to login to the portal and search for products and place an order

  @loginpage
  Scenario: Verify user is able to login
    Given user is on home page
    When I click on login link
    And I enter username "anusha@gmail.com"
    And I enter password "P@ssword1234"
    And I click on login button
    Then I verify the login is successful
    
    @homepage @bvt @e2e
  Scenario: Verify user is able to search for a product
    Given user is on home page
    And I login using email "anusha@gmail.com" and password "P@ssword1234"
    When user search for "oil"
    And chose to buy the first item
    And continues to checkout
    And enter personal details on checkout page
    And submits the order
    Then verify the order is placed
    
