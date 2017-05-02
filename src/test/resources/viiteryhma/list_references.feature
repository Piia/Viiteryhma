Feature: As a user can list references

#needs to be able to empty database first, menee läpi but relies on other tests' input
  Scenario: user can list all references
    Given there is a reference of type "article" in the database
    And there is a reference of type "book" in the database
    And there is a reference of type "inproceedings" in the database
    When list references is selected
    Then references of type "article" are listed
    And references of type "book" are listed
    And references of type "inproceedings" are listed

#needs to be able to empty database first, menee läpi but relies on other tests' input
  Scenario: user can filter listed references
    Given there is a reference of type "article" containing the text "search for this" in the database
    And there is a reference of type "book" not containing the text "search for this" in the database
    When list references is selected
    And references are filtered using "search for this"
    Then references of type "article" are listed
    And references of type "book" are not listed

