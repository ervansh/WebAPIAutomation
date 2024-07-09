@outletUUID-Contacts @API-V4 @Outlet @API-V4
Feature: || outletUUID-Contacts Endpoint ||API V4||
  
          1. API V4 ||  outletUUID-Contacts || Call outletUUID-Contacts webservice
          2. API V4 ||  outletUUID-Contacts || Call outletUUID-Contacts webservice with invalid Id

  @outletUUID-ContactsV4 @API-V4
  Scenario Outline: 1. API V4||  outletUUID-Contacts || Call outletUUID-Contacts webservice
    When Login in to API
    When List of contact exists with the outletUUID "<UUID>" in version "<Version>" and URL"<EndPointURL>"
    Then Verify the status code is 200
    And Verify the contact assosiated with outletUUID API "<UUID>"

    Examples: 
      | UUID                                          | Version |EndPointURL      |
      | 156ba7a8-c0bd-4fa5-b369-4265b8c2d9b1          | v4      |/api/v4/outlets/ |
      
      
 @contactUUIDOutletsInvalidV4 @API-V4
  Scenario Outline: 2. API V4||  outletUUID-Contacts || Call outletUUID-Contacts webservice with invalid Id
    When Login in to API
    When List of contact exists with the outletUUID "<UUID>" in version "<Version>" and URL"<EndPointURL>"
    Then Verify the status code for invalid data is 404

    Examples: 
      | UUID                        | Version |EndPointURL      |
      | c2939b52-4cb7-4cec          | v4      |/api/v4/outlets/ |     