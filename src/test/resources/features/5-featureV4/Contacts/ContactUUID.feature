@contactUUID @API-V4 @contact
Feature: || contactUUID Endpoint ||API V4||
  
          1. API V4 ||  contactUUID || Call contactUUID webservice
          2. API V4 ||  contactUUID || Call contactUUID webservice with invalid Id

  @contactUUIDV4 @API-V4
  Scenario Outline: 1. API V4||  contactUUID || Call contactUUID webservice
    When Login in to API
    When List of contact exists with the UUID "<UUID>" in version "<Version>" and URL"<EndPointURL>"
    Then Verify the status code is 200
    And Verify the get response for contactUUID API "<UUID>"

    Examples: 
      | UUID                                          | Version |EndPointURL      |
      | 4941ab94-70a5-4070-b5ef-cecb6bef5acb          | v4      |/api/v4/contacts/|
      
      
  @contactUUIDInvalidV4 @API-V4
  Scenario Outline: 2. API V4||  contactUUID || Call contactUUID webservice with invalid Id
    When Login in to API
    When List of contact exists with the UUID "<UUID>" in version "<Version>" and URL"<EndPointURL>"
    Then Verify the status code for invalid data is 404

    Examples: 
      | UUID                 | Version |EndPointURL      |
      | 12345Qwerty          | v4      |/api/v4/contacts/|    