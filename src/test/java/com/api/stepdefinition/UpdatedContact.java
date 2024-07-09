package com.api.stepdefinition;

import static com.api.utils.GlobalConstant.FileName.UpdatedContacts;

import org.json.simple.JSONObject;

import com.api.utils.CommanSteps;
import com.api.utils.GlobalConstant;
import com.api.utils.JsonFilesUtil;
import com.api.utils.Utilities;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.specification.RequestSpecification;

public class UpdatedContact extends Utilities {
	public static String inputJsonPath;
	public static String outputJsonPath;
	JSONObject updatedJSON;
	RequestSpecification req = CommanSteps.getRequest();

	@When("^Search with updatedContact API without change in parameter \"([^\"]*)\"$")
	public void search_with_updatedContact_API_without_change_in_parameter(String Version) throws Throwable {
		if (Version.contains("v3")) {
			
			inputJsonPath = GlobalConstant.contactInputV3;
			setEndPoint(GlobalConstant.updatedOutlets3);
		} else if (Version.contains("v2.1")) {
			
			inputJsonPath = GlobalConstant.contactInputV2point1;
			setEndPoint(GlobalConstant.updatedOutlets2point1);
		} else if (Version.contains("v2")) {
			inputJsonPath = GlobalConstant.contactInputV2;
			if (Version.equalsIgnoreCase("v2Depricated")){
				
				setEndPoint(GlobalConstant.updatedOutlets2Depricated);
			} else {
				
			setEndPoint(GlobalConstant.updatedOutlets2);
			}
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, UpdatedContacts.toString(), true));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}

	@Then("^Verify the status code for updated contact response$")
	public void verify_the_status_code_for_updated_contact_response() throws Throwable {
		setClassName(this.getClass().getName());
		CommanSteps.verifyResponse(getResponse(), GlobalConstant.HTTP_OK, "");
	}

}
