@QuickSearchV2 @Search
Feature: ||Search ||QuickSearch Endpoint ||API V2||
           1. Call QuickSearch webservice with name parameters and verify response
           2. Call QuickSearch webservice name and geography id and verify response
           3. Call QuickSearch webservice with outletsortBy ASC and verify response
           4. Call QuickSearch webservice with outletsortBy DESC and verify response

  @NameQuickSearch @API-V2 @Sanity
  Scenario Outline: 1. Call QuickSearch webservice and verify response
    When Login in to API
    Then Call QuickSearch webservice using name parameters "<Parameter>" and value "<Value>" in Version "<Version>"
    Then Verify the status code for QuickSearch
    And Verify the response contains searched name "<FieldName>" and "<Value>" in version "<Version>"

    Examples: 
      | Version | Parameter | Value                                | FieldName |
      | v2      | Name      | The Times of India - Lucknow Edition | Name      |

  @NameQuickSearchwithGeographyID @API-V2
  Scenario Outline: 2. Call QuickSearch webservice name and geography id and verify response
    When Login in to API
    Then Call QuickSearch webservice using parameters "<Parameter1>","<Parameter2>" and value "<Value1>","<Value2>" in Version "<Version>"
    Then Verify the status code for QuickSearch
    And Verify quick search response data with already saved file in version "<Version>"

    Examples: 
      | Version | Parameter1 | Parameter2   | Value1 | Value2 | FieldName |
      | v2      | Name       | GeographyIDs | Asia   |  54294 | Name      |

  @OutletQuickSearchSortByASC @API-V2
  Scenario Outline: 3. Call QuickSearch webservice with outletsortBy ASC and verify response
    When Login in to API
    Then Call QuickSearch webservice using name parameters "<Parameter1>","<Parameter2>","<Parameter3>" and value "<Value1>","<Value2>","<Value3>" in Version "<Version>"
    Then Verify the status code for QuickSearch
    And Verify the response contains name in ASC order "<FieldName>" and "<Value>"

    Examples: 
      | Version | Parameter1 | Parameter2 | Parameter3 | Value1             | Value2 | Value3 | FieldName |
      | v2      | Name       | FieldName  | Order      | The Times of India |      1 |      1 | Name      |

  @OutletQuickSearchSortByDESC @API-V2
  Scenario Outline: 4. Call QuickSearch webservice with outletsortBy DESC and verify response
    When Login in to API
    Then Call QuickSearch webservice using name parameters "<Parameter1>","<Parameter2>","<Parameter3>" and value "<Value1>","<Value2>","<Value3>" in Version "<Version>"
    Then Verify the status code for QuickSearch
    And Verify the response contains name in DESC order "<FieldName>" and "<Value>"

    Examples: 
      | Version | Parameter1 | Parameter2 | Parameter3 | Value1             | Value2 | Value3 | FieldName |
      | v2      | Name       | FieldName  | Order      | The Times of India |      1 |      2 | Name      |
