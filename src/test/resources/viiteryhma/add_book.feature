Feature: As a user can add a book with valid parameters

  Scenario: user can add a book with valid parameters using author
    Given add reference of type "book" is selected
    When valid value "V78" of type "key" for reference-type "book" is given
    And valid value "L. S. Vygotsky" of type "author" for reference-type "book" is given
    And valid value "Mind in Society: The Development of Higher Psychological Processes" of type "title" for reference-type "book" is given
    And valid value "Harvard University Press" of type "publisher" for reference-type "book" is given
    And valid value "1978" of type "year" for reference-type "book" is given
    And reference form for "book" is submitted
    Then reference is added

#  Scenario: user can add a book with valid parameters using editor
#    Given add reference of type "book" is selected
#    When valid value "V78" of type "key" for reference-type "book" is given
#    And valid value "L. S. Vygotsky" of type "editor" for reference-type "book" is given
#    And valid value "Mind in Society: The Development of Higher Psychological Processes" of type "title" for reference-type "book" is given
#    And valid value "Harvard University Press" of type "publisher" for reference-type "book" is given
#    And valid value "1978" of type "year" for reference-type "book" is given
#    And book form is submitted
#    Then reference is added

  Scenario: user can not add a book without key
    Given add reference of type "book" is selected
    When valid value "L. S. Vygotsky" of type "author" for reference-type "book" is given
    And valid value "Mind in Society: The Development of Higher Psychological Processes" of type "title" for reference-type "book" is given
    And valid value "Harvard University Press" of type "publisher" for reference-type "book" is given
    And valid value "1978" of type "year" for reference-type "book" is given
    And reference form for "book" is submitted
    Then reference is not added

  Scenario: user can not add a book without author and editor
    Given add reference of type "book" is selected
    When valid value "V78" of type "key" for reference-type "book" is given
    And valid value "Mind in Society: The Development of Higher Psychological Processes" of type "title" for reference-type "book" is given
    And valid value "Harvard University Press" of type "publisher" for reference-type "book" is given
    And valid value "1978" of type "year" for reference-type "book" is given
    And reference form for "book" is submitted
    Then reference is not added

  Scenario: user can not add a book without title
    Given add reference of type "book" is selected
    When valid value "V78" of type "key" for reference-type "book" is given
    And valid value "L. S. Vygotsky" of type "author" for reference-type "book" is given
    And valid value "Harvard University Press" of type "publisher" for reference-type "book" is given
    And valid value "1978" of type "year" for reference-type "book" is given
    And reference form for "book" is submitted
    Then reference is not added

  Scenario: user can not add a book without publisher
    Given add reference of type "book" is selected
    When valid value "V78" of type "key" for reference-type "book" is given
    And valid value "L. S. Vygotsky" of type "author" for reference-type "book" is given
    And valid value "Mind in Society: The Development of Higher Psychological Processes" of type "title" for reference-type "book" is given
    And valid value "1978" of type "year" for reference-type "book" is given
    And reference form for "book" is submitted
    Then reference is not added

  Scenario: user can not add a book without year
    Given add reference of type "book" is selected
    When valid value "V78" of type "key" for reference-type "book" is given
    And valid value "L. S. Vygotsky" of type "author" for reference-type "book" is given
    And valid value "Mind in Society: The Development of Higher Psychological Processes" of type "title" for reference-type "book" is given
    And valid value "Harvard University Press" of type "publisher" for reference-type "book" is given
    And reference form for "book" is submitted
    Then reference is not added

Scenario: user can add a book with values in all available fields
    Given add reference of type "book" is selected
    When valid parameters for (key "V78", author "L. S. Vygotsky", title "Mind in Society: The Development of Higher Psychological Processes", publisher "Harvard University Press", year "1978") for all required book-fields are given
    And valid value "1234" of type "number" for reference-type "book" is given
    And valid value "45" of type "series" for reference-type "book" is given
    And valid value "Cambridge, MA" of type "address" for reference-type "book" is given
    And valid value "34" of type "edition" for reference-type "book" is given
    And valid value "5" of type "month" for reference-type "book" is given
    And valid value "testtext" of type "note" for reference-type "book" is given
    And valid value "tags1,tags2,tags 3" of type "tags" for reference-type "book" is given
    And reference form for "book" is submitted
    Then reference is added

#Required fields: author/editor, title, publisher, year
#Optional fields: volume/number, series, address, edition, month, note, key

#@BOOK (V78,
#AUTHOR = "L. S. Vygotsky",
#TITLE= "Mind in Society: The Development of Higher Psychological Processes",
#PUBLISHER = "Harvard University Press",
#YEAR = 1978,
#ADDRESS = "Cambridge, MA",
#)