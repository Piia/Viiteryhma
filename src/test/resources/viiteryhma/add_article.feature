Feature: As a user can add an article with valid parameters

  Scenario: user can add an article with valid parameters for the required fields
    Given add reference of type "article" is selected
    When valid value "SS86" of type "key" for reference-type "article" is given
    And valid value "Spohrer, James C. and Soloway, Elliot" of type "author" for reference-type "article" is given
    And valid value "Novice mistakes: are the folk wisdoms correct?" of type "title" for reference-type "article" is given
    And valid value "Commun. ACM" of type "journal" for reference-type "article" is given
    And valid value "29" of type "volume" for reference-type "article" is given
    And valid value "1986" of type "year" for reference-type "article" is given
    And reference form for "article" is submitted
    Then reference is added

  Scenario: user can not add an article without key
    Given add reference of type "article" is selected
    When valid value "Spohrer, James C. and Soloway, Elliot" of type "author" for reference-type "article" is given
    And valid value "Novice mistakes: are the folk wisdoms correct?" of type "title" for reference-type "article" is given
    And valid value "Commun. ACM" of type "journal" for reference-type "article" is given
    And valid value "29" of type "volume" for reference-type "article" is given
    And valid value "1986" of type "year" for reference-type "article" is given
    And reference form for "article" is submitted
    Then reference is not added

  Scenario: user can not add an article without author
    Given add reference of type "article" is selected
    When valid value "SS86" of type "key" for reference-type "article" is given
    And valid value "Novice mistakes: are the folk wisdoms correct?" of type "title" for reference-type "article" is given
    And valid value "Commun. ACM" of type "journal" for reference-type "article" is given
    And valid value "29" of type "volume" for reference-type "article" is given
    And valid value "1986" of type "year" for reference-type "article" is given
    And  reference form for "article" is submitted
    Then reference is not added

  Scenario: user can not add an article without title
    Given add reference of type "article" is selected
    When valid value "SS86" of type "key" for reference-type "article" is given
    And valid value "Spohrer, James C. and Soloway, Elliot" of type "author" for reference-type "article" is given
    And valid value "Commun. ACM" of type "journal" for reference-type "article" is given
    And valid value "29" of type "volume" for reference-type "article" is given
    And valid value "1986" of type "year" for reference-type "article" is given
    And reference form for "article" is submitted
    Then reference is not added

  Scenario: user can not add an article without journal
    Given add reference of type "article" is selected
    When valid value "SS86" of type "key" for reference-type "article" is given
    And valid value "Spohrer, James C. and Soloway, Elliot" of type "author" for reference-type "article" is given
    And valid value "Novice mistakes: are the folk wisdoms correct?" of type "title" for reference-type "article" is given
    And valid value "29" of type "volume" for reference-type "article" is given
    And valid value "1986" of type "year" for reference-type "article" is given
    And reference form for "article" is submitted
    Then reference is not added

  Scenario: user can not add an article without volume
    Given add reference of type "article" is selected
    When valid value "SS86" of type "key" for reference-type "article" is given
    And valid value "Spohrer, James C. and Soloway, Elliot" of type "author" for reference-type "article" is given
    And valid value "Novice mistakes: are the folk wisdoms correct?" of type "title" for reference-type "article" is given
    And valid value "Commun. ACM" of type "journal" for reference-type "article" is given
    And valid value "1986" of type "year" for reference-type "article" is given
    And reference form for "article" is submitted
    Then reference is not added

  Scenario: user can not add an article without year
    Given add reference of type "article" is selected
    When valid value "SS86" of type "key" for reference-type "article" is given
    And valid value "Spohrer, James C. and Soloway, Elliot" of type "author" for reference-type "article" is given
    And valid value "Novice mistakes: are the folk wisdoms correct?" of type "title" for reference-type "article" is given
    And valid value "Commun. ACM" of type "journal" for reference-type "article" is given
    And valid value "29" of type "volume" for reference-type "article" is given
    And reference form for "article" is submitted
    Then reference is not added

Scenario: user can add an article with values in all available fields
    Given add reference of type "article" is selected
    When valid parameters for (key "SS86", author "Spohrer, James C. and Soloway, Elliot", title "Novice mistakes: are the folk wisdoms correct?", journal "Commun. ACM", volume "29", year "1986") for all required article-fields are given
    And valid value "7" of type "number" for reference-type "article" is given
    And valid value "624-632" of type "pages" for reference-type "article" is given
    And valid value "test month" of type "month" for reference-type "article" is given
    And valid value "test note" of type "note" for reference-type "article" is given
    And valid value "tags1,tags2,tags 3" of type "tags" for reference-type "article" is given
    And reference form for "article" is submitted
    Then reference is added


#@article{SS86,
#author = {Spohrer, James C. and Soloway, Elliot},
#title = {Novice mistakes: are the folk wisdoms correct?},
#journal = {Commun. ACM},
#volume = {29},
#number = {7},
#year = {1986},
#pages = {624--632},
#publisher = {ACM},
#}