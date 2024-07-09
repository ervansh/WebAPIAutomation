@outletContactIdsV3
Feature: || OutletContactIds Endpoint||API V3 ||
  
  			  1.  Call outletContactIds webservices with only NAME parameter and verify the response
  			  2.  Call outletContactIds webservices with only SUBJECT parameter and verify the response
  			  3.  Call outletContactIds webservices with only JOB ROLES parameter and verify the response
  			  4.  Call outletContactIds webservices with only MEDIA TYPE parameter and verify the response
  			  5.  Call outletContactIds webservices with only CONTACT NAMES parameter and verify the response
  			  6.  Call outletContactIds webservices with only OUTLET NAMES parameter and verify the response

  @outletContactIdsWithNameParameterv3 @API-V3 @Sanity
  Scenario Outline: 1. Call outletContactIds webservices with only NAME parameter and verify the response
    When Login in to API
    When List of OutletContactIds with the parameter "<Parameter>" and name "<OutletName>""<Version>"
    Then Verify the status code for OutletContactIds is 200
    And Verify the response contains correct OutletContactIds "<OutletName>" "<ParameterContact>" "<lookupName>"

    Examples: 
      | Parameter | OutletName | ParameterContact | Version |
      | names     | Thomas     | contactName      | v3      |

  @outletContactIdsWithSubjectIDParameterv3 @API-V3
  Scenario Outline: 2.  Call outletContactIds webservices with only SUBJECT parameter and verify the response
    When Login in to API
    When List of OutletContactIds with the parameter "<Parameter>" and value "<Id>" using Lookup "<lookupName>""<Version>"
    Then Verify the status code for OutletContactIds is 200
    And Verify the response contains correct OutletContactIds "<OutletName>" "<ParameterContact>" "<lookupName>"

    Examples: 
      | Parameter     | Id | lookupName                 | ParameterContact | Version |
      | subjectSearch | 27 | /api/v3/data/subjectLookup | subjects         | v3      |

  @outletContactIdsWithJobRolesParameterv3 @API-V3
  Scenario Outline: 3.  Call outletContactIds webservices with only JOB ROLES parameter and verify the response
    When Login in to API
    When List of OutletContactIds with the parameter "<Parameter>" and value "<Id>" using Lookup "<lookupName>""<Version>"
    Then Verify the status code for OutletContactIds is 200
    And Verify the response contains correct OutletContactIds "<OutletName>" "<ParameterContact>" "<lookupName>"

    Examples: 
      | Parameter | Id | lookupName                 | ParameterContact | Version |
      | jobRoles  |  3 | /api/v3/data/jobRoleLookup | jobRoles         | v3      |

  @outletContactIdsWithMediaTypeParameterv3 @API-V3
  Scenario Outline:  4.  Call outletContactIds webservices with only MEDIA TYPE parameter and verify the response
    When Login in to API
    When List of OutletContactIds with the parameter "<Parameter>" and value "<Id>" using Lookup "<lookupName>""<Version>"
    Then Verify the status code for OutletContactIds is 200
    And Verify the response contains correct OutletContactIds "<OutletName>" "<ParameterContact>" "<lookupName>"

    Examples: 
      | Parameter  | Id | lookupName                   | ParameterContact | Version |
      | mediaTypes |  3 | /api/v3/data/mediaTypeLookup | primaryMediaType | v3      |

  @outletContactIdsWithContactNamesParameterv3 @API-V3
  Scenario Outline: 5.  Call outletContactIds webservices with only CONTACT NAMES parameter and verify the response
    When Login in to API
    When List of OutletContactIds with the parameter "<Parameter>" and value "<name>" using Lookup "<lookupName>""<Version>"
    Then Verify the status code for OutletContactIds is 200
    And Verify the response contains correct OutletContactIds "<name>" "<ParameterContact>" "<lookupName>"

    Examples: 
      | Parameter    | name   | lookupName                   | ParameterContact | Version |
      | contactNames | thomas | /api/v3/data/frequencyLookup | contactName      | v3      |

  @outletContactIdsWithOutletNamesParameterv3 @API-V3
  Scenario Outline:  6.  Call outletContactIds webservices with only OUTLET NAMES parameter and verify the response
    When Login in to API
    When List of OutletContactIds with the parameter "<Parameter>" and value "<name>" using Lookup "<lookupName>""<Version>"
    Then Verify the status code for OutletContactIds is 200
    And Verify the response contains correct OutletContactIds "<name>" "<ParameterContact>" "<lookupName>"

    Examples: 
      | Parameter   | name   | lookupName                   | ParameterContact | Version |
      | outletNames | Banque | /api/v3/data/frequencyLookup | outletName       | v3      |
