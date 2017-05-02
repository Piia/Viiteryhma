Feature: As a user can export references as a bibtex formatted file

  Scenario: user can export a bibtex file
    Given export is selected
    When write name of file "asdasd2"
    Then user receives a bibtex file "asdasd2"
