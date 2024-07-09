package com.api.stepdefinition;

import org.json.simple.JSONObject;
import org.junit.Assert;

import com.api.utils.CommanSteps;
import com.api.utils.Configuration;
import com.api.utils.GlobalConstant;
import com.api.utils.JsonFilesUtil;
import com.api.utils.Utilities;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * 
 * @author Sonali Sinha
 * @This Class is for targetedList.
 * 
 */
public class TargetedList extends Utilities{
	JSONObject updatedJSON;
	RequestSpecification req = CommanSteps.getRequest();
	public static int IndexValue;
	public static int targetedListId;
	public static String targetedListName;
	public static int countOnPage;
	public static String inputJsonPath;
	public static String outputJsonPath;

	/**
	 * 
	 * @param This
	 *            method accept parameter and value which we pass from feature
	 *            file
	 * @In this method user hit the contact API and all the Endpoint API are
	 *     written in GlobalConstant Class.
	 * @throws Throwable
	 */
	@When("^Create a new targeted list with the parameters \"([^\"]*)\",\"([^\"]*)\" values \"([^\"]*)\",\"([^\"]*)\" in version \"([^\"]*)\"$")
	public void create_a_new_targeted_list_with_the_parameters_values_in_version(String parameter1, String parameter2, String parameterValue1, String parameterValue2, String Version) throws Throwable {
		if (Version.contains("v3")) {
			
			inputJsonPath=GlobalConstant.targetedlistInputV3;
			outputJsonPath=GlobalConstant.targetedlistOutputV3;
			setEndPoint(GlobalConstant.targetedList3);
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath=GlobalConstant.targetedlistInputV2point1;
			outputJsonPath=GlobalConstant.targetedlistOutputV2point1;
			setEndPoint(GlobalConstant.targetedList2point1);
		}else if (Version.contains("v2")) {
			
			inputJsonPath=GlobalConstant.targetedlistInputV2;
			outputJsonPath=GlobalConstant.targetedlistOutputV2;
			setEndPoint(GlobalConstant.targetedList2);
		}else if (Version.contains("v4")) {
			
			inputJsonPath=GlobalConstant.targetedlistInputV4;
			outputJsonPath=GlobalConstant.targetedlistOutputV4;
			setEndPoint(GlobalConstant.targetedList4);
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, "targetedList", true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter1, parameterValue1+System.currentTimeMillis()));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter2, parameterValue2));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		
		
	}

	@Then("^Verify the TargetedLists status code is (\\d+)$")
	public void verify_the_TargetedLists_status_code_is(int arg1) throws Throwable {
		if(arg1==204)
		{
			Thread.sleep(1000);
			setClassName(this.getClass().getName());
			CommanSteps.verifyResponse(getResponse(), GlobalConstant.NO_CONTENT, "");
			Thread.sleep(1000);
		}else {
		Thread.sleep(1000);
		setClassName(this.getClass().getName());
		CommanSteps.verifyResponse(getResponse(), GlobalConstant.HTTP_OK, "");
		Thread.sleep(1000);
		}
	}

	@Then("^Verify the targeted list response contains given list names \"([^\"]*)\" using fieldName \"([^\"]*)\",\"([^\"]*)\"$")
	public void verify_the_targeted_list_response_contains_given_list_names_using_fieldName(String listName, String fieldname1, String fieldname2) throws Throwable {
		
		targetedListId = getResponse().path("result." + fieldname1 + "");
		targetedListName = getResponse().path("result." + fieldname2 + "");
		//targetedListId=(int) getDataFromResponseParameter(getResponse(), fieldname1, "v4");
		//targetedListName=(String) getDataFromResponseParameter(getResponse(), fieldname2, "v4");
		Assert.assertTrue(targetedListName.toLowerCase().contains(listName.toLowerCase()));

		//Utilities.targetResponseVerification(getResponse(), fieldname2, listName);
	}
	
	@Then("^Verify the targeted list response contains given list name \"([^\"]*)\" using fieldName \"([^\"]*)\",\"([^\"]*)\"$")
	public void verify_the_targeted_list_response_contains_given_list_name_using_fieldName(String listName, String fieldname1, String fieldname2) throws Throwable {
	
	targetedListId=getResponse().path(fieldname1);
	targetedListName=getResponse().path(fieldname2);
	Utilities.targetResponseVerification(getResponse(), fieldname2, listName);
	
	}

	@When("^Create a new targeted list with the parameters \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" values \"([^\"]*)\",\"([^\"]*)\" in version \"([^\"]*)\"$")
	public void create_a_new_targeted_list_with_the_parameters_values_in_version(String parameter1, String parameter2, String parameter3, String parameterValue1, String parameterValue2, String Version) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (Version.contains("v3")) {
			
			inputJsonPath=GlobalConstant.targetedlistInputV3;
			outputJsonPath=GlobalConstant.targetedlistOutputV3;
			setEndPoint(GlobalConstant.targetedList3);
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath=GlobalConstant.targetedlistInputV2point1;
			outputJsonPath=GlobalConstant.targetedlistOutputV2point1;
			setEndPoint(GlobalConstant.targetedList2point1);
		}else if (Version.contains("v2")) {
			
			inputJsonPath=GlobalConstant.targetedlistInputV2;
			outputJsonPath=GlobalConstant.targetedlistOutputV2;
			setEndPoint(GlobalConstant.targetedList2);
		}else if (Version.contains("v4")) {
			
			inputJsonPath=GlobalConstant.targetedlistInputV4;
			outputJsonPath=GlobalConstant.targetedlistOutputV4;
			setEndPoint(GlobalConstant.targetedList4);
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, "targetedList", true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter1, parameterValue1+System.currentTimeMillis()));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter2, parameterValue2));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter3, targetedListId));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		
		
	}

	@When("^Get all targeted lists in version \"([^\"]*)\"$")
	public Response get_all_targeted_lists_in_version(String Version) throws Throwable {
		if (Version.contains("v3")) {
			
			setEndPoint(GlobalConstant.targetedIndex3);
		} else if (Version.contains("v2.1")) {
			
			setEndPoint(GlobalConstant.targetedIndex2point1);
		}else if (Version.contains("v2")) {
			if (Version.equalsIgnoreCase("v2Depricated")) {
				
				setEndPoint(GlobalConstant.targetedIndex2Depricated);
			} else {
				
				setEndPoint(GlobalConstant.targetedIndex2);
			}
			
		}else if (Version.contains("v4")) {
			
			setEndPoint(GlobalConstant.targetedIndex4);
		}
		setResponse(getRequest().get(getEndPoint()));
		
		return getResponse();
	}

	@When("^Verify the TargetedListIndex response using fieldName \"([^\"]*)\",\"([^\"]*)\"$")
	public void verify_the_TargetedListIndex_response_using_fieldName(String fieldname1, String fieldname2) throws Throwable {
		Utilities.targetIndexResponseVerification(getResponse(), fieldname1, targetedListId);
	}


	@When("^Get targeted lists Using parameter \"([^\"]*)\" and value \"([^\"]*)\" in version \"([^\"]*)\"$")
	public void get_targeted_lists_Using_parameter_and_value_in_version(String Parameter, String Value, String Version) throws Throwable {
		if (Version.contains("v3")) {
			
			setEndPoint(GlobalConstant.targetedIndex3);
		} else if (Version.contains("v2.1")) {
			
			setEndPoint(GlobalConstant.targetedIndex2point1);
		}else if (Version.contains("v2")) {
			if (Version.equalsIgnoreCase("v2Depricated")) {
				
				setEndPoint(GlobalConstant.targetedIndex2Depricated);
			} else {
				
				setEndPoint(GlobalConstant.targetedIndex2);
			}
			
		}else if (Version.contains("v4")) {
			
			setEndPoint(GlobalConstant.targetedIndex4);
		}
		getRequest().queryParam(Parameter, Value);
		setResponse(getRequest().get(getEndPoint()));
		
		 
	}

	@When("^Verify the TargetedListIndex response for itemsPerPage using fieldName \"([^\"]*)\",\"([^\"]*)\" in version \"([^\"]*)\"$")
	public void verify_the_TargetedListIndex_response_for_itemsPerPage_using_fieldName_in_version(String fieldname1, String fieldname2,String Version) throws Throwable {
		if(Version.equals("v2")||Version.equals("v2Depricated"))
		{
			Utilities.targetIndexResponseVerification(getResponse(), fieldname1, targetedListId);
			int itemsCount = getResponse().path(fieldname2);
			Assert.assertEquals(itemsCount, 1);
		}else if(Version.equals("v4"))
		{
			//Utilities.targetIndexResponseVerificationV4(getResponse(), fieldname1, targetedListId);
			int itemsCount = getResponse().path("metadata." +fieldname2);
			Assert.assertEquals(itemsCount, 1);
		}
		else
		{
			Utilities.targetIndexResponseVerification(getResponse(), fieldname1, targetedListId);
			int itemsCount = getResponse().path("searchMetaData."+fieldname2+"");
			Assert.assertEquals(itemsCount, 1);
		}
	}

	@When("^Get targeted lists Using parameters \"([^\"]*)\", \"([^\"]*)\" and value \"([^\"]*)\" \"([^\"]*)\" in version \"([^\"]*)\"$")
	public void get_targeted_lists_Using_parameters_and_value_in_version(String Parameter1, String Parameter2, String Value1, String Value2, String Version) throws Throwable {
		if (Version.contains("v3")) {
			
			setEndPoint(GlobalConstant.targetedIndex3);
		} else if (Version.contains("v2.1")) {
			
			setEndPoint(GlobalConstant.targetedIndex2point1);
		}else if (Version.contains("v2")) {
			
			setEndPoint(GlobalConstant.targetedIndex2);
		}
		getRequest().queryParam(Parameter1, Value1);
		getRequest().queryParam(Parameter2, Value2);
		setResponse(getRequest().get(getEndPoint()));
		
		 
	}

	@When("^Verify the targeted list response contains \"([^\"]*)\" in ASC order$")
	public void verify_the_targeted_list_response_contains_in_ASC_order(String value) throws Throwable {
		Utilities.sortByASC(getResponse(), value);
	}

	@When("^Verify the targeted list response contains \"([^\"]*)\" in DESC order$")
	public void verify_the_targeted_list_response_contains_in_DESC_order(String value) throws Throwable {
		Utilities.sortByDESC(getResponse(), value);
	}

	@When("^Get targeted list summary using parameter \"([^\"]*)\" and value \"([^\"]*)\" in version \"([^\"]*)\"$")
	public void get_targeted_list_summary_using_parameter_and_value_in_version(String Parameter1, String Value1, String Version) throws Throwable {
		if (Version.contains("v3")) {
			
			setEndPoint(GlobalConstant.targetedSummary3);
			getRequest().queryParam(Parameter1, targetedListId);
		} else if (Version.contains("v2.1")) {
			
			setEndPoint(GlobalConstant.targetedSummary2point1);
			getRequest().queryParam(Parameter1, targetedListId);
		}else if (Version.contains("v2")) {
			
			setEndPoint(GlobalConstant.targetedSummary2);
			getRequest().queryParam(Parameter1, targetedListId);
		}else if (Version.contains("v4")) {
			setEndPoint(GlobalConstant.targetedSummary4+targetedListId);
		}
		
		setResponse(getRequest().get(getEndPoint()));
		
		
	}

	@Then("^Verify the Targeted summary response fieldName \"([^\"]*)\"$")
	public void verify_the_Targeted_summary_response_fieldName(String fieldName) throws Throwable {
		Utilities.targetResponseVerification(getResponse(), fieldName, "automation");
	}

	@When("^list all contacts using parameter \"([^\"]*)\" in version \"([^\"]*)\"$")
	public Response list_all_contacts_using_parameter_in_version(String Parameter1, String Version) throws Throwable {
		//targetedListId=590548;
		if (Version.contains("v3")) {
			
			setEndPoint(GlobalConstant.targetedListContact3);
			getRequest().queryParam(Parameter1, targetedListId);
		} else if (Version.contains("v2.1")) {
			
			setEndPoint(GlobalConstant.targetedListContact2point1);
			getRequest().queryParam(Parameter1, targetedListId);
		}else if (Version.contains("v2")) {
			if (Version.equalsIgnoreCase("v2Depricated")) {
				
				setEndPoint(GlobalConstant.targetedListContact2Depricated);
				getRequest().queryParam(Parameter1, targetedListId);
			} else {
				
				setEndPoint(GlobalConstant.targetedListContact2);
				getRequest().queryParam(Parameter1, targetedListId);
			}
		}else if (Version.contains("v4")) {
			
			setEndPoint(GlobalConstant.targetedListContact4+targetedListId+"/contacts");
		}
		
		
		setResponse(getRequest().get(getEndPoint()));
		
		return getResponse();

	}

	@When("^Verify the contacts response contains given value \"([^\"]*)\" using fieldName \"([^\"]*)\",\"([^\"]*)\"$")
	public void verify_the_contacts_response_contains_given_value_using_fieldName(String contactId, String fieldName1, String fieldName2) throws Throwable {
		Utilities.responseVerificationWithoutIteration(getResponse(), fieldName1, contactId);
	}

	@When("^list all contacts using parameters \"([^\"]*)\",\"([^\"]*)\" and value \"([^\"]*)\" in version \"([^\"]*)\"$")
	public void list_all_contacts_using_parameters_and_value_in_version(String Parameter1, String Parameter2,String Value,String Version) throws Throwable {
		//targetedListId=590548;
		if (Version.contains("v3")) {			
			setEndPoint(GlobalConstant.targetedListContact3);
			getRequest().queryParam(Parameter1, targetedListId);
		} else if (Version.contains("v2.1")) {
			setEndPoint(GlobalConstant.targetedListContact2point1);
			getRequest().queryParam(Parameter1, targetedListId);
		}else if (Version.contains("v2")) {
			setEndPoint(GlobalConstant.targetedListContact2);
			getRequest().queryParam(Parameter1, targetedListId);
		}else if (Version.contains("v4")) {
			setEndPoint(GlobalConstant.targetedListContact4+targetedListId+"/contacts");
		}
		
		getRequest().queryParam(Parameter2, Value);
		setResponse(getRequest().get(getEndPoint()));
		

	}

	@Then("^Verify the response contains given itemsPerPage \"([^\"]*)\" using fieldName \"([^\"]*)\",\"([^\"]*)\" in version \"([^\"]*)\"$")
	public void verify_the_response_contains_given_itemsPerPage_using_fieldName_in_version(int value, String fieldName1, String fieldName2, String Version) throws Throwable {
		if(Version.equals("v2")||Version.equals("v2Depricated"))
		{
			int itemsCount = getResponse().path(fieldName1);
			Assert.assertEquals(itemsCount, value);
		}
		else
		{
			int itemsCount = getResponse().path("searchMetaData."+fieldName1+"");
			Assert.assertEquals(itemsCount, value);
		}

	}

	@When("^list all contacts using sortBy parameters \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and values \"([^\"]*)\",\"([^\"]*)\" in version \"([^\"]*)\"$")
	public void list_all_contacts_using_sortBy_parameters_and_values_in_version(String Parameter1, String Parameter2, String Parameter3, String Value1, String Value2, String Version) throws Throwable {
		//targetedListId=590548;
		if (Version.contains("v3")) {
			
			setEndPoint(GlobalConstant.targetedListContact3);
		} else if (Version.contains("v2.1")) {
			
			setEndPoint(GlobalConstant.targetedListContact2point1);
		}else if (Version.contains("v2")) {
			
			setEndPoint(GlobalConstant.targetedListContact2);
		}
		getRequest().queryParam(Parameter1, targetedListId);
		getRequest().queryParam(Parameter2, Value1);
		getRequest().queryParam(Parameter3, Value2);
		setResponse(getRequest().get(getEndPoint()));
		
	}

	@Then("^Verify the list all contacts in a targeted list response contains \"([^\"]*)\" in DESC order$")
	public void verify_the_list_all_contacts_in_a_targeted_list_response_contains_in_DESC_order(String value) throws Throwable {
		Utilities.sortByDESC(getResponse(), value);
	}

	@When("^Update the targeted list name using parameters \"([^\"]*)\", \"([^\"]*)\" and value \"([^\"]*)\" in version \"([^\"]*)\"$")
	public void update_the_targeted_list_name_using_parameters_and_value_in_version(String TargetListId, String targetedListName, String Value, String Version) throws Throwable {
		//targetedListId=590548;
		if (Version.contains("v3")) {			
			inputJsonPath=GlobalConstant.targetedlistInputV3;
			setEndPoint(GlobalConstant.targetedListUpdate3);
			setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, "UpdateTargetedList", true));
			setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), TargetListId, targetedListId));
		} else if (Version.contains("v2.1")) {			
			inputJsonPath=GlobalConstant.targetedlistInputV2point1;
			setEndPoint(GlobalConstant.targetedListUpdate2point1);
			setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, "UpdateTargetedList", true));
			setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), TargetListId, targetedListId));
		}else if (Version.contains("v2")) {			
			inputJsonPath=GlobalConstant.targetedlistInputV2;
			setEndPoint(GlobalConstant.targetedListUpdate2);
			setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, "UpdateTargetedList", true));
			setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), TargetListId, targetedListId));
		}else if (Version.contains("v4")) {			
			inputJsonPath=GlobalConstant.targetedlistInputV4;
			setEndPoint(GlobalConstant.targetedListUpdate4+targetedListId);
			setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, "UpdateTargetedList", true));
			
		}
		
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), targetedListName, Value+System.currentTimeMillis()));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().put(getEndPoint()));
		
		
	}

	@When("^Add contact to targeted list using parameters \"([^\"]*)\", \"([^\"]*)\" and value \"([^\"]*)\" in version \"([^\"]*)\"$")
	public void add_contact_to_targeted_list_using_parameters_and_value_in_version(String ListId, String apiOutletcontactid, String Value, String Version) throws Throwable {
		//targetedListId=583504;
		if (Version.contains("v3")) {
			
			inputJsonPath=GlobalConstant.targetedlistInputV3;
			setEndPoint(GlobalConstant.AddContactTotargetedList3);
			setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, "AddContactToTargetList", true));
			setPoiJSONObject(JsonFilesUtil.targetedListUpdate(getPoiJSONObject(), ListId, targetedListId));
			setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), apiOutletcontactid, Value));

		} else if (Version.contains("v2.1")) {
			
			inputJsonPath=GlobalConstant.targetedlistInputV2point1;
			setEndPoint(GlobalConstant.AddContactTotargetedList2point1);
			setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, "AddContactToTargetList", true));
			setPoiJSONObject(JsonFilesUtil.targetedListUpdate(getPoiJSONObject(), ListId, targetedListId));
			setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), apiOutletcontactid, Value));

		}else if (Version.contains("v2")) {
			
			inputJsonPath=GlobalConstant.targetedlistInputV2;
			setEndPoint(GlobalConstant.AddContactTotargetedList2);
			setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, "AddContactToTargetList", true));
			setPoiJSONObject(JsonFilesUtil.targetedListUpdate(getPoiJSONObject(), ListId, targetedListId));
			setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), apiOutletcontactid, Value));

		}else if (Version.contains("v4")) {
			
			inputJsonPath=GlobalConstant.targetedlistInputV4;
			setEndPoint(GlobalConstant.AddContactTotargetedList4+targetedListId+"/contacts");
			setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, "AddContactToTargetList", true));
			setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), apiOutletcontactid, Value));

		}
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		
		
	}

	@Then("^Verify the targeted list response contains added contact \"([^\"]*)\"$")
	public void verify_the_targeted_list_response_contains_added_contact(String arg1) throws Throwable {
	if(arg1.equalsIgnoreCase("contactUuids"))
	{
		String expectedMsg = Configuration.readMessageFile("contactAddedToTargetListV4");
		Assert.assertEquals(expectedMsg, getResponse().body().asString().trim());
	}else {
	String expectedMsg = Configuration.readMessageFile("contactAddedToTargetList");
	Assert.assertEquals(expectedMsg, getResponse().body().asString().trim());
	}
	}
	
	@When("^Remove contact to targeted list using parameters \"([^\"]*)\", \"([^\"]*)\" and value \"([^\"]*)\" in version \"([^\"]*)\"$")
	public void remove_contact_to_targeted_list_using_parameters_and_value_in_version(String targetListId, String apiOutletcontactid, String Value, String Version) throws Throwable {
		//targetedListId=590548;
		if (Version.contains("v3")) {
			
			inputJsonPath=GlobalConstant.targetedlistInputV3;
			setEndPoint(GlobalConstant.RemoveContactTotargetedList3);
			setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, "RemoveContactTargetList", true));
			setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), targetListId, targetedListId));
			setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), apiOutletcontactid, Value));
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath=GlobalConstant.targetedlistInputV2point1;
			setEndPoint(GlobalConstant.RemoveContactTotargetedList2point1);
			setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, "RemoveContactTargetList", true));
			setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), targetListId, targetedListId));
			setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), apiOutletcontactid, Value));
		}else if (Version.contains("v2")) {
			
			inputJsonPath=GlobalConstant.targetedlistInputV2;
			setEndPoint(GlobalConstant.RemoveContactTotargetedList2);
			setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, "RemoveContactTargetList", true));
			setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), targetListId, targetedListId));
			setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), apiOutletcontactid, Value));
		}else if (Version.contains("v4")) {
			
			inputJsonPath=GlobalConstant.targetedlistInputV4;
			setEndPoint(GlobalConstant.RemoveContactTotargetedList4+625427+"/contacts");
			setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, "RemoveContactTargetList", true));
			setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), apiOutletcontactid, Value));
		}
		
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().delete(getEndPoint()));
		
	}

	@Then("^Verify the targeted list response contains Removed contact \"([^\"]*)\"$")
	public void verify_the_targeted_list_response_contains_Removed_contact(String arg1) throws Throwable {
		if(arg1.equalsIgnoreCase("contactUuids"))
		{
			String expectedMsg = Configuration.readMessageFile("contactAddedToTargetListV4");
			Assert.assertEquals(expectedMsg, getResponse().body().asString().trim());
		}else {
		String expectedMsg = Configuration.readMessageFile("contactRemovedFromTargetList");
		Assert.assertEquals(expectedMsg, getResponse().body().asString().trim());
		}
	}
	
	@When("^Delete targeted list using parameters \"([^\"]*)\" in version \"([^\"]*)\"$")
	public void delete_targeted_list_using_parameters_in_version(String targetedListIds, String Version) throws Throwable {
		//targetedListId=590548;
		if (Version.contains("v3")) {
			
			inputJsonPath=GlobalConstant.targetedlistInputV3;
			setEndPoint(GlobalConstant.DeletetargetedList3);
			setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, "DeleteTargetList", true));
			setPoiJSONObject(JsonFilesUtil.updateAccountJsonValue(getPoiJSONObject(), targetedListIds, targetedListId));
			getRequest().body(getPoiJSONObject().toString());
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath=GlobalConstant.targetedlistInputV2point1;
			setEndPoint(GlobalConstant.DeletetargetedList2point1);
			setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, "DeleteTargetList", true));
			setPoiJSONObject(JsonFilesUtil.updateAccountJsonValue(getPoiJSONObject(), targetedListIds, targetedListId));
			getRequest().body(getPoiJSONObject().toString());
		}else if (Version.contains("v2")) {
			
			inputJsonPath=GlobalConstant.targetedlistInputV2;
			setEndPoint(GlobalConstant.DeletetargetedList2);
			setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, "DeleteTargetList", true));
			setPoiJSONObject(JsonFilesUtil.updateAccountJsonValue(getPoiJSONObject(), targetedListIds, targetedListId));
			getRequest().body(getPoiJSONObject().toString());
		}else if (Version.contains("v4")) {
			
			inputJsonPath=GlobalConstant.targetedlistInputV4;
			setEndPoint(GlobalConstant.DeletetargetedList4+625427);
		}
		
		setResponse(getRequest().delete(getEndPoint()));
		
	}

	@Then("^Verify the Delete targeted list response message$")
	public void verify_the_Delete_targeted_list_response_message() throws Throwable {
		String expectedMsg = Configuration.readMessageFile("deleteTargetList");
		Assert.assertEquals(expectedMsg, getResponse().body().asString().trim());
	}

}