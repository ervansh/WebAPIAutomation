package com.api.stepdefinition;

import java.util.Random;

import org.json.simple.JSONObject;
import org.junit.Assert;

import com.api.utils.CommanSteps;
import com.api.utils.Configuration;
import com.api.utils.GlobalConstant;
import com.api.utils.JsonFilesUtil;
import com.api.utils.Utilities;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

/**
 * 
 * @author Sonali Sinha
 * @This Class is for Media Research.
 * 
 */

public class MediaResearch extends Utilities{
	JSONObject updatedJSON;
	RequestSpecification req = CommanSteps.getRequest();
	public static int IndexValue;
	public static int targetedListId;
	public static String targetedListName;
	public static int countOnPage;
	public static String inputJsonPath;
	public static String outputJsonPath;
	
	@When("^Add contact \"([^\"]*)\" to Media Research in Version \"([^\"]*)\"$")
	public void add_contact_to_Media_Research_in_Version(String arg1, String Version) throws Throwable {
		if(Version.equals("v3"))
		{
		inputJsonPath=GlobalConstant.AddContactToMRInputV3;
		setEndPoint(GlobalConstant.AddContactToMR3);
		}
		else if(Version.equals("v2.1"))
		{
			inputJsonPath=GlobalConstant.AddContactToMRInputV2point1;
			setEndPoint(GlobalConstant.AddContactToMR2point1);
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, "AddContactToMR", true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMR(getPoiJSONObject(), "action", 1));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMR(getPoiJSONObject(), "firstName", "Sonali"));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMR(getPoiJSONObject(), "lastName", "Sinha"));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMR(getPoiJSONObject(), "outletName", "SonaliSinhaNew"));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMR(getPoiJSONObject(), "emails", 1));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMR(getPoiJSONObject(), "emails", "snlsinha@testing.com"));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMR(getPoiJSONObject(), "phoneNumbers", 1));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMR(getPoiJSONObject(), "phoneNumbers", "9876543210"));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		
	}

	@Then("^Verify the MediaResearch status code is (\\d+)$")
	public void verify_the_MediaResearch_status_code_is(int arg1) throws Throwable {
		Thread.sleep(5000);
		setClassName(this.getClass().getName());
		CommanSteps.verifyResponse(getResponse(), GlobalConstant.HTTP_OK, "");
		Thread.sleep(3000);
	}

	@Then("^Verify the added contact in response from SMRP$")
	public void verify_the_added_contact_in_response_from_SMRP() throws Throwable {
		JsonPath jsonPathEvaluator = getResponse().jsonPath();
		String expectedMsg = null;
		String list = null;
		String language = Configuration.readConfigFile("Language");
		switch (language) {
		case "English (US)":
			list = jsonPathEvaluator.get("userName");
			expectedMsg = Configuration.readMessageFile("AddContactToMediaResearchEnglish");
			break;
		case "French":
			list = jsonPathEvaluator.get("userName");
			expectedMsg = Configuration.readMessageFile("AddContactToMediaResearchFrench");
			break;
		case "Dutch":
			list = jsonPathEvaluator.get("userName");
			expectedMsg = Configuration.readMessageFile("AddContactToMediaResearchDutch");
			break;
		}
	    Assert.assertEquals(expectedMsg,list);
	}

	@When("^Update contact name \"([^\"]*)\" and Email \"([^\"]*)\" to Media Research in Version \"([^\"]*)\"$")
	public void update_contact_name_and_Email_to_Media_Research_in_Version(String contactId, String email, String Version) throws Throwable {
		Random r = new Random();
		int random=r.nextInt(50000);
		if(Version.equals("v3"))
		{
		inputJsonPath=GlobalConstant.AddContactToMRInputV3;
		setEndPoint(GlobalConstant.AddContactToMR3);
		}
		else if(Version.equals("v2.1"))
		{
			inputJsonPath=GlobalConstant.AddContactToMRInputV2point1;
			setEndPoint(GlobalConstant.AddContactToMR2point1);
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, "AddContactToMR", true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMR(getPoiJSONObject(), "action", 2));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMR(getPoiJSONObject(), "apiOutletContactId", contactId));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMR(getPoiJSONObject(), "firstName", "Sonali"));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMR(getPoiJSONObject(), "lastName", "Sinha"));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMR(getPoiJSONObject(), "outletName", "SonaliSinhaNew"));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMR(getPoiJSONObject(), "emails", 2));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMR(getPoiJSONObject(), "emails", "snlsinha"+random+"@testing.com"));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		
	}

	@Then("^Verify the Updated contact in response from SMRP$")
	public void verify_the_Updated_contact_in_response_from_SMRP() throws Throwable {
		JsonPath jsonPathEvaluator = getResponse().jsonPath();
		String expectedMsg = null;
		String list = null;
		String language = Configuration.readConfigFile("Language");
		switch (language) {
		case "English (US)":
			list = jsonPathEvaluator.get("userName");
			expectedMsg = Configuration.readMessageFile("AddContactToMediaResearchEnglish");
			break;
		case "French":
			list = jsonPathEvaluator.get("userName");
			expectedMsg = Configuration.readMessageFile("AddContactToMediaResearchFrench");
			break;
		case "Dutch":
			list = jsonPathEvaluator.get("userName");
			expectedMsg = Configuration.readMessageFile("AddContactToMediaResearchDutch");
			break;
		}
		
	    Assert.assertEquals(expectedMsg,list);
	}
	
	@Then("^Verify the added contact in response$")
	public void verify_the_added_contact_in_response() throws Throwable {
		/*JsonPath jsonPathEvaluator = getResponse().jsonPath();
		String list = jsonPathEvaluator.get("UserName");
		String expectedMsg = Configuration.readMessageFile("AddContactToMediaResearch");
	    Assert.assertEquals(expectedMsg,list);*/
		JsonPath jsonPathEvaluator = getResponse().jsonPath();
		String expectedMsg = null;
		String list = null;
		String language = Configuration.readConfigFile("Language");
		switch (language) {
		case "English (US)":
			list = jsonPathEvaluator.get("UserName");
			expectedMsg = Configuration.readMessageFile("AddContactToMediaResearchEnglish");
			break;
		case "French":
			list = jsonPathEvaluator.get("UserName");
			expectedMsg = Configuration.readMessageFile("AddContactToMediaResearchFrench");
			break;
		case "Dutch":
			list = jsonPathEvaluator.get("UserName");
			expectedMsg = Configuration.readMessageFile("AddContactToMediaResearchDutch");
			break;
		}
	    Assert.assertEquals(expectedMsg,list);
	}
	
	@When("^Update contact name \"([^\"]*)\" and add new number to Media Research in Version \"([^\"]*)\"$")
	public void update_contact_name_and_add_new_number_to_Media_Research_in_Version(String contactId, String Version) throws Throwable {
		Random r = new Random();
		int random=r.nextInt(50000);
		if(Version.equals("v3"))
		{
		inputJsonPath=GlobalConstant.AddContactToMRInputV3;
		setEndPoint(GlobalConstant.AddContactToMR3);
		}
		else if(Version.equals("v2.1"))
		{
			inputJsonPath=GlobalConstant.AddContactToMRInputV2point1;
			setEndPoint(GlobalConstant.AddContactToMR2point1);
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, "AddContactToMR", true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMR(getPoiJSONObject(), "action", 2));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMR(getPoiJSONObject(), "apiOutletContactId", contactId));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMR(getPoiJSONObject(), "outletName", "SonaliSinhaNew"));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMR(getPoiJSONObject(), "phoneNumbers", 2));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMR(getPoiJSONObject(), "phoneNumbers", "98765"+random));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		
	}

	
	@When("^Update contact \"([^\"]*)\" as remove Email to Media Research in Version \"([^\"]*)\"$")
	public void update_contact_as_remove_Email_to_Media_Research_in_Version(String contactId, String Version) throws Throwable {
		if(Version.equals("v3"))
		{
		inputJsonPath=GlobalConstant.AddContactToMRInputV3;
		setEndPoint(GlobalConstant.AddContactToMR3);
		}
		else if(Version.equals("v2.1"))
		{
			inputJsonPath=GlobalConstant.AddContactToMRInputV2point1;
			setEndPoint(GlobalConstant.AddContactToMR2point1);
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, "AddContactToMR", true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMR(getPoiJSONObject(), "action", 2));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMR(getPoiJSONObject(), "apiOutletContactId", contactId));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMR(getPoiJSONObject(), "outletName", "SonaliSinhaNew"));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMR(getPoiJSONObject(), "emails", 3));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		
	}

	
	//For version 2 
	
	
	@When("^Add contact \"([^\"]*)\" to Media Research in Version2 \"([^\"]*)\"$")
	public void add_contact_to_Media_Research_in_Version2(String arg1, String Version) throws Throwable {
		
		inputJsonPath=GlobalConstant.AddContactToMRInputV2;
		if(Version.equalsIgnoreCase("v2Depricated"))
		{
			
		setEndPoint(GlobalConstant.AddContactToMR2Depricated);
		}
		else if(Version.equalsIgnoreCase("v2"))
		{
			
			setEndPoint(GlobalConstant.AddContactToMR2);
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, "AddContactToMR", true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMRV2(getPoiJSONObject(), "Action", 1));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMRV2(getPoiJSONObject(), "FirstName", "Sonali"));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMRV2(getPoiJSONObject(), "LastName", "Sinha"));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMRV2(getPoiJSONObject(), "OutletName", "SonaliSinhaNew"));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMRV2(getPoiJSONObject(), "Emails", 1));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMRV2(getPoiJSONObject(), "Emails", "snlsinha@testing.com"));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMRV2(getPoiJSONObject(), "PhoneNumbers", 1));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMRV2(getPoiJSONObject(), "PhoneNumbers", "9876543210"));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		
	}
	
	@When("^Update contact name \"([^\"]*)\" and Email \"([^\"]*)\" to Media Research in Version2 \"([^\"]*)\"$")
	public void update_contact_name_and_Email_to_Media_Research_in_Version2(String contactId, String email, String Version) throws Throwable {
		Random r = new Random();
		int random=r.nextInt(50000);
		inputJsonPath=GlobalConstant.AddContactToMRInputV2;
		if(Version.equalsIgnoreCase("v2Depricated"))
		{
			
		setEndPoint(GlobalConstant.AddContactToMR2Depricated);
		}
		else if(Version.equalsIgnoreCase("v2"))
		{
			
			setEndPoint(GlobalConstant.AddContactToMR2);
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, "AddContactToMR", true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMRV2(getPoiJSONObject(), "Action", 2));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMRV2(getPoiJSONObject(), "APIOutletContactID", contactId));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMRV2(getPoiJSONObject(), "FirstName", "Sonali"));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMRV2(getPoiJSONObject(), "LastName", "Sinha"));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMRV2(getPoiJSONObject(), "OutletName", "SonaliSinhaNew"));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMRV2(getPoiJSONObject(), "Emails", 2));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMRV2(getPoiJSONObject(), "Emails", "snlsinha"+random+"@testing.com"));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		
	}
	
	@When("^Update contact name \"([^\"]*)\" and add new number to Media Research in Version2 \"([^\"]*)\"$")
	public void update_contact_name_and_add_new_number_to_Media_Research_in_Version2(String contactId, String Version) throws Throwable {
		Random r = new Random();
		int random=r.nextInt(50000);
		inputJsonPath=GlobalConstant.AddContactToMRInputV2;
		if(Version.equalsIgnoreCase("v2Depricated"))
		{
			
		setEndPoint(GlobalConstant.AddContactToMR2Depricated);
		}
		else if(Version.equalsIgnoreCase("v2"))
		{
			
			setEndPoint(GlobalConstant.AddContactToMR2);
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, "AddContactToMR", true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMRV2(getPoiJSONObject(), "Action", 2));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMRV2(getPoiJSONObject(), "APIOutletContactID", contactId));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMRV2(getPoiJSONObject(), "OutletName", "SonaliSinhaNew"));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMRV2(getPoiJSONObject(), "PhoneNumbers", 2));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMRV2(getPoiJSONObject(), "PhoneNumbers", "98765"+random));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		
	}
	
	@When("^Update contact \"([^\"]*)\" as remove Email to Media Research in Version2 \"([^\"]*)\"$")
	public void update_contact_as_remove_Email_to_Media_Research_in_Version2(String contactId, String Version) throws Throwable {
		inputJsonPath=GlobalConstant.AddContactToMRInputV2;
		if(Version.equalsIgnoreCase("v2Depricated"))
		{
			
		setEndPoint(GlobalConstant.AddContactToMR2Depricated);
		}
		else if(Version.equalsIgnoreCase("v2"))
		{
			
			setEndPoint(GlobalConstant.AddContactToMR2);
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, "AddContactToMR", true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMRV2(getPoiJSONObject(), "Action", 2));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMRV2(getPoiJSONObject(), "APIOutletContactID", contactId));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMRV2(getPoiJSONObject(), "OutletName", "SonaliSinhaNew"));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMRV2(getPoiJSONObject(), "Emails", 3));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		
	}
	
	@Then("^Verify the Updated contact in response$")
	public void verify_the_Updated_contact_in_response() throws Throwable {
		/*JsonPath jsonPathEvaluator = getResponse().jsonPath();
		String list = jsonPathEvaluator.get("UserName");
		String expectedMsg = Configuration.readMessageFile("AddContactToMediaResearch");
	    Assert.assertEquals(expectedMsg,list);*/
		JsonPath jsonPathEvaluator = getResponse().jsonPath();
		String expectedMsg = null;
		String list = null;
		String language = Configuration.readConfigFile("Language");
		switch (language) {
		case "English (US)":
			list = jsonPathEvaluator.get("UserName");
			expectedMsg = Configuration.readMessageFile("AddContactToMediaResearchEnglish");
			break;
		case "French":
			list = jsonPathEvaluator.get("UserName");
			expectedMsg = Configuration.readMessageFile("AddContactToMediaResearchFrench");
			break;
		case "Dutch":
			list = jsonPathEvaluator.get("UserName");
			expectedMsg = Configuration.readMessageFile("AddContactToMediaResearchDutch");
			break;
		}
	    Assert.assertEquals(expectedMsg,list);
		
	}
	
	@When("^Add Outlet \"([^\"]*)\" to Media Research in Version \"([^\"]*)\"$")
	public void add_Outlet_to_Media_Research_in_Version(String arg1, String Version) throws Throwable {
		if(Version.equals("v3"))
		{
		inputJsonPath=GlobalConstant.AddContactToMRInputV3;
		setEndPoint(GlobalConstant.AddOutletToMR3);
		}
		else if(Version.equals("v2.1"))
		{
			inputJsonPath=GlobalConstant.AddContactToMRInputV2point1;
			setEndPoint(GlobalConstant.AddOutletToMR2point1);
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, "AddOutletToMR", true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMR(getPoiJSONObject(), "action", 1));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMR(getPoiJSONObject(), "outletName", "SonaliOutlet-Automation"));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMR(getPoiJSONObject(), "emails", 1));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMR(getPoiJSONObject(), "emails", "snlsinha@testing.com"));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMR(getPoiJSONObject(), "phoneNumbers", 1));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMR(getPoiJSONObject(), "phoneNumbers", "9876543210"));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		
	}

	@Then("^Verify the added Outlet in response from SMRP$")
	public void verify_the_added_Outlet_in_response_from_SMRP() throws Throwable {
		/*JsonPath jsonPathEvaluator = getResponse().jsonPath();
		String list = jsonPathEvaluator.get("userName");
		String expectedMsg = Configuration.readMessageFile("AddContactToMediaResearch");
	    Assert.assertEquals(expectedMsg,list);*/
		JsonPath jsonPathEvaluator = getResponse().jsonPath();
		String expectedMsg = null;
		String list = null;
		String language = Configuration.readConfigFile("Language");
		switch (language) {
		case "English (US)":
			list = jsonPathEvaluator.get("userName");
			expectedMsg = Configuration.readMessageFile("AddContactToMediaResearchEnglish");
			break;
		case "French":
			list = jsonPathEvaluator.get("userName");
			expectedMsg = Configuration.readMessageFile("AddContactToMediaResearchFrench");
			break;
		case "Dutch":
			list = jsonPathEvaluator.get("userName");
			expectedMsg = Configuration.readMessageFile("AddContactToMediaResearchDutch");
			break;
		}
	    Assert.assertEquals(expectedMsg,list);
	}

	@When("^Update Outlet name \"([^\"]*)\" and Email \"([^\"]*)\" to Media Research in Version \"([^\"]*)\"$")
	public void update_Outlet_name_and_Email_to_Media_Research_in_Version(String outletID, String email, String Version) throws Throwable {
		if(Version.equals("v3"))
		{
		inputJsonPath=GlobalConstant.AddContactToMRInputV3;
		setEndPoint(GlobalConstant.AddOutletToMR3);
		}
		else if(Version.equals("v2.1"))
		{
			inputJsonPath=GlobalConstant.AddContactToMRInputV2point1;
			setEndPoint(GlobalConstant.AddOutletToMR2point1);
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, "AddOutletToMR", true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMR(getPoiJSONObject(), "action", 2));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMR(getPoiJSONObject(), "outletName", "SonaliOutlet-Automation"));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMR(getPoiJSONObject(), "apiOutletId", outletID));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMR(getPoiJSONObject(), "emails", 2));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMR(getPoiJSONObject(), "emails", "snlsinha@testing.com"));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		
	}

	@Then("^Verify the Updated Outlet in response from SMRP$")
	public void verify_the_Updated_Outlet_in_response_from_SMRP() throws Throwable {
		/*JsonPath jsonPathEvaluator = getResponse().jsonPath();
		String list = jsonPathEvaluator.get("userName");
		String expectedMsg = Configuration.readMessageFile("AddContactToMediaResearch");
	    Assert.assertEquals(expectedMsg,list);*/
		JsonPath jsonPathEvaluator = getResponse().jsonPath();
		String expectedMsg = null;
		String list = null;
		String language = Configuration.readConfigFile("Language");
		switch (language) {
		case "English (US)":
			list = jsonPathEvaluator.get("userName");
			expectedMsg = Configuration.readMessageFile("AddContactToMediaResearchEnglish");
			break;
		case "French":
			list = jsonPathEvaluator.get("userName");
			expectedMsg = Configuration.readMessageFile("AddContactToMediaResearchFrench");
			break;
		case "Dutch":
			list = jsonPathEvaluator.get("userName");
			expectedMsg = Configuration.readMessageFile("AddContactToMediaResearchDutch");
			break;
		}
	    Assert.assertEquals(expectedMsg,list);
	}

	@When("^Update Outlet name \"([^\"]*)\" and add new number to Media Research in Version \"([^\"]*)\"$")
	public void update_Outlet_name_and_add_new_number_to_Media_Research_in_Version(String outletID, String Version) throws Throwable {
		if(Version.equals("v3"))
		{
		inputJsonPath=GlobalConstant.AddContactToMRInputV3;
		setEndPoint(GlobalConstant.AddOutletToMR3);
		}
		else if(Version.equals("v2.1"))
		{
			inputJsonPath=GlobalConstant.AddContactToMRInputV2point1;
			setEndPoint(GlobalConstant.AddOutletToMR2point1);
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, "AddOutletToMR", true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMR(getPoiJSONObject(), "action", 2));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMR(getPoiJSONObject(), "outletName", "SonaliOutlet-Automation"));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMR(getPoiJSONObject(), "apiOutletId", outletID));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMR(getPoiJSONObject(), "phoneNumbers", 1));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMR(getPoiJSONObject(), "phoneNumbers", "9876543210"));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		
	}

	@When("^Update Outlet \"([^\"]*)\" as remove Email to Media Research in Version \"([^\"]*)\"$")
	public void update_Outlet_as_remove_Email_to_Media_Research_in_Version(String outletID, String Version) throws Throwable {
		if(Version.equals("v3"))
		{
		inputJsonPath=GlobalConstant.AddContactToMRInputV3;
		setEndPoint(GlobalConstant.AddOutletToMR3);
		}
		else if(Version.equals("v2.1"))
		{
			inputJsonPath=GlobalConstant.AddContactToMRInputV2point1;
			setEndPoint(GlobalConstant.AddOutletToMR2point1);
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, "AddOutletToMR", true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMR(getPoiJSONObject(), "action", 2));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMR(getPoiJSONObject(), "outletName", "SonaliOutlet-Automation"));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMR(getPoiJSONObject(), "apiOutletId", outletID));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMR(getPoiJSONObject(), "emails", 3));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMR(getPoiJSONObject(), "emails", "snlsinha@testing.com"));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		
	}
	
	@When("^Add Outlet \"([^\"]*)\" to Media Research in Version(\\d+) \"([^\"]*)\"$")
	public void add_Outlet_to_Media_Research_in_Version(String outletID, int arg2, String Version) throws Throwable {
		
		inputJsonPath=GlobalConstant.AddContactToMRInputV2;
		if(Version.equalsIgnoreCase("v2Depricated"))
		{
			
		setEndPoint(GlobalConstant.AddOutletToMR2Depricated);
		}
		else if(Version.equalsIgnoreCase("v2"))
		{
			
			setEndPoint(GlobalConstant.AddOutletToMR2);
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, "AddOutletToMR", true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMRV2(getPoiJSONObject(), "Action", 1));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMRV2(getPoiJSONObject(), "OutletName", "SonaliOutlet-Automation"));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMRV2(getPoiJSONObject(), "Emails", 1));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMRV2(getPoiJSONObject(), "Emails", "snlsinha@testing.com"));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMRV2(getPoiJSONObject(), "PhoneNumbers", 1));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMRV2(getPoiJSONObject(), "PhoneNumbers", "9876543210"));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		
	}

	@Then("^Verify the added Outlet in response$")
	public void verify_the_added_Outlet_in_response() throws Throwable {
		/*JsonPath jsonPathEvaluator = getResponse().jsonPath();
		String list = jsonPathEvaluator.get("UserName");
		String expectedMsg = Configuration.readMessageFile("AddContactToMediaResearch");
	    Assert.assertEquals(expectedMsg,list);*/
		JsonPath jsonPathEvaluator = getResponse().jsonPath();
		String expectedMsg = null;
		String list = null;
		String language = Configuration.readConfigFile("Language");
		switch (language) {
		case "English (US)":
			list = jsonPathEvaluator.get("UserName");
			expectedMsg = Configuration.readMessageFile("AddContactToMediaResearchEnglish");
			break;
		case "French":
			list = jsonPathEvaluator.get("UserName");
			expectedMsg = Configuration.readMessageFile("AddContactToMediaResearchFrench");
			break;
		case "Dutch":
			list = jsonPathEvaluator.get("UserName");
			expectedMsg = Configuration.readMessageFile("AddContactToMediaResearchDutch");
			break;
		}
	    Assert.assertEquals(expectedMsg,list);
	}

	@When("^Update Outlet name \"([^\"]*)\" and Email \"([^\"]*)\" to Media Research in Version(\\d+) \"([^\"]*)\"$")
	public void update_Outlet_name_and_Email_to_Media_Research_in_Version(String outletID, String arg2, int arg3, String Version) throws Throwable {
		
		inputJsonPath=GlobalConstant.AddContactToMRInputV2;
		if(Version.equalsIgnoreCase("v2Depricated"))
		{
			
		setEndPoint(GlobalConstant.AddOutletToMR2Depricated);
		}
		else if(Version.equalsIgnoreCase("v2"))
		{
			
			setEndPoint(GlobalConstant.AddOutletToMR2);
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, "AddOutletToMR", true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMRV2(getPoiJSONObject(), "Action", 2));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMRV2(getPoiJSONObject(), "OutletName", "SonaliOutlet-Automation"));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMRV2(getPoiJSONObject(), "APIOutletID", outletID));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMRV2(getPoiJSONObject(), "Emails", 2));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMRV2(getPoiJSONObject(), "Emails", "snlsinha@testing.com"));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		
	}

	@Then("^Verify the Updated Outlet in response$")
	public void verify_the_Updated_Outlet_in_response() throws Throwable {
		/*JsonPath jsonPathEvaluator = getResponse().jsonPath();
		String list = jsonPathEvaluator.get("UserName");
		String expectedMsg = Configuration.readMessageFile("AddContactToMediaResearch");
	    Assert.assertEquals(expectedMsg,list);*/
		JsonPath jsonPathEvaluator = getResponse().jsonPath();
		String expectedMsg = null;
		String list = null;
		String language = Configuration.readConfigFile("Language");
		switch (language) {
		case "English (US)":
			list = jsonPathEvaluator.get("UserName");
			expectedMsg = Configuration.readMessageFile("AddContactToMediaResearchEnglish");
			break;
		case "French":
			list = jsonPathEvaluator.get("UserName");
			expectedMsg = Configuration.readMessageFile("AddContactToMediaResearchFrench");
			break;
		case "Dutch":
			list = jsonPathEvaluator.get("UserName");
			expectedMsg = Configuration.readMessageFile("AddContactToMediaResearchDutch");
			break;
		}
	    Assert.assertEquals(expectedMsg,list);
	}

	@When("^Update Outlet name \"([^\"]*)\" and add new number to Media Research in Version(\\d+) \"([^\"]*)\"$")
	public void update_Outlet_name_and_add_new_number_to_Media_Research_in_Version(String outletID, int arg, String Version) throws Throwable {
		inputJsonPath=GlobalConstant.AddContactToMRInputV2;
		if(Version.equalsIgnoreCase("v2Depricated"))
		{
			
		setEndPoint(GlobalConstant.AddOutletToMR2Depricated);
		}
		else if(Version.equalsIgnoreCase("v2"))
		{
			
			setEndPoint(GlobalConstant.AddOutletToMR2);
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, "AddOutletToMR", true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMRV2(getPoiJSONObject(), "Action", 2));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMRV2(getPoiJSONObject(), "OutletName", "SonaliOutlet-Automation"));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMRV2(getPoiJSONObject(), "APIOutletID", outletID));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMRV2(getPoiJSONObject(), "PhoneNumbers", 1));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMRV2(getPoiJSONObject(), "PhoneNumbers", "+919657654321"));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		
	}

	@When("^Update Outlet \"([^\"]*)\" as remove Email to Media Research in Version(\\d+) \"([^\"]*)\"$")
	public void update_Outlet_as_remove_Email_to_Media_Research_in_Version(String outletID, int arg2, String Version) throws Throwable {
		inputJsonPath=GlobalConstant.AddContactToMRInputV2;
		if(Version.equalsIgnoreCase("v2Depricated"))
		{
			
		setEndPoint(GlobalConstant.AddOutletToMR2Depricated);
		}
		else if(Version.equalsIgnoreCase("v2"))
		{
			
			setEndPoint(GlobalConstant.AddOutletToMR2);
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, "AddOutletToMR", true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMRV2(getPoiJSONObject(), "Action", 2));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMRV2(getPoiJSONObject(), "OutletName", "SonaliOutlet-Automation"));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMRV2(getPoiJSONObject(), "APIOutletID", outletID));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMRV2(getPoiJSONObject(), "Emails", 3));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueForMRV2(getPoiJSONObject(), "Emails", "snlsinha@testing.com"));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		
	}

}
