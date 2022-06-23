Feature: Adding a new actor to the database
  As a user I would like to add a new actor into my database

  Scenario: I have enough information
    Given I have the actors first name
    And I have the actors last name
    When I input the data into the database
    Then I get a message stating that the actor has been added to the database successfully.

    Scenario: I don't have enough information
      Given I have the actors first name
      And I don't have the actors last name
      When I input the data into the database
      Then I get an error message stating that the actor has not been added to the database.

    Scenario: I don't have enough information
      Given I don't have the actors first name
      And I have the actors last name
      When I input the data into the database
      Then I get an error message stating that the actor has not been added to the database.