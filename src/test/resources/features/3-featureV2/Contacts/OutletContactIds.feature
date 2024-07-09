@outletContactIdsV2
Feature: || OutletContactIds Endpoints||  API V2 ||
  
  			  1.  Call outletContactIds webservices with only NAME parameter and verify the response
  			  2.  Call outletContactIds webservices with only SUBJECT parameter and verify the response
  			  3.  Call outletContactIds webservices with only JOB ROLES parameter and verify the response
  			  4.  Call outletContactIds webservices with only MEDIA TYPE parameter and verify the response

  @outletContactIdsWithNameParameterv2 @API-V2 @Sanity
  Scenario Outline: 1.  Call outletContactIds webservices with only NAME parameter and verify the response
    When Login in to API
    When List of OutletContactIds with the parameter "<Parameter>" and name "<OutletName>""<Version>"
    Then Verify the status code for OutletContactIds is 200
    And Verify the response contains correct OutletContactIds "<OutletName>" "<ParameterContact>" "<lookupName>"

    Examples: 
      | Parameter | OutletName | ParameterContact | Version |
      | Names     | Thomas     | outletName       | v2      |

  @outletContactIdsWithSubjectIDParameterv2 @API-V2
  Scenario Outline: 2.  Call outletContactIds webservices with only SUBJECT parameter and verify the response
    When Login in to API
    When List of OutletContactIds with the parameter "<Parameter>" and value "<Id>" using Lookup "<lookupName>""<Version>"
    Then Verify the status code for OutletContactIds is 200
    And Verify the response contains correct OutletContactIds "<OutletName>" "<ParameterContact>" "<lookupName>"

    Examples: 
      | Parameter    | Id   | lookupName                 | ParameterContact | Version |
      | WritingAbout | 1001 | /api/v3/data/subjectLookup | subjects         | v2      |

  @outletContactIdsWithJobRolesParameterv2 @API-V2
  Scenario Outline: 3.  Call outletContactIds webservices with only JOB ROLES parameter and verify the response
    When Login in to API
    When List of OutletContactIds with the parameter "<Parameter>" and value "<Id>" using Lookup "<lookupName>""<Version>"
    Then Verify the status code for OutletContactIds is 200
    And Verify the response contains correct OutletContactIds "<OutletName>" "<ParameterContact>" "<lookupName>"

    Examples: 
      | Parameter | Id | lookupName                 | ParameterContact | Version |
      | JobRoles  |  3 | /api/v3/data/jobRoleLookup | jobRoles         | v2      |

  @outletContactIdsWithMediaTypeParameterv2 @API-V2
  Scenario Outline: 4.  Call outletContactIds webservices with only MEDIA TYPE parameter and verify the response
    When Login in to API
    When List of OutletContactIds with the parameter "<Parameter>" and value "<Id>" using Lookup "<lookupName>""<Version>"
    Then Verify the status code for OutletContactIds is 200
    And Verify the response contains correct OutletContactIds "<OutletName>" "<ParameterContact>" "<lookupName>"

    Examples: 
      | Parameter  | Id | lookupName                   | ParameterContact | Version |
      | MediaTypes |  3 | /api/v3/data/mediaTypeLookup | primaryMediaType | v2      |
