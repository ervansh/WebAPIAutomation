@MediaResearchForOutlet @DepricatedMedia @Depricated @MediaResearch
Feature: ||MediaResearch || SendOutletToMediaResearch Endpoint || API v2Depricated ||
         
       1. Call SendOutletToMediaResearch webservice and verify response
           a .Add case 
         2. Call SendOutletToMediaResearch webservice and verify response
           b. Update case
         	   2.1 Update outlet name and email
             2.2 Add new phone number
             2.3 Delete email

  @AddOutletToMediaResearchv3 @API-v2Depricated @Sanity
  Scenario Outline: 1. Call sendOutletToMediaResearch webservice to add Outlet and verify response
    When Login in to API
    When Add Outlet "<OutletName>" to Media Research in Version2 "<Version>"
    Then Verify the MediaResearch status code is 200
    And Verify the added Outlet in response

    Examples: 
      | Version      | OutletName |
      | v2Depricated | Sonali     |

  @UpdateOutletNEmailToMediaResearch @API-v2Depricated
  Scenario Outline: 2.1. Call sendOutletToMediaResearch webservice to update Outlet and verify response
    When Login in to API
    When Update Outlet name "<OutletId>" and Email "<Email>" to Media Research in Version2 "<Version>"
    Then Verify the MediaResearch status code is 200
    And Verify the Updated Outlet in response

    Examples: 
      | Version      | OutletId                 | Email         |
      | v2Depricated | hgCuk8Wp0lKsibO713zPMA== | snl1@test.com |

  @UpdatePhoneToMediaResearch @API-v2Depricated
  Scenario Outline: 2.2. Call sendOutletToMediaResearch webservice to update phone no and verify response
    When Login in to API
    When Update Outlet name "<OutletId>" and add new number to Media Research in Version2 "<Version>"
    Then Verify the MediaResearch status code is 200
    And Verify the Updated Outlet in response

    Examples: 
      | Version      | OutletId                 | Email        |
      | v2Depricated | hgCuk8Wp0lKsibO713zPMA== | snl@test.com |

  @RemoveEmailToMediaResearch @API-v2Depricated
  Scenario Outline: 2.3. Call sendOutletToMediaResearch webservice to remove email and verify response
    When Login in to API
    When Update Outlet "<OutletId>" as remove Email to Media Research in Version2 "<Version>"
    Then Verify the MediaResearch status code is 200
    And Verify the Updated Outlet in response

    Examples: 
      | Version      | OutletId                 | Email        |
      | v2Depricated | hgCuk8Wp0lKsibO713zPMA== | snl@test.com |
