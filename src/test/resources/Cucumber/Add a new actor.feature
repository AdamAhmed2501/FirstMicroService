Feature: Adding a new actor to the database
  As a user I would like to add a new actor into my database

  Scenario: I have enough information
    Given I have the actors first name and I have the actors last name
    When I input the data into the database
    Then Actor added to the database

    Scenario: I don't have enough information
      Given I have the actors first name but I don't have the actors last name
      When I input the data into the database
      Then Actor not added to the database

    Scenario: I don't have enough information
      Given I don't have the actors first name but I have the actors last name
      When I input the data into the database
      Then Actor not added to the database