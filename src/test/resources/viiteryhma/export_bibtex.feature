Feature: As a user can export references as a bibtex formatted file

  Scenario: user can export a bibtex file
    Given export is selected
    When button is pressed
    Then user receives a bibtex file