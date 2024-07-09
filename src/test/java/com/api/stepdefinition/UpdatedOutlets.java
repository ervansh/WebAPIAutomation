package com.api.stepdefinition;

import static com.api.utils.GlobalConstant.FileName.UpdatedOutlets;

import org.json.simple.JSONObject;

import com.api.utils.CommanSteps;
import com.api.utils.GlobalConstant;
import com.api.utils.JsonFilesUtil;
import com.api.utils.Utilities;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.specification.RequestSpecification;

public class UpdatedOutlets extends Utilities
{
	public static String inputJsonPath;
	public static String outputJsonPath;
	JSONObject updatedJSON;
	RequestSpecification req = CommanSteps.getRequest();
	
	@When("^Search with updatedOutlets API without change in parameter \"([^\"]*)\"$")
	public void search_with_updatedOutlets_API_without_change_in_parameter(String Version) throws Throwable {
		if (Version.contains("v3")) {
			
			inputJsonPath = GlobalConstant.outletInputV3;
			setEndPoint(GlobalConstant.updatedOutlets3);                    //updated Outlet Version 3
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath = GlobalConstant.outletInputV2point1;
			setEndPoint(GlobalConstant.updatedOutlets2point1);             //updated Outlet Version 2.1
		} else if (Version.contains("v2"))
		{
			if (Version.equalsIgnoreCase("v2Depricated")){
				
				setEndPoint(GlobalConstant.updatedOutlets2Depricated);      //updated Outlet Version 2 Depricated
			} else {
				
			setEndPoint(GlobalConstant.updatedOutlets2);                    //updated Outlet Version 2
			}
			inputJsonPath = GlobalConstant.outletInputV2;
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, UpdatedOutlets.toString(), true));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}

	@Then("^Verify the status code for updated outlet response$")
	public void verify_the_status_code_for_updated_outlet_response() throws Throwable {
		setClassName(this.getClass().getName());
		CommanSteps.verifyResponse(getResponse(), GlobalConstant.HTTP_OK, "");
	}

}
