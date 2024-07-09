package com.api.stepdefinition;

import static com.api.utils.GlobalConstant.FileName.ContactKeywordSearch;

import com.api.utils.CommanSteps;
import com.api.utils.Configuration;
import com.api.utils.GlobalConstant;
import com.api.utils.JsonFilesUtil;
import com.api.utils.Utilities;

import cucumber.api.java.en.Then;

public class ContactKeywordSearch extends Utilities {
	public static String version;
	public static String inputJsonPath;
	public static String outputJsonPath;
	public static Object responseResult;
	public static Object verificationValue;

	@Then("^Call the contact keyword search API and search any contact\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void call_the_contact_keyword_search_API_and_search_any_contact(String parameter, String parameterValue,
			String Version) throws Throwable {
		version = Version;
		if (Version.contains("v3")) {
			inputJsonPath = GlobalConstant.contactInputV3;
			setEndPoint(GlobalConstant.contactKeywordSearch3);
		} else if (Version.contains("v2.1")) {
			inputJsonPath = GlobalConstant.contactInputV2point1;
			setEndPoint(GlobalConstant.contactKeywordSearch2point1);
		}else if (Version.contains("v4")) {
			inputJsonPath=GlobalConstant.contactInputV4;
			outputJsonPath=GlobalConstant.contactOutputV4;
			setEndPoint(GlobalConstant.contactKeywordSearch4);
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, ContactKeywordSearch.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter, parameterValue));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}

	@Then("^Verify the response status for conatct keyword search$")
	public void verify_the_response_status_for_conatct_keyword_search() throws Throwable {
		Thread.sleep(3000);
		setClassName(this.getClass().getName());
		CommanSteps.verifyResponse(getResponse(), GlobalConstant.HTTP_OK, "");
		Thread.sleep(3000);
	}

	@Then("^Verify the response messaage for conatct search\"([^\"]*)\",\"([^\"]*)\"$")
	public void verify_the_response_messaage_for_conatct_search(String parameter1, String parameter2) throws Throwable {
		responseResult = getDataFromResponseParameter(getResponse(), parameter1, version);
		verificationValue = Configuration.readApplicationData("contactsearchcontactName", "Config");
		verifyResposeParameter(responseResult, verificationValue.toString());
		responseResult = getDataFromResponseParameter(getResponse(), parameter2, version);
		verificationValue = Configuration.readApplicationData("contactsearchoutletName", "Config");
		verifyResposeParameter(responseResult, verificationValue.toString());
	}
	
	@Then("^Verify the response message for contact search\"([^\"]*)\",\"([^\"]*)\"$")
	public void verify_the_response_message_for_contact_search(String parameter1, String parameter2) throws Throwable {
		responseResult = getDataFromResponseParameter(getResponse(), parameter1, version);
		verificationValue = Configuration.readApplicationData("contactsearchcontactNamev4", "Config");
		verifyResposeParameter(responseResult, verificationValue.toString());
		responseResult = getDataFromResponseParameter(getResponse(), parameter2, version);
	}

	@Then("^Verify the response messaage for outlet search\"([^\"]*)\",\"([^\"]*)\"$")
	public void verify_the_response_messaage_for_outlet_search(String parameter1, String parameter2) throws Throwable {
		responseResult = getDataFromResponseParameter(getResponse(), parameter1, version);
		verificationValue = Configuration.readApplicationData("outletsearchcontactName", "Config");
		verifyResposeParameter(responseResult, verificationValue.toString());
		responseResult = getDataFromResponseParameter(getResponse(), parameter2, version);
		verificationValue = Configuration.readApplicationData("outletsearchoutletName", "Config");
		verifyResposeParameter(responseResult, verificationValue.toString());
	}
	
	
	@Then("^Call the contact keyword search API and search any contact using geography \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void call_the_contact_keyword_search_API_and_search_any_contact_using_geography(String parameter1, String parameterValue1, String parameter2, String parameterValue2, String Version) throws Throwable {
		inputJsonPath=GlobalConstant.contactInputV4;
		outputJsonPath=GlobalConstant.contactOutputV4;
		setEndPoint(GlobalConstant.contactKeywordSearch4);
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, ContactKeywordSearch.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter1, parameterValue1));
		setPoiJSONObject(JsonFilesUtil.updateJsonwithmultipleValue(getPoiJSONObject(), parameter2, parameterValue2, "CONTINENT"));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}
	
	@Then("^Verify the response mesaage for outlet search\"([^\"]*)\",\"([^\"]*)\"$")
	public void verify_the_response_mesaage_for_outlet_search(String parameter1, String parameter2) throws Throwable {
		responseResult = getDataFromResponseParameter(getResponse(), parameter1, version);
		verificationValue = Configuration.readApplicationData("outletsearchcontactNamev4", "Config");
		verifyResposeParameter(responseResult, verificationValue.toString());
	}

	@Then("^Call the contact keyword search API and search any contact\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void call_the_contact_keyword_search_API_and_search_any_contact(String parameter1, String value1,
			String parameter2, String value2, String Version) throws Throwable {
		version = Version;
		if (Version.contains("v3")) {
			
			inputJsonPath = GlobalConstant.contactInputV3;
			setEndPoint(GlobalConstant.contactKeywordSearch3);
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath = GlobalConstant.contactInputV2point1;
			setEndPoint(GlobalConstant.contactKeywordSearch2point1);
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, ContactKeywordSearch.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter1, value1));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter2, value2));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}
	
	@Then("^Call the contact keyword search API and search any contact\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void call_the_contact_keyword_search_API_and_search_any_contact(String parameter1, String parameterValue1, String sortby, String sortValue, String ordeby, String orderValue, String Version) throws Throwable {
		inputJsonPath=GlobalConstant.contactInputV4;
		outputJsonPath=GlobalConstant.contactOutputV4;
		setEndPoint(GlobalConstant.contactKeywordSearch4);
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, ContactKeywordSearch.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), parameter1, parameterValue1));
		getRequest().body(getPoiJSONObject().toString()).queryParam(sortby, sortValue).queryParam(ordeby, orderValue);
		setResponse(getRequest().post(getEndPoint()));
	}

	@Then("^Verify the response messaage for multiple keyword search\"([^\"]*)\",\"([^\"]*)\"$")
	public void verify_the_response_messaage_for_multiple_keyword_search(String parameter3, String parameter4)
			throws Throwable {
		responseResult = getDataFromResponseParameter(getResponse(), parameter3, version);
		verificationValue = Configuration.readApplicationData("multipleKeywordSearchContactName", "Config");
		
		verifyResposeParameter(responseResult, verificationValue.toString());
		responseResult = getDataFromResponseParameter(getResponse(), parameter4, version);
		verificationValue = Configuration.readApplicationData("multipleKeywordSearchOutletName", "Config");
		
		verifyResposeParameter(responseResult, verificationValue.toString());
	}
	
	@Then("^Verify the response message for multiple keyword search\"([^\"]*)\",\"([^\"]*)\"$")
	public void verify_the_response_message_for_multiple_keyword_search(String parameter3, String version) throws Throwable {
		responseResult = getDataFromResponseParameter(getResponse(), parameter3, version);
		verificationValue = Configuration.readApplicationData("multipleKeywordSearchContactNamev4", "Config");
		
		verifyResposeParameter(responseResult, verificationValue.toString());
	}
	
	@Then("^Verify the Sort by ASC\"([^\"]*)\"$")
	public void verify_the_Sort_by_ASC(String contactName) throws Throwable {
		Utilities.sortByASC(getResponse(), contactName);
	}

	
	@Then("^Verify the Sort by DSC\"([^\"]*)\"$")
	public void verify_the_Sort_by_DSC(String contactName) throws Throwable {
		Utilities.sortByDESC(getResponse(), contactName);
	}

}
