@contactUUIDOutlets @API-V4 @contact
Feature: || contactUUIDOutlets Endpoint ||API V4||
  
          1. API V4 ||  contactUUIDOutlets || Call contactUUIDOutlets webservice
          2. API V4 ||  contactUUIDOutlets || Call contactUUIDOutlets webservice with invalid Id

  @contactUUIDOutletsV4 @API-V4
  Scenario Outline: 1. API V4||  contactUUIDOutlets || Call contactUUIDOutlets webservice
    When Login in to API
    When List of outlet exists with the contactUUID "<UUID>" in version "<Version>" and URL"<EndPointURL>"
    Then Verify the status code is 200
    And Verify the outlet assosiated with contactUUID API "<UUID>"

    Examples: 
      | UUID                                          | Version |EndPointURL      |
      | 4941ab94-70a5-4070-b5ef-cecb6bef5acb          | v4      |/api/v4/contacts/|
      
      
 @contactUUIDOutletsInvalidV4 @API-V4
  Scenario Outline: 2. API V4||  contactUUIDOutlets || Call contactUUIDOutlets webservice with invalid Id
    When Login in to API
    When List of outlet exists with the contactUUID "<UUID>" in version "<Version>" and URL"<EndPointURL>"
    Then Verify the status code for invalid data is 404

    Examples: 
      | UUID                        | Version |EndPointURL      |
      | c2939b52-4cb7-4cec          | v4      |/api/v4/contacts/|     