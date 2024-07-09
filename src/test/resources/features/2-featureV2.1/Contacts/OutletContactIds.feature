@outletContactIdsV2.1
Feature: || OutletContactIds Endpoints|| API V2.1 ||
  
  			  1.  Call outletContactIds webservices with only NAME parameter and verify the response
  			  2.  Call outletContactIds webservices with only SUBJECT parameter and verify the response
  			  3.  Call outletContactIds webservices with only JOB ROLES parameter and verify the response
  			  4.  Call outletContactIds webservices with only MEDIA TYPE parameter and verify the response
  			  5.  Call outletContactIds webservices with only CONTACT NAMES parameter and verify the response
  			  6.  Call outletContactIds webservices with only OUTLET NAMES parameter and verify the response

  @outletContactIdsWithNameParameterv2.1 @API-V2.1 @Sanity
  Scenario Outline: 1.  Call outletContactIds webservices with only NAME parameter and verify the response
    When Login in to API
    When List of OutletContactIds with the parameter "<Parameter>" and name "<OutletName>""<Version>"
    Then Verify the status code for OutletContactIds is 200
    And Verify the response contains correct OutletContactIds "<OutletName>" "<ParameterContact>" "<lookupName>"

    Examples: 
      | Parameter | OutletName | ParameterContact | Version |
      | names     | Thomas     | contactName      | v2.1    |

  @outletContactIdsWithSubjectIDParameterv2.1 @API-V2.1
  Scenario Outline: 2.  Call outletContactIds webservices with only SUBJECT parameter and verify the response
    When Login in to API
    When List of OutletContactIds with the parameter "<Parameter>" and value "<Id>" using Lookup "<lookupName>""<Version>"
    Then Verify the status code for OutletContactIds is 200
    And Verify the response contains correct OutletContactIds "<OutletName>" "<ParameterContact>" "<lookupName>"

    Examples: 
      | Parameter    | Id   | lookupName                  | ParameterContact | Version |
      | writingAbout | 1001 | /api/2.1/data/subjectLookup | subjects         | v2.1    |

  @outletContactIdsWithJobRolesParameterv2.1 @API-V2.1
  Scenario Outline: 3.  Call outletContactIds webservices with only JOB ROLES parameter and verify the response
    When Login in to API
    When List of OutletContactIds with the parameter "<Parameter>" and value "<Id>" using Lookup "<lookupName>""<Version>"
    Then Verify the status code for OutletContactIds is 200
    And Verify the response contains correct OutletContactIds "<OutletName>" "<ParameterContact>" "<lookupName>"

    Examples: 
      | Parameter | Id | lookupName                  | ParameterContact | Version |
      | jobRoles  |  3 | /api/2.1/data/jobRoleLookup | jobRoles         | v2.1    |

  @outletContactIdsWithMediaTypeParameterv2.1 @API-V2.1
  Scenario Outline: 4.  Call outletContactIds webservices with only MEDIA TYPE parameter and verify the response
    When Login in to API
    When List of OutletContactIds with the parameter "<Parameter>" and value "<Id>" using Lookup "<lookupName>""<Version>"
    Then Verify the status code for OutletContactIds is 200
    And Verify the response contains correct OutletContactIds "<OutletName>" "<ParameterContact>" "<lookupName>"

    Examples: 
      | Parameter  | Id | lookupName                    | ParameterContact | Version |
      | mediaTypes |  3 | /api/2.1/data/mediaTypeLookup | primaryMediaType | v2.1    |

  @outletContactIdsWithContactNamesParameterv2.1 @API-V2.1
  Scenario Outline: 5.  Call outletContactIds webservices with only CONTACT NAMES parameter and verify the response
    When Login in to API
    When List of OutletContactIds with the parameter "<Parameter>" and value "<name>" using Lookup "<lookupName>""<Version>"
    Then Verify the status code for OutletContactIds is 200
    And Verify the response contains correct OutletContactIds "<name>" "<ParameterContact>" "<lookupName>"

    Examples: 
      | Parameter    | name   | lookupName                    | ParameterContact | Version |
      | contactNames | thomas | /api/2.1/data/frequencyLookup | contactName      | v2.1    |

  @outletContactIdsWithOutletNamesParameterv2.1 @API-V2.1
  Scenario Outline: 6.  Call outletContactIds webservices with only OUTLET NAMES parameter and verify the response
    When Login in to API
    When List of OutletContactIds with the parameter "<Parameter>" and value "<name>" using Lookup "<lookupName>""<Version>"
    Then Verify the status code for OutletContactIds is 200
    And Verify the response contains correct OutletContactIds "<name>" "<ParameterContact>" "<lookupName>"

    Examples: 
      | Parameter   | name   | lookupName                    | ParameterContact | Version |
      | outletNames | Banque | /api/2.1/data/frequencyLookup | outletName       | v2.1    |
