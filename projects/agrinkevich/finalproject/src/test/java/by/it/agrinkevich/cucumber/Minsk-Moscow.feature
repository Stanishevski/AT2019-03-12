Feature: Find aircraft ticket Minsk-Moscow
  @success
  Scenario: Check Ticket Count
    Given Home Page Airline Is Loaded From "https://www.expedia.com"
    When User Set Flight Mode
    And User Set One Way Ticket
    And Set Origin "Minsk"
    And Set Destination "Moscow"
    And Set Date Current Plus 30 Days
    And Click Search
    And User see List With Result
    Then Count If Result More 1