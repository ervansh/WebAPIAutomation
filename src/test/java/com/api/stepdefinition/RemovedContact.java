package com.api.stepdefinition;

import static com.api.utils.GlobalConstant.FileName.RemovedContacts;

import org.json.simple.JSONObject;

import com.api.utils.CommanSteps;
import com.api.utils.GlobalConstant;
import com.api.utils.JsonFilesUtil;
import com.api.utils.Utilities;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.specification.RequestSpecification;

public class RemovedContact extends Utilities {
	public static String inputJsonPath;
	public static String outputJsonPath;
	JSONObject updatedJSON;
	RequestSpecification req = CommanSteps.getRequest();

	@When("^Search with removedContact API without change in parameter \"([^\"]*)\"$")
	public void search_with_removedContact_API_without_change_in_parameter(String Version) throws Throwable {
		if (Version.contains("v3")) {
			
			inputJsonPath = GlobalConstant.contactInputV3;
			outputJsonPath = GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.removedContacts3);                       //removed contact Version 3
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath = GlobalConstant.contactInputV2point1;
			outputJsonPath = GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.removedContacts2point1);                 //removed contact Version2.1
		} else if (Version.contains("v2")) {
			inputJsonPath = GlobalConstant.contactInputV2;
			outputJsonPath = GlobalConstant.contactOutputV3;
			if (Version.equalsIgnoreCase("v2Depricated")) {
				
				setEndPoint(GlobalConstant.removedContacts2Depricated);          //removed contact depricated version 2
			} else {
				
				setEndPoint(GlobalConstant.removedContacts2);                   //removed contact version 2
			}
			
		}
		
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, RemovedContacts.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "removedSince", Utilities.CurrentDate()));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}

	@Then("^Verify the status code for removed contact response$")
	public void verify_the_status_code_for_removed_contact_response() throws Throwable {
		setClassName(this.getClass().getName());
		CommanSteps.verifyResponse(getResponse(), GlobalConstant.HTTP_OK, "");
	}

	
	/*
	 * 
	 * Version 4 Test cases
	 * 
	 */
	
	@When("^Search with removedContact API with seven days limit \"([^\"]*)\"$")
	public void search_with_removedContact_API_with_seven_days_limit(String arg1) throws Throwable {
		inputJsonPath = GlobalConstant.contactInputV4;
		outputJsonPath = GlobalConstant.contactOutputV4;
		setEndPoint(GlobalConstant.removedContacts4);
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, RemovedContacts.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonwithmultipleValue(getPoiJSONObject(), "dateRange", Utilities.pastSevenDays(), Utilities.CurrentDate()));
		/*setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "until", Utilities.CurrentDate()));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "since", Utilities.pastSevenDays()));*/
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}
}
