@OutletUUID @Outlets @API-V4
Feature: || OutletUUID Endpoint ||API V4||
  
          1. API V4 ||  OutletUUID || Call OutletUUID webservice
          2. API V4 ||  OutletUUID || Call OutletUUID webservice with invalid Id

  @OutletUUIDV4 @API-V4
  Scenario Outline: 1. API V4||  OutletUUID || Call OutletUUID webservice
    When Login in to API
    When List of outlets exists with the UUID "<UUID>" in version "<Version>" and URL"<EndPointURL>"
    Then Verify the status code is 200
    And Verify the get response "<UUID>"

    Examples: 
      | UUID                                          | Version |EndPointURL     |
      | 156ba7a8-c0bd-4fa5-b369-4265b8c2d9b1          | v4      |/api/v4/outlets/|
      
      
   @OutletUUIDInvalidV4 @API-V4
  Scenario Outline: 2. API V4||  OutletUUID || Call OutletUUID webservice with invalid Id
    When Login in to API
    When List of outlets exists with the UUID "<UUID>" in version "<Version>" and URL"<EndPointURL>"
    Then Verify the status code for invalid data is 404

    Examples: 
      | UUID                 | Version |EndPointURL     |
      | 12345Qwerty          | v4      |/api/v4/outlets/|     