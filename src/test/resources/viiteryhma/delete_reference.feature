Feature: As a user I can delete a reference

  Scenario: user can delete an article
    Given database is cleared
    And there is a reference of type "article" in the database
    When list references is selected
    And delete button for reference of type "article" is clicked
    Then references of type "article" are not listed

  Scenario: user can delete a book when there is an article in the database
    Given database is cleared
    And there is a reference of type "book" in the database
    And there is a reference of type "article" in the database
    When list references is selected
    And delete button for reference of type "book" is clicked
    Then references of type "book" are not listed
    And references of type "article" are listed

  Scenario: user can delete an inproceedings when there is a book and an article in the database
    Given database is cleared
    And there is a reference of type "inproceedings" in the database
    And there is a reference of type "article" in the database
    And there is a reference of type "book" in the database
    When list references is selected
    And delete button for reference of type "inproceedings" is clicked
    Then references of type "inproceedings" are not listed
    And references of type "article" are listed
    And references of type "book" are listed