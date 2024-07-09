#@createAccountwithRRV4 @accountManagementV4 @accountManagement
#Feature: ||AccountManagement|| Create Account Endpoint ||API V4||
         #1. create account webservice and Verify response data and response status
#
  #@createAccountRRV4 @API-V4 @Sanity
  #Scenario Outline: 1.create account with regional restriction and Verify response data and response status
    #When Login in to API
    #Then Call the create new account API"<Version>" with regional restriction "<regionId>"
    #Then Verify the created new account Name and response data "<regionId>"
    #Then Verify the response status
#
    #Examples: 
      #| Version | regionId |
      #| v4      |    3     |
#
  #@createAccountRRWithFalseGeographiesExcludedV4 @API-V4 @Sanity
  #Scenario Outline: 2.Create account with regional restriction where geographiesExcluded is false and Verify response
    #When Login in to API
    #Then Call the create account API"<Version>" with regional restriction "<regionId>" and geographiesExcluded as false
    #Then Verify the created account Name and response data with "<regionId>"
    #Then Verify the response status
#
    #Examples: 
      #| Version | regionId |
      #| v4      |    3     |
      #
#	@createAccountUisngaccountWithRR @API-V4 @Sanity
  #Scenario Outline: 3.Create a new account using account having regional restriction and Verify response
    #When Login in to API
    #Then Call the create new account API"<Version>" with regional restriction "<regionId>"
    #Then Use above create account API"<Version>" and create user with it
#
    #Examples: 
      #| Version | regionId |
      #| v4      |    3     |    
      #
  #@createAccountUisngaccountWithRR @API-V4 @Sanity
  #Scenario Outline: 3.Create a new account using account having regional restriction and Verify response
    #Then Login with new credentials
    #Then Call the create account API"<Version>" with regional restriction "<regionId>" and geographiesExcluded as false
    #Then Verify the error response data
#
    #Examples: 
      #| Version | regionId |
      #| v4      |    54078 |