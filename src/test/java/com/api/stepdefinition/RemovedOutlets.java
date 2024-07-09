package com.api.stepdefinition;

import static com.api.utils.GlobalConstant.FileName.RemovedContacts;
import static com.api.utils.GlobalConstant.FileName.RemovedOutlets;

import org.json.simple.JSONObject;

import com.api.utils.CommanSteps;
import com.api.utils.GlobalConstant;
import com.api.utils.JsonFilesUtil;
import com.api.utils.Utilities;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.specification.RequestSpecification;

public class RemovedOutlets extends Utilities
{
	public static String inputJsonPath;
	public static String outputJsonPath;
	JSONObject updatedJSON;
	RequestSpecification req = CommanSteps.getRequest();
	@When("^Search with removedOutlet API without change in parameter \"([^\"]*)\"$")
	public void search_with_removedOutlet_API_without_change_in_parameter(String Version) throws Throwable {
		if (Version.contains("v3")) {
			
			inputJsonPath = GlobalConstant.outletInputV3;
			outputJsonPath = GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.removedOutlets3);                        //removed outlet version 3
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath = GlobalConstant.outletInputV2point1;
			outputJsonPath = GlobalConstant.contactOutputV3;
			setEndPoint(GlobalConstant.removedOutlets2point1);                 //removed outlet version 2.1
		} else if (Version.contains("v2")) {
			inputJsonPath = GlobalConstant.outletInputV2;
			outputJsonPath = GlobalConstant.contactOutputV3;
			if (Version.equalsIgnoreCase("v2Depricated")) {
				
				setEndPoint(GlobalConstant.removedOutlets2Depricated);         //removed outlet version 2 depricated
			} else {
				
				setEndPoint(GlobalConstant.removedOutlets2);                   //removed outlet version 2
			}
			
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, RemovedOutlets.toString(), true));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}

	@Then("^Verify the status code for removed outlet response$")
	public void verify_the_status_code_for_removed_outlet_response() throws Throwable {
		setClassName(this.getClass().getName());
		CommanSteps.verifyResponse(getResponse(), GlobalConstant.HTTP_OK, "");
	}
	
	@When("^Search with removedOutlets API with seven days limit \"([^\"]*)\"$")
	public void search_with_removedOutlets_API_with_seven_days_limit(String arg1) throws Throwable {
		inputJsonPath = GlobalConstant.outletInputV4;
		setEndPoint(GlobalConstant.removedOutlets4);
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, RemovedOutlets.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonwithmultipleValue(getPoiJSONObject(), "dateRange", Utilities.pastSevenDays(), Utilities.CurrentDate()));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}

}
