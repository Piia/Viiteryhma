Feature: As a user can add an inproceedings with valid parameters

  Scenario: user can add an inproceedings with valid parameters
    Given add reference of type "inproceedings" is selected
    When valid value "KB04" of type "key" for reference-type "inproceedings" is given
    And valid value "Kölling, Michael and Barnes, David J." of type "author" for reference-type "inproceedings" is given
    And valid value "Enhancing apprentice-based learning of Java" of type "title" for reference-type "inproceedings" is given
    And valid value "SIGCSE '04: Proceedings of the 35th SIGCSE technical symposium on Computer science education" of type "booktitle" for reference-type "inproceedings" is given
    And valid value "2004" of type "year" for reference-type "inproceedings" is given
    And inproceedings form is submitted
    Then reference is added

#  Scenario: user can not add an inproceedings without key
#    Given add reference of type "inproceedings" is selected
#    When valid value "Kölling, Michael and Barnes, David J." of type "author" for reference-type "inproceedings" is given
#    And valid value "Enhancing apprentice-based learning of Java" of type "title" for reference-type "inproceedings" is given
#    And valid value "SIGCSE '04: Proceedings of the 35th SIGCSE technical symposium on Computer science education" of type "booktitle" for reference-type "inproceedings" is given
#    And valid value "2004" of type "year" for reference-type "inproceedings" is given
#    And inproceedings form is submitted
#    Then reference is not added

  Scenario: user can not add an inproceedings without author
    Given add reference of type "inproceedings" is selected
    When valid value "KB04" of type "key" for reference-type "inproceedings" is given
    And valid value "Enhancing apprentice-based learning of Java" of type "title" for reference-type "inproceedings" is given
    And valid value "SIGCSE '04: Proceedings of the 35th SIGCSE technical symposium on Computer science education" of type "booktitle" for reference-type "inproceedings" is given
    And valid value "2004" of type "year" for reference-type "inproceedings" is given
    And inproceedings form is submitted
    Then reference is not added

  Scenario: user can not add an inproceedings without title
    Given add reference of type "inproceedings" is selected
    When valid value "KB04" of type "key" for reference-type "inproceedings" is given
    And valid value "Kölling, Michael and Barnes, David J." of type "author" for reference-type "inproceedings" is given
    And valid value "SIGCSE '04: Proceedings of the 35th SIGCSE technical symposium on Computer science education" of type "booktitle" for reference-type "inproceedings" is given
    And valid value "2004" of type "year" for reference-type "inproceedings" is given
    And inproceedings form is submitted
    Then reference is not added

  Scenario: user can not add an inproceedings without booktitle
    Given add reference of type "inproceedings" is selected
    When valid value "KB04" of type "key" for reference-type "inproceedings" is given
    And valid value "Kölling, Michael and Barnes, David J." of type "author" for reference-type "inproceedings" is given
    And valid value "Enhancing apprentice-based learning of Java" of type "title" for reference-type "inproceedings" is given
    And valid value "2004" of type "year" for reference-type "inproceedings" is given
    And inproceedings form is submitted
    Then reference is not added

  Scenario: user can not add an inproceedings without year
    Given add reference of type "inproceedings" is selected
    When valid value "KB04" of type "key" for reference-type "inproceedings" is given
    And valid value "Kölling, Michael and Barnes, David J." of type "author" for reference-type "inproceedings" is given
    And valid value "Enhancing apprentice-based learning of Java" of type "title" for reference-type "inproceedings" is given
    And valid value "SIGCSE '04: Proceedings of the 35th SIGCSE technical symposium on Computer science education" of type "booktitle" for reference-type "inproceedings" is given
    And inproceedings form is submitted
    Then reference is not added

Scenario: user can add an inproceedings with values in all available fields
    Given add reference of type "inproceedings" is selected
    When valid parameters for (key "KB04", author "Kölling, Michael and Barnes, David J.", title "Enhancing apprentice-based learning of Java", booktitle "SIGCSE '04: Proceedings of the 35th SIGCSE technical symposium on Computer science education", year "2004") for all required inproceedings-fields are given
    And valid value "test editor" of type "editor" for reference-type "inproceedings" is given
    And valid value "test volume" of type "volume" for reference-type "inproceedings" is given
#    And valid value "test number" of type "number" for reference-type "inproceedings" is given
    And valid value "test series" of type "series" for reference-type "inproceedings" is given
    And valid value "134-145" of type "pages" for reference-type "inproceedings" is given
    And valid value "Cambridge, MA" of type "address" for reference-type "inproceedings" is given
    And valid value "test month" of type "month" for reference-type "inproceedings" is given
    And valid value "test organization" of type "organization" for reference-type "inproceedings" is given
    And valid value "ACM" of type "publisher" for reference-type "inproceedings" is given
    And valid value "testtext" of type "note" for reference-type "inproceedings" is given
    And inproceedings form is submitted
    Then reference is added

#Required fields: author, title, booktitle, year
#Optional fields: editor, volume/number, series, pages, address, month, organization, publisher, note, key

#@inproceedings{KB04,
#author = {K\"{o}lling, Michael and Barnes, David J.},
#title = {Enhancing apprentice-based learning of Java},
#booktitle = {SIGCSE '04: Proceedings of the 35th SIGCSE technical symposium on Computer science education},
#year = {2004},
#pages = {286--290},
#publisher = {ACM},
#}
