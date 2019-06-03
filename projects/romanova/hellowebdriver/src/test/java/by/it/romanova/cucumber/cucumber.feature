Feature: Find airplane ticket
@success
    Scenario: Check Tickets Count
    Given Home Page Is Loaded
    When User clicks Flight Search
    And User Types Departure "Minsk, Belarus (MSQ-All Airports)" Airport
    And User Type Destination "Moscow, Russia (MOW-All Airports)" Airport
    And Select Departing Date
    And Select Returning "30" Date
    And SubmitForm
    Then More Than One result is Given
