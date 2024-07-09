package com.api.stepdefinition;

import java.util.ArrayList;

import org.junit.Assert;

import com.api.utils.AllLookUps;
import com.api.utils.CommanSteps;
import com.api.utils.Configuration;
import com.api.utils.GlobalConstant;
import com.api.utils.Utilities;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

/**
 * 
 * @author Rishabh Srivastava and Sonali Sinha In this method we have mentioned
 *         all the step definiton related to Lookups
 *
 */
public class LookUps extends AllLookUps {
	/**
	 * We get the request from the Login Step definition.
	 */
	public static Object responseResult;
	public static Object responseData;
	public static Response responseDataWithQueryParameter;

	@When("^Call looksups API \"([^\"]*)\"$")
	public Object call_looksups_API(String endPointURL) throws Throwable {
		responseData = LookupID(endPointURL, Utilities.getRequest(), null, "id", 1);
		
		Thread.sleep(2000);
		return responseData;
	}

	@Then("^Verify the response \"([^\"]*)\"$")
	public void verify_the_response(String Lookup) throws Throwable {
		String responseResult = AllLookUps.getResponse().getBody().asString();
		Lookup = Lookup.replace("/", "");
		String data = Configuration.readTestDataFile(Lookup);
		Assert.assertEquals(responseResult.trim(), data.trim());
	}

	@Then("^Verify the status code$")
	public void verify_the_status_code() throws Throwable {
		setClassName(this.getClass().getName());
		CommanSteps.verifyResponse(getResponse(), GlobalConstant.HTTP_OK, "");
	}

	@Then("^verify the LookUps response \"([^\"]*)\"$")
	public void verify_the_LookUps_response(String Lookup) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String responseResult = AllLookUps.getResponse().getBody().asString();
		//Lookup = Lookup.replace("/", "");
		String data = Configuration.readLookupDataFile(Lookup);
		Assert.assertEquals(responseResult.trim(), data.trim());
	}
	
	@When("^Call looksups API with query parameter \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void call_looksups_API_with_query_parameter(String endPointURL, String parameter1, String Value1,
			String parameter2, String Value2) throws Throwable {
		waitForAPItoResponse(3);
			responseDataWithQueryParameter = LookupIDWITHQUERYPARAMETER(endPointURL, Utilities.getRequest(), null, "id", 1,
					parameter1, Value1, parameter2, Value2);
		
		ArrayList<String> list;
		if (endPointURL.contains("geographyLookup")) {
			list = getResponse().path("GeographyList.name");
		} else {
			list = responseDataWithQueryParameter.path("results.name");
			
			int flag = 0;
			for (String value : list) {
				
				if (value.toLowerCase().trim().contains(Value1.toLowerCase().trim())) {
					
				} else {
					
				}
				flag++;
				Assert.assertTrue(value.toLowerCase().trim().contains(Value1.toLowerCase().trim()));
			}
			waitForAPItoResponse(2);
		}
	}

	@When("^Call looksups API with query parameter \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void call_looksups_API_with_query_parameter(String endPointURL, String parameter1, String Value1) throws Throwable {
		waitForAPItoResponse(3);
		responseData = GETLookupsValue(endPointURL, Utilities.getRequest(), null,Value1,parameter1 );
	}

	
	@Then("^Verify the lookup \"([^\"]*)\" response \"([^\"]*)\"$")
	public void verify_the_lookup_response(String lookup, String value) throws Throwable {
		responseVerification(getResponse(), "name", value);
		/*responseResult = getDataFromResponseParameter(getResponse(), "name", "v4");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" +responseResult);
		Assert.assertTrue(responseResult.toString().contains(value));*/
	}
	
	@When("^Call looksups API with query parameter for subject \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void call_looksups_API_with_query_parameter_for_subject(String endPointURL, String parameter1, String Value1,
			String parameter2, String Value2) throws Throwable {
		waitForAPItoResponse(3);
		String language = Configuration.readConfigFile("Language");
		switch (language) {
		case "English (US)":
			responseDataWithQueryParameter = LookupIDWITHQUERYPARAMETER(endPointURL, Utilities.getRequest(), null, "id", 1,
					parameter1, Value1, parameter2, Value2);
			break;
		case "Dutch":
			Value1="Brandstoffen, energie en natuurlijke rijkdommen";
			responseDataWithQueryParameter = LookupIDWITHQUERYPARAMETER(endPointURL, Utilities.getRequest(), null, "id", 1,
					parameter1, Value1, parameter2, Value2);
			break;
		case "French":
			Value1="Combustibles, énergie et ressources naturelles";
			responseDataWithQueryParameter = LookupIDWITHQUERYPARAMETER(endPointURL, Utilities.getRequest(), null, "id", 1,
					parameter1, Value1 , parameter2, Value2);
			break;
		}
		
		ArrayList<String> list;
		if (endPointURL.contains("geographyLookup")) {
			list = getResponse().path("GeographyList.name");
		} else {
			list = responseDataWithQueryParameter.path("results.name");
			
			int flag = 0;
			for (String value : list) {
				
				if (value.toLowerCase().trim().contains(Value1.toLowerCase().trim())) {
					
				} else {
					
				}
				flag++;
				Assert.assertTrue(value.toLowerCase().trim().contains(Value1.toLowerCase().trim()));
			}
			waitForAPItoResponse(2);
		}
	}
	
	@When("^Call looksups API with query parameter for related subject \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void call_looksups_API_with_query_parameter_for_related_subject(String endPointURL, String parameter1, String Value1,
			String parameter2, String Value2) throws Throwable {
		waitForAPItoResponse(3);
		String language = Configuration.readConfigFile("Language");
		switch (language) {
		case "English (US)":
			responseDataWithQueryParameter = LookupIDWITHQUERYPARAMETER(endPointURL, Utilities.getRequest(), null, "id", 1,
					parameter1, Value1, parameter2, Value2);
			break;
		case "Dutch":
			Value1="Uitzendingen en audiovisueel";
			responseDataWithQueryParameter = LookupIDWITHQUERYPARAMETER(endPointURL, Utilities.getRequest(), null, "id", 1,
					parameter1, Value1, parameter2, Value2);
			break;
		case "French":
			Value1="Emissions et audiovisuel";
			responseDataWithQueryParameter = LookupIDWITHQUERYPARAMETER(endPointURL, Utilities.getRequest(), null, "id", 1,
					parameter1, Value1 , parameter2, Value2);
			break;
		}
		
		ArrayList<String> list;
		if (endPointURL.contains("geographyLookup")) {
			list = getResponse().path("GeographyList.name");
		} else {
			list = responseDataWithQueryParameter.path("results.name");
			
			int flag = 0;
			for (String value : list) {
				
				if (value.toLowerCase().trim().contains(Value1.toLowerCase().trim())) {
					
				} else {
					
				}
				flag++;
				Assert.assertTrue(value.toLowerCase().trim().contains(Value1.toLowerCase().trim()));
			}
			waitForAPItoResponse(2);
		}
	}
	
	@When("^Call looksups API with query parameter for outlet type \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void call_looksups_API_with_query_parameter_for_outlet_type(String endPointURL, String parameter1, String Value1,
			String parameter2, String Value2) throws Throwable {
		waitForAPItoResponse(3);
		String language = Configuration.readConfigFile("Language");
		switch (language) {
		case "English (US)":
			responseDataWithQueryParameter = LookupIDWITHQUERYPARAMETER(endPointURL, Utilities.getRequest(), null, "id", 1,
					parameter1, Value1, parameter2, Value2);
			break;
		case "Dutch":
			Value1="Mediabedrijf";
			responseDataWithQueryParameter = LookupIDWITHQUERYPARAMETER(endPointURL, Utilities.getRequest(), null, "id", 1,
					parameter1, Value1, parameter2, Value2);
			break;
		case "French":
			Value1="Organisation médiatique";
			responseDataWithQueryParameter = LookupIDWITHQUERYPARAMETER(endPointURL, Utilities.getRequest(), null, "id", 1,
					parameter1, Value1 , parameter2, Value2);
			break;
		}
		
		ArrayList<String> list;
		if (endPointURL.contains("geographyLookup")) {
			list = getResponse().path("GeographyList.name");
		} else {
			list = responseDataWithQueryParameter.path("results.name");
			
			int flag = 0;
			for (String value : list) {
				
				if (value.toLowerCase().trim().contains(Value1.toLowerCase().trim())) {
					
				} else {
					
				}
				flag++;
				Assert.assertTrue(value.toLowerCase().trim().contains(Value1.toLowerCase().trim()));
			}
			waitForAPItoResponse(2);
		}
	}
	
	
	@When("^Call looksups API with query parameter for language\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void call_looksups_API_with_query_parameter_for_language(String endPointURL, String parameter1, String Value1,
			String parameter2, String Value2) throws Throwable {
		waitForAPItoResponse(3);
		String language = Configuration.readConfigFile("Language");
		switch (language) {
		case "English (US)":
			responseDataWithQueryParameter = LookupIDWITHQUERYPARAMETER(endPointURL, Utilities.getRequest(), null, "id", 1,
					parameter1, Value1, parameter2, Value2);
			break;
		case "Dutch":
			Value1="Armeens";
			responseDataWithQueryParameter = LookupIDWITHQUERYPARAMETER(endPointURL, Utilities.getRequest(), null, "id", 1,
					parameter1, Value1, parameter2, Value2);
			break;
		case "French":
			Value1="Arménien";
			responseDataWithQueryParameter = LookupIDWITHQUERYPARAMETER(endPointURL, Utilities.getRequest(), null, "id", 1,
					parameter1, Value1 , parameter2, Value2);
			break;
		}
		
		ArrayList<String> list;
		if (endPointURL.contains("geographyLookup")) {
			list = getResponse().path("GeographyList.name");
		} else {
			list = responseDataWithQueryParameter.path("results.name");
			
			int flag = 0;
			for (String value : list) {
				
				if (value.toLowerCase().trim().contains(Value1.toLowerCase().trim())) {
					
				} else {
					
				}
				flag++;
				Assert.assertTrue(value.toLowerCase().trim().contains(Value1.toLowerCase().trim()));
			}
			waitForAPItoResponse(2);
		}
	}
	
	@When("^Call looksups API with query parameter for frequency \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void call_looksups_API_with_query_parameter_for_frequency(String endPointURL, String parameter1, String Value1,
			String parameter2, String Value2) throws Throwable {
		waitForAPItoResponse(3);
		String language = Configuration.readConfigFile("Language");
		switch (language) {
		case "English (US)":
			responseDataWithQueryParameter = LookupIDWITHQUERYPARAMETER(endPointURL, Utilities.getRequest(), null, "id", 1,
					parameter1, Value1, parameter2, Value2);
			break;
		case "Dutch":
			Value1="Jaarlijks";
			responseDataWithQueryParameter = LookupIDWITHQUERYPARAMETER(endPointURL, Utilities.getRequest(), null, "id", 1,
					parameter1, Value1, parameter2, Value2);
			break;
		case "French":
			Value1="Annuel";
			responseDataWithQueryParameter = LookupIDWITHQUERYPARAMETER(endPointURL, Utilities.getRequest(), null, "id", 1,
					parameter1, Value1 , parameter2, Value2);
			break;
		}
		
		ArrayList<String> list;
		if (endPointURL.contains("geographyLookup")) {
			list = getResponse().path("GeographyList.name");
		} else {
			list = responseDataWithQueryParameter.path("results.name");
			
			int flag = 0;
			for (String value : list) {
				
				if (value.toLowerCase().trim().contains(Value1.toLowerCase().trim())) {
					
				} else {
					
				}
				flag++;
				Assert.assertTrue(value.toLowerCase().trim().contains(Value1.toLowerCase().trim()));
			}
			waitForAPItoResponse(2);
		}
	}
}