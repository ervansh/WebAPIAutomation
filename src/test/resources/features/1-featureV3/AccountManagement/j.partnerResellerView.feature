@partnerResellerViewV3 @accountManagementV3 @accountManagement
Feature: ||AccountManagement|| PartnerReseller User Endpoint||API V3 ||
         1.Call partner reseller user webservice and Verify response data and response status

  @partnerResellerViewV3 @API-V3
  Scenario Outline: 1.Call partner reseller user webservice and Verify response data and response status
    When Login in to API
    Then Call the partner reseller user API"<Version>"
    Then Verify the partner reseller user status after activate and response data
    Then Verify the response status

    Examples: 
      | Version |
      | v3      |
