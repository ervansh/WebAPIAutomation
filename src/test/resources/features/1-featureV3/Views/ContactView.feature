@ContactViewV3 @Views
Feature: || Views || ContactView Endpoint || API V3 ||
         1. Call webservices of contactview with single apiOutletContactId and verify the response
         2. Call webservices of contactview with Multiple apiOutletContactId and verify the response
         3. Call webservices of Using sortBy Name in ASC Order and verify the response
         4. Call webservices of Using sortBy Name in DSC Order and verify the response

  @ContactViewWithSingleAPIOutletContactIDV3 @ContactViewV3 @API-V3 @Sanity
  Scenario Outline: 1. Call webservices of contactview with single apiOutletContactId and verify the response
    When Login in to API
    When Access the ContactView Endpoint "<Version>" with Multiple apiOutletContactId "<parameter>","<value>"
    Then Verify the status code for ContactView Endpoint response
    Then Verify the ContactView Response values "<Response1>" ,"<Value1>" and "<Response2>" ,"<Value2>" and "<Response3>" ,"<Value3>" and "<Response4>" ,"<Value4>"

    Examples: 
      | Version | parameter          | value                                        | Response1   | Value1      | Response2  | Value2                             | Response3 | Value3                       | Response4   | Value4             |
      | v3      | apiOutletContactId | XE818YyjFFjMWklV20QINtYptQfcRkc7kklnpLEDMx4= | contactName | Adam Thomas | outletName | Dumbarton & Vale of Leven Reporter | email     | adam.thomas@newsquest.co.uk  | phoneNumber | + 44  141 435 8888 |

  @ContactViewWithMultipleIdsV3 @API-V3
  Scenario Outline: 2.Call webservices of contactview with Multiple apiOutletContactId and verify the response
    When Login in to API
    When Access the ContactView Endpoint "<Version>" with Multiple apiOutletContactIds "<parameter>"
    Then Verify the status code for ContactView Endpoint response
    Then Veriy the multiple response data for Contact View API using parameter "<FieldName1>" and "<FieldName2>" in Version "<Version>"

    Examples: 
      | Version | parameter          | FieldName1         | FieldName2  |
      | v3      | apiOutletContactId | apiOutletContactId | contactName |

  @ContactViewIDSortByASCV3 @API-V3
  Scenario Outline: 3.Call webservices of Using sortBy Name in ASC Order and verify the response
    When Login in to API
    When Access the ContactView Endpoint "<Version>" with Multiple apiOutletContactIds "<parameter>" using sort by "<sortBy>" and order "<order>"
    Then Verify the status code for ContactView Endpoint response
    Then Veriy the multiple response data for Contact View API using parameter "<FieldName2>" in sort by id in ASC order

    Examples: 
      | Version | parameter          | FieldName1         | FieldName2  | sortBy      | order |
      | v3      | apiOutletContactId | apiOutletContactId | contactName | contactName |     1 |

  @ContactViewIDSortByDESCV3 @API-V3
  Scenario Outline: 4. Call webservices of Using sortBy Name in DSC Order and verify the response
    When Login in to API
    When Access the ContactView Endpoint "<Version>" with Multiple apiOutletContactIds "<parameter>" using sort by "<sortBy>" and order "<order>"
    Then Verify the status code for ContactView Endpoint response
    Then Veriy the multiple response data for Contact View API using parameter "<FieldName2>" in sort by id in DESC order

    Examples: 
      | Version | parameter          | FieldName1         | FieldName2  | sortBy      | order |
      | v3      | apiOutletContactId | apiOutletContactId | contactName | contactName |     2 |
