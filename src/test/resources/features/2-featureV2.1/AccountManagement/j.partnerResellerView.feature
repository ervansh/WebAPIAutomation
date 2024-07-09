@partnerResellerViewV2.1 @accountManagementV2.1 @accountManagement
Feature: ||AccountManagement|| PartnerReseller User Endpoint|| API V2.1 ||
         1. Call Partnerreselleruser webservice and Verify response data and response status

  @partnerResellerViewV2.1 @API-V2.1
  Scenario Outline: 1. Call partner reseller user webservice and Verify response data and response status
    When Login in to API
    Then Call the partner reseller user API"<Version>"
    Then Verify the partner reseller user status after activate and response data
    Then Verify the response status

    Examples: 
      | Version |
      | v2.1      |