Feature: As a user can list references

  Scenario: user can list all references
    Given references is selected
    When user is
    Then user sees a list of all references

  Scenario: user can filter listed references
    Given references is selected
    When user uses filter "book"
    Then user sees a list of all book references

