@outletTree @API-V4 @Outlet @API-V4
Feature: || outletTree Endpoint || API V4||
  
          1. API V4 ||  outletTree || Call outletTree webservice
          2. API V4 ||  outletTree || Call outletTree webservice with include sibling as false
          3. API V4 ||  outletTree || Call outletTree webservice with invalid outletUUID

  @outletTreeV4 @API-V4
  Scenario Outline: 1. API V4||  outletTree || Call outletTree webservice
    When Login in to API
    When Call the outlet tree api with outletUUID "<outletUUID>" in version "<Version>" and URL"<EndPointURL>"
    Then Verify the status code is 200
    And Verify the outlet parent "<parent>", child "<child>" and siblings "<siblings>"

    Examples: 
      | outletUUID                           | Version | EndPointURL      | parent              | siblings                      | child   |
      | 287d4a92-1ae2-4ee4-8a4c-d2c9c0e8175b | v4      | /api/v4/outlets/ | The Washington Post | Outlook - The Washington Post | Express |
      
 @outletTreeIncludeSiblingsFalseV4 @API-V4
  Scenario Outline: 2. API V4||  outletTree || Call outletTree webservice with include sibling as false
    When Login in to API
    When Call the outlet tree api with outletUUID "<outletUUID>" in version "<Version>" and URL"<EndPointURL>" with includeSiblings as false
    Then Verify the status code is 200
    And Verify the outlet parent "<parent>", child "<child>" and siblings as blank

    Examples: 
      | outletUUID                           | Version | EndPointURL      | parent              | siblings                      | child   |
      | 287d4a92-1ae2-4ee4-8a4c-d2c9c0e8175b | v4      | /api/v4/outlets/ | The Washington Post | Outlook - The Washington Post | Express |
      
 @outletTreeWithInvalidOutletUUIDV4 @API-V4
  Scenario Outline: 3. API V4||  outletTree || Call outletTree webservice with invalid outletUUID
    When Login in to API
    When Call the outlet tree api with outletUUID "<outletUUID>" in version "<Version>" and URL"<EndPointURL>"
    Then Verify the status code for invalid data is 404

    Examples: 
      | outletUUID                           | Version | EndPointURL      | parent              | siblings                      | child   |
      | abcdefeghij                          | v4      | /api/v4/outlets/ | The Washington Post | Outlook - The Washington Post | Express |     
      
