Feature: Find aircraft ticket

  @success
  Scenario: Check Ticket Count
    Given Airline Home Page is Loaded
    When User Set Flight Mode
    And User Set One Way Ticket
    And User Set Flight From Minsk
    And User Set Flight To Moscow
    And User Set Date 20/06/2019
    And User Clicked Search
    And  User Sow Result List
    Then Result List Contains More Then 1
