@userViewV2.1 @accountManagementV2.1 @accountManagement

Feature: ||AccountManagement|| User Views Endpoint || API V2.1 ||
         1.Call UserViews webservice and Verify response data and response status

  @accountViewV2.1 @API-V2.1
  Scenario Outline: 1.Call UserViews webservice and Verify response data and response status
    When Login in to API
    Then Call the user Views API"<Version>"
    Then Verify the user Views status after activate and response data
    Then Verify the response status

    Examples: 
      | Version |
      | v2.1      |

