Feature: As a user can list references

#needs to be able to empty database first, menee läpi but not for the right reasons
  Scenario: user can list all references
    Given there is an article in the database
    And there is a book in the database
    And there is an inproceedings in the database
    When list references is selected
    Then articles are listed
    And books are listed
    And inproceedings are listed

#needs to be able to empty database first, menee läpi but not for the right reasons
  Scenario: user can filter listed references
    Given there is a book containing the text "q" in the database
    And there is an article not containing the text "q" in the database
    And there is an inproceedings not containing the text "q" in the database
    When list references is selected
    And references are filtered using "q"
    Then articles are not listed
    And books are listed
    And inproceedings are not listed

#needs to be able to empty database first, menee läpi but not for the right reasons
  Scenario: user can filter listed references
    Given there is an article containing the text "search for this" in the database
    And there is a book not containing the text "search for this" in the database
    When list references is selected
    And references are filtered using "search for this"
    Then articles are listed
    And books are not listed

