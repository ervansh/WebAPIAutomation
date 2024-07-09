@GetAccountGeographyConfiguratiomV4 
Feature: ||AccountManagement|| Get Account Geograpgy Configuration||API V4||
  1. Call Get MediaDB API account's geography configurations to Verify responce data and responce status

  @GetAccountGeographyConfiguratiomV4 @Sanity
  Scenario Outline: Call Get MediaDB API account's geography configurations to Verify responce data and responce status
    Given Login in to API
    When Update model json of update account geography configure API
    When Call the get account geography configuration api with client id
    Then Verify the response status
    Examples:
      | Version |
      | v4      |
