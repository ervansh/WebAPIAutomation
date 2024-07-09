@UpdateAccountGeographyConfiguratiomV4
Feature: ||Accounts|| Update Account Geography Configuration|| API v4
  1. Call Get MediaDB API account's geography configurations to Verify responce data and responce status

  @UpdateAccountGeographyConfiguratiomV4123
  Scenario Outline: Call Get MediaDB API account's geography configurations to Verify responce data and responce status
    Given Login in to API
    When Call the get account geography configuration api with client id
    When Update model json of update account geography configure API
    Then Verify the response status
    Then Verify the response messaage and get client ID

    Examples: 
      | Version |
      | v4      |
