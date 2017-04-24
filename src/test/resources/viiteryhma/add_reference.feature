Feature: As a user can add a reference with valid parameters

  Scenario: user can add an article
    Given article is selected
    When any strings for required fields are given 
    Then article is added

  Scenario: user can add a book with valid parameters
    Given book is selected
    When any strings for required fields are given 
    Then book is added

  Scenario: user can add an inproceedings with valid parameters
    Given inproceedings is selected
    When any strings for required fields are given 
    Then inproceedings is added

