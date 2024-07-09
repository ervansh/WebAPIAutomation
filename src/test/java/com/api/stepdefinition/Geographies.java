package com.api.stepdefinition;

import org.json.simple.JSONObject;
import static com.api.utils.GlobalConstant.FileName.geographySearch;
import static com.api.utils.GlobalConstant.FileName.geographyLookup;
import com.api.utils.CommanSteps;
import com.api.utils.GlobalConstant;

import com.api.utils.JsonFilesUtil;
import com.api.utils.Utilities;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class Geographies extends Utilities{
	JSONObject updatedJSON;
	RequestSpecification req = CommanSteps.getRequest();
	public static String inputJsonPath;
	public static String outputJsonPath;
	public static String version;
	public static Object responseResult;
	
	@When("^List of geography exists with the name \"([^\"]*)\",\"([^\"]*)\" and continent type \"([^\"]*)\",\"([^\"]*)\" in \"([^\"]*)\"$")
	public void list_of_geography_exists_with_the_name_and_continent_type_in(String param1, String value1, String param2, String value2, String version) throws Throwable {
		if(param1.equalsIgnoreCase("q")) {
		inputJsonPath=GlobalConstant.geographysearchV4;
		outputJsonPath=GlobalConstant.contactOutputV4;
		setEndPoint(GlobalConstant.geographysearch4);
		
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, geographySearch.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueWithEqualsCondition(getPoiJSONObject(), param1, value1));
		setPoiJSONObject(JsonFilesUtil.updateJsonValueWithEqualsCondition(getPoiJSONObject(), param2, value2));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		}else
		{
			inputJsonPath=GlobalConstant.geographysearchV4;
			outputJsonPath=GlobalConstant.contactOutputV4;
			setEndPoint(GlobalConstant.geographyLookup4);
			setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, geographyLookup.toString(), true));
			setPoiJSONObject(JsonFilesUtil.updateJsonwithmultipleValue(getPoiJSONObject(), "geographies", value1, value2));
			getRequest().body(getPoiJSONObject().toString());
			setResponse(getRequest().post(getEndPoint()));
		}
	}
	
	@Then("^Verify the response contains \"([^\"]*)\" as \"([^\"]*)\"$")
	public void verify_the_response_contains_as(String paramValue1, String continentType) throws Throwable {
		
		if(continentType.equalsIgnoreCase("CONTINENT"))
		{
			responseResult = getOutletDataFromResponseParameter(getResponse(), "continent", "v4");
			verifyResposeParameter(responseResult, paramValue1);
			
			responseResult = getOutletDataFromResponseParameter(getResponse(), "continent", "v4");
			verifyResposeParameter(responseResult, continentType);
		}
		else if(continentType.equalsIgnoreCase("COUNTRY"))
		{
			responseResult = getOutletDataFromResponseParameter(getResponse(), "country", "v4");
			verifyResposeParameter(responseResult, paramValue1);
			
			responseResult = getOutletDataFromResponseParameter(getResponse(), "country", "v4");
			verifyResposeParameter(responseResult, continentType);
			
		}else if(continentType.equalsIgnoreCase("CITY"))
		{
			responseResult = getOutletDataFromResponseParameter(getResponse(), "city", "v4");
			verifyResposeParameter(responseResult, paramValue1);
			
			responseResult = getOutletDataFromResponseParameter(getResponse(), "city", "v4");
			verifyResposeParameter(responseResult, continentType);
		}
	    
	}

}
