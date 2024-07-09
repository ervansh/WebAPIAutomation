/**
 * 
 * @author Sonali Sinha In this Class All the Account management methods
 * 
 */
package com.api.stepdefinition;

import static com.api.utils.GlobalConstant.FileName.AccountViews;
import static com.api.utils.GlobalConstant.FileName.ActivateUser;
import static com.api.utils.GlobalConstant.FileName.CreateAccount;
import static com.api.utils.GlobalConstant.FileName.CreateUser;
import static com.api.utils.GlobalConstant.FileName.DeactivateUser;
import static com.api.utils.GlobalConstant.FileName.SwapUser;
import static com.api.utils.GlobalConstant.FileName.UpdateAccount;
import static com.api.utils.GlobalConstant.FileName.UpdateUser;
import static com.api.utils.GlobalConstant.FileName.UserViews;
import static com.api.utils.GlobalConstant.FileName.updateAccountgeography;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;

import com.api.utils.BaseTest;
import com.api.utils.CommanSteps;
import com.api.utils.Configuration;
import com.api.utils.GlobalConstant;
import com.api.utils.JsonFilesUtil;
import com.api.utils.ReadAndWritePropertiesFile;
import com.api.utils.Utilities;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AccountManagement extends Utilities {
	public static String generatedDisclaimerID;
	public static String createdAccountName;
	public static String updatedAccountName;
	public static Object actualAccountName;
	public static Object webAPIClientID;
	public static Object AccessTokenID;
	public static Object ContractStartDate;
	public static Object ContractEndDate;
	public static Object webApiAccessToken;
	public static String responseValue;
	public static String firstName;
	public static String lastName;
	public static String version;
	public static String emailID;
	public static String inputJsonPath;
	public static String outputJsonPath;
	public static Object responseResult;
	LookUps lps = new LookUps();
	Object responseData = null;
	public static Object webApiUserClientId;
	public static Object createdDate;
	public static Object actualRegionLimitation;
	public static int[] RR = { 54077, 54079, 54080, 54081, 54082, 54083, 54084 };
	public static int[] RRFalse = { 54078 };
	// Start the script

	@Then("^Call the validate Client API\"([^\"]*)\"$")
	public void call_the_validate_Client_API(String Version) throws Throwable {
		waitForAPItoResponse(2);
		if (Version.contains("v3")) {
			setEndPoint(GlobalConstant.validateClient3);
			setResponse(getRequest().post(getEndPoint()));
		} else if (Version.contains("v2.1")) {
			setEndPoint(GlobalConstant.validateClient2point1);
			setResponse(getRequest().post(getEndPoint()));
		} else if (Version.contains("v2")) {
			if (Version.equalsIgnoreCase("v2Depricated")) {
				setEndPoint(GlobalConstant.validateClient2Depricated);
				setResponse(getRequest().post(getEndPoint()));
			} else {
				setEndPoint(GlobalConstant.validateClient2);
				setResponse(getRequest().post(getEndPoint()));
			}
		} else if (Version.contains("v4")) {
			setEndPoint(GlobalConstant.validateClient4);
			setResponse(getRequest().get(getEndPoint()));
		}

	}

	@Then("^Verify the response messaage$")
	public void verify_the_response_messaage() throws Throwable {
		waitForAPItoResponse(1);
		String expectedMsg = Configuration.readMessageFile("validateResponseMsg");
		String actualMsg = getResponse().getBody().asString();
		Assert.assertTrue(actualMsg.toLowerCase().equalsIgnoreCase(expectedMsg.toLowerCase()));
	}

	@Then("^Verify the validation response messaage$")
	public void verify_the_validation_response_messaage() throws Throwable {
		waitForAPItoResponse(1);
		String expectedMsg = Configuration.readMessageFile("validateResponseMsg4");
		String actualMsg = getResponse().getBody().asString();
		Assert.assertTrue(actualMsg.toLowerCase().equalsIgnoreCase(expectedMsg.toLowerCase()));
	}

	@Then("^Verify the response status$")
	public void verify_the_response_status() throws Throwable {
		waitForAPItoResponse(2);
		setClassName(this.getClass().getName());
		CommanSteps.verifyResponse(getResponse(), GlobalConstant.HTTP_OK, "");
	}

	@Then("^Verify the deactivate user response status$")
	public void verify_the_deactivate_user_response_status() throws Throwable {
		waitForAPItoResponse(2);
		setClassName(this.getClass().getName());
		CommanSteps.verifyResponse(getResponse(), GlobalConstant.NO_CONTENT, "");
	}

	@Then("^Call the disclamier ID API\"([^\"]*)\"$")
	public void call_the_disclamier_ID_API(String Version) throws Throwable {
		waitForAPItoResponse(1);
		if (Version.contains("v3")) {
			setEndPoint(GlobalConstant.getDisclaimerID3);
			setResponse(getRequest().post(getEndPoint()));
		} else if (Version.contains("v2.1")) {
			setEndPoint(GlobalConstant.getDisclaimerID2point1);
			setResponse(getRequest().post(getEndPoint()));
		} else if (Version.contains("v4")) {
			setEndPoint(GlobalConstant.getDisclaimerID4);
			setResponse(getRequest().get(getEndPoint()));
		}

	}

	@Then("^Verify the response messaage and get disclaimer ID$")
	public void verify_the_response_messaage_and_get_disclaimer_ID() throws Throwable {
		waitForAPItoResponse(2);
		String expectedMsg = Configuration.readMessageFile("disclaimerText");
		JsonPath jsonPathEvaluator = getResponse().jsonPath();
		String responseText = jsonPathEvaluator.get("disclaimerText");
		Assert.assertTrue(responseText.toLowerCase().equalsIgnoreCase(expectedMsg.toLowerCase()));
		generatedDisclaimerID = getDisclaimerID(getResponse());
	}

	@Then("^Call the create account API\"([^\"]*)\"$")
	public void call_the_create_account_API(String Version) throws Throwable {
		waitForAPItoResponse(2);
		call_the_disclamier_ID_API(Version);
		verify_the_response_messaage_and_get_disclaimer_ID();
		if (Version.contains("v3")) {
			inputJsonPath = GlobalConstant.accountInputV3;
			setEndPoint(GlobalConstant.createAccountID3);
		} else if (Version.contains("v2.1")) {
			inputJsonPath = GlobalConstant.accountInputV2point1;
			setEndPoint(GlobalConstant.createAccountID2point1);
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, CreateAccount.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "disclaimerId", generatedDisclaimerID));
		String testString = randomString(5);
		createdAccountName = "Test Account " + testString;
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "accountName", createdAccountName));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "contractEndDate", futureDate()));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}

	@Then("^Call the create new account API\"([^\"]*)\"$")
	public void call_the_create_new_account_API(String Version) throws Throwable {
		waitForAPItoResponse(2);
		call_the_disclamier_ID_API(Version);
		verify_the_response_messaage_and_get_disclaimer_ID();
		inputJsonPath = GlobalConstant.accountInputV4;
		setEndPoint(GlobalConstant.createAccountID4);
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, CreateAccount.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "disclaimerId", generatedDisclaimerID));
		String testString = randomString(5);
		createdAccountName = "Test Account " + testString;
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "accountName", createdAccountName));
		setPoiJSONObject(
				JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "contractEndTimestamp", futureDateUnixFormat()));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}

	@Then("^Call the create account API\"([^\"]*)\" with regional restriction \"([^\"]*)\"$")
	public void call_the_create_account_API_with_regional_restriction(String Version, String regionId)
			throws Throwable {
		waitForAPItoResponse(3);
		call_the_disclamier_ID_API(Version);
		verify_the_response_messaage_and_get_disclaimer_ID();
		if (Version.contains("v3")) {

			inputJsonPath = GlobalConstant.accountInputV3;
			setEndPoint(GlobalConstant.createAccountID3);
		} else if (Version.contains("v2.1")) {

			inputJsonPath = GlobalConstant.accountInputV2point1;
			setEndPoint(GlobalConstant.createAccountID2point1);
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, CreateAccount.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "disclaimerId", generatedDisclaimerID));
		String testString = randomString(5);
		createdAccountName = "Test Account " + testString;
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "accountName", createdAccountName));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "contractEndDate", futureDate()));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "customerGeographies", regionId));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		AccessTokenID = getResponseData(getResponse(), "webApiAccessToken");
		ReadAndWritePropertiesFile.WritePropertiesFile("webApiAccessToken", AccessTokenID.toString(),
				"LoginWithRegionalRestriction");
		webAPIClientID = getResponseData(getResponse(), "webApiClientId");
		ReadAndWritePropertiesFile.WritePropertiesFile("webApiClientId", webAPIClientID.toString(),
				"LoginWithRegionalRestriction");

	}

	@Then("^Call the create new account API\"([^\"]*)\" with regional restriction \"([^\"]*)\"$")
	public void call_the_create_new_account_API_with_regional_restriction(String Version, int regionId)
			throws Throwable {
		waitForAPItoResponse(3);
		call_the_disclamier_ID_API(Version);
		verify_the_response_messaage_and_get_disclaimer_ID();
		inputJsonPath = GlobalConstant.accountInputV4;
		setEndPoint(GlobalConstant.createAccountID4);
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, CreateAccount.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "disclaimerId", generatedDisclaimerID));
		String testString = randomString(5);
		createdAccountName = "Test Account " + testString;
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "accountName", createdAccountName));
		setPoiJSONObject(
				JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "contractEndTimestamp", futureDateUnixFormat()));
		// setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(),
		// "accountGeos", regionId));
		setPoiJSONObject(JsonFilesUtil.updateJsonwithmultipleValue(getPoiJSONObject(), "geoRestrictions", regionId,
				"CONTINENT"));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		AccessTokenID = getAccountResponseData(getResponse(), "accessToken");
		ReadAndWritePropertiesFile.WritePropertiesFile("webApiAccessToken", AccessTokenID.toString(),
				"LoginWithRegionalRestriction");
		webAPIClientID = getAccountResponseData(getResponse(), "clientId");
		ReadAndWritePropertiesFile.WritePropertiesFile("webApiClientId", webAPIClientID.toString(),
				"LoginWithRegionalRestriction");

	}

	@Then("^Verify the created account Name and response data \"([^\"]*)\"$")
	public void verify_the_created_account_Name_and_response_data(String arg1) throws Throwable {
		webAPIClientID = getResponseData(getResponse(), "webApiClientId");
		actualRegionLimitation = getResponseData(getResponse(), "regionsLimitation");
		Assert.assertEquals(actualRegionLimitation.toString().trim(), Arrays.toString(RR).trim());
	}

	@Then("^Verify the created new account Name and response data \"([^\"]*)\"$")
	public void verify_the_created_new_account_Name_and_response_data(String arg1) throws Throwable {
		webAPIClientID = getAccountResponseData(getResponse(), "clientId");
		actualRegionLimitation = getResponseData(getResponse(), "geographies");
		Assert.assertTrue(actualRegionLimitation.toString().trim().contains("asia"));
	}

	@Then("^Use above create account API\"([^\"]*)\" and create user with it$")
	public void use_above_create_account_API_and_create_user_with_it(String Version) throws Throwable {
		waitForAPItoResponse(3);
		this.call_the_create_user_API_with_Regional_restriction(Version);
	}

	@Then("^Login with new credentials$")
	public void login_with_new_credentials() throws Throwable {
		waitForAPItoResponse(3);
		AccessTokenID = Configuration.readApplicationData("webApiAccessToken", "LoginWithRegionalRestriction");
		webAPIClientID = Configuration.readApplicationData("webApiClientId", "LoginWithRegionalRestriction");
		webApiUserClientId = Configuration.readApplicationData("webApiUserClientId", "LoginWithRegionalRestriction");
		setRequest(getAllHeaders("bearer " + AccessTokenID.toString().trim(), webAPIClientID.toString().trim(),
				webApiUserClientId.toString().trim(), BaseTest.getContenttype()));
	}

	@Then("^Verify the error response data$")
	public void verify_the_error_response_data() throws Throwable {
		Response errorResponse = getResponse();
		Assert.assertTrue(
				errorResponse.asString().contains("Bad Request: The following geography IDs are not within scope:"));
	}

	@Then("^Call the create account API\"([^\"]*)\" with regional restriction \"([^\"]*)\" and geographiesExcluded as false$")
	public void call_the_create_account_API_with_regional_restriction_and_geographiesExcluded_as_false(String Version,
			String regionId) throws Throwable {
		waitForAPItoResponse(2);
		call_the_disclamier_ID_API(Version);
		if (Version.contains("v3")) {

			inputJsonPath = GlobalConstant.accountInputV3;
			setEndPoint(GlobalConstant.createAccountID3);
		} else if (Version.contains("v2.1")) {

			inputJsonPath = GlobalConstant.accountInputV2point1;
			setEndPoint(GlobalConstant.createAccountID2point1);
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, CreateAccount.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "disclaimerId", generatedDisclaimerID));
		String testString = randomString(5);
		createdAccountName = "Test Account " + testString;
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "accountName", createdAccountName));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "contractEndDate", futureDate()));
		setPoiJSONObject(
				JsonFilesUtil.updateJsonValueWithEqualsCondition(getPoiJSONObject(), "customerGeographies", regionId));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "geographiesExcluded", "false"));
		getRequest().body(getPoiJSONObject().toString());
		System.out.println("response :" + getRequest().post(getEndPoint()).body().asString());
		setResponse(getRequest().post(getEndPoint()));
	}

	@Then("^Verify the created account Name and response data with \"([^\"]*)\"$")
	public void verify_the_created_account_Name_and_response_data_with(String regionId) throws Throwable {
		actualRegionLimitation = getResponseData(getResponse(), "regionsLimitation");
		Assert.assertEquals(actualRegionLimitation.toString().trim(), Arrays.toString(RRFalse).trim());
	}

	@Then("^Verify the created account Name and response data$")
	public void verify_the_created_account_Name_and_response_data() throws Throwable {
		waitForAPItoResponse(1);
		actualAccountName = getResponseData(getResponse(), "accountName");
		ReadAndWritePropertiesFile.WritePropertiesFile("accountName", actualAccountName.toString(), "CreateUser");

		webAPIClientID = getResponseData(getResponse(), "webApiClientId");
		ReadAndWritePropertiesFile.WritePropertiesFile("webApiClientId", webAPIClientID.toString(), "CreateUser");

		ContractStartDate = getResponseData(getResponse(), "contractStartDate");
		ReadAndWritePropertiesFile.WritePropertiesFile("contractStartDate", ContractStartDate.toString(), "CreateUser");

		ContractEndDate = getResponseData(getResponse(), "contractEndDate");
		ReadAndWritePropertiesFile.WritePropertiesFile("contractEndDate", ContractEndDate.toString(), "CreateUser");

		webApiAccessToken = getResponseData(getResponse(), "webApiAccessToken");
		ReadAndWritePropertiesFile.WritePropertiesFile("webApiAccessToken", webApiAccessToken.toString(), "CreateUser");

		Assert.assertTrue(((String) actualAccountName).trim().equalsIgnoreCase(createdAccountName.trim()));
	}

	@Then("^Verify the created account Name and all response data$")
	public void verify_the_created_account_Name_and_all_response_data() throws Throwable {
		waitForAPItoResponse(1);
		actualAccountName = getAccountResponseData(getResponse(), "accountName");
		ReadAndWritePropertiesFile.WritePropertiesFile("accountName", actualAccountName.toString(), "CreateUser");

		webAPIClientID = getAccountResponseData(getResponse(), "clientId");
		ReadAndWritePropertiesFile.WritePropertiesFile("webApiClientId", webAPIClientID.toString(), "CreateUser");

		ContractStartDate = getAccountResponseData(getResponse(), "contractStartTimestamp");
		ReadAndWritePropertiesFile.WritePropertiesFile("contractStartDate", ContractStartDate.toString(), "CreateUser");

		ContractEndDate = getAccountResponseData(getResponse(), "contractEndTimestamp");
		ReadAndWritePropertiesFile.WritePropertiesFile("contractEndDate", ContractEndDate.toString(), "CreateUser");

		webApiAccessToken = getAccountResponseData(getResponse(), "accessToken");
		ReadAndWritePropertiesFile.WritePropertiesFile("webApiAccessToken", webApiAccessToken.toString(), "CreateUser");

		Assert.assertTrue(((String) actualAccountName).trim().equalsIgnoreCase(createdAccountName.trim()));
	}

	@Then("^Call the update account API\"([^\"]*)\"$")
	public void call_the_update_account_API(String Version) throws Throwable {
		waitForAPItoResponse(1);
		call_the_disclamier_ID_API(Version);
		waitForAPItoResponse(1);
		verify_the_response_messaage_and_get_disclaimer_ID();
		waitForAPItoResponse(1);
		call_the_create_account_API(Version);
		verify_the_created_account_Name_and_response_data();
		if (Version.contains("v3")) {

			inputJsonPath = GlobalConstant.accountInputV3;
			setEndPoint(GlobalConstant.updateAccountID3);
		} else if (Version.contains("v2.1")) {

			inputJsonPath = GlobalConstant.accountInputV2point1;
			setEndPoint(GlobalConstant.updateAccountID2point1);
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, UpdateAccount.toString(), true));
		String testString = randomString(5);
		updatedAccountName = "Test Account " + testString;
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "accountName", updatedAccountName));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "webApiClientId", webAPIClientID));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
	}

	@Then("^Verify the updated account Name and response data$")
	public void verify_the_updated_account_Name_and_response_data() throws Throwable {
		waitForAPItoResponse(2);
		Object actualAccountName = getResponseData(getResponse(), "accountName");
		Assert.assertTrue(((String) actualAccountName).trim().equalsIgnoreCase(updatedAccountName.trim()));
	}

	@Then("^Call the create user API\"([^\"]*)\"$")
	public Response call_the_create_user_API(String Version) throws Throwable {
		waitForAPItoResponse(2);
		version = Version;
		call_the_disclamier_ID_API(Version);
		verify_the_response_messaage_and_get_disclaimer_ID();
		call_the_create_account_API(Version);
		verify_the_created_account_Name_and_response_data();
		call_the_disclamier_ID_API(Version);
		verify_the_response_messaage_and_get_disclaimer_ID();
		if (Version.contains("v3")) {
			inputJsonPath = GlobalConstant.accountInputV3;
			setEndPoint(GlobalConstant.createUserID3);
			responseData = lps.call_looksups_API(GlobalConstant.subjectsLookup3);
		} else if (Version.contains("v2.1")) {
			inputJsonPath = GlobalConstant.accountInputV2point1;
			setEndPoint(GlobalConstant.createUserID2point1);
			responseData = lps.call_looksups_API(GlobalConstant.subjectsLookup3);
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, CreateUser.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "disclaimerId", generatedDisclaimerID));
		String testString = randomString(5);
		firstName = "Test Account First name" + testString;
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "firstName", firstName));
		testString = randomString(5);
		lastName = "Test Account Last name" + testString;
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "lastName", lastName));
		testString = randomString(5);
		emailID = "Test@" + testString + ".com";
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "email", emailID));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "preferredLanguageId", "28"));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "webApiClientId", webAPIClientID));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		webApiUserClientId = getCreatedUserFromResponse(getResponse(), "webApiUserClientId", version);
		ReadAndWritePropertiesFile.WritePropertiesFile("webApiUserClientId", webApiUserClientId.toString(),
				"CreateUser");
		createdDate = getCreatedUserFromResponse(getResponse(), "createdDate", version);
		return getResponse();
	}

	@Then("^Call the create new user API\"([^\"]*)\"$")
	public Response call_the_create_new_user_API(String Version) throws Throwable {
		waitForAPItoResponse(2);
		version = Version;
		call_the_disclamier_ID_API(Version);
		verify_the_response_messaage_and_get_disclaimer_ID();
		call_the_create_new_account_API(Version);
		verify_the_created_account_Name_and_all_response_data();
		call_the_disclamier_ID_API(Version);
		verify_the_response_messaage_and_get_disclaimer_ID();
		inputJsonPath = GlobalConstant.accountInputV4;
		setEndPoint(GlobalConstant.createUserID4);
		// responseData = lps.call_looksups_API(GlobalConstant.subjectsLookup3);
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, CreateUser.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "disclaimerId", generatedDisclaimerID));
		String testString = randomString(5);
		firstName = "Test Account First name" + testString;
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "firstName", firstName));
		testString = randomString(5);
		lastName = "Test Account Last name" + testString;
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "lastName", lastName));
		testString = randomString(5);
		emailID = "Test@" + testString + ".com";
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "email", emailID));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "languageCode", "en"));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "clientId", webAPIClientID));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		webApiUserClientId = getCreatedUserFromResponseV4(getResponse(), "userClientId", version);
		ReadAndWritePropertiesFile.WritePropertiesFile("webApiUserClientId", webApiUserClientId.toString(),
				"CreateUser");
		createdDate = getCreatedUserFromResponseV4(getResponse(), "createdTimestamp", version);
		return getResponse();
	}

	@Then("^Call the create user API with Regional restriction\"([^\"]*)\"$")
	public Response call_the_create_user_API_with_Regional_restriction(String Version) throws Throwable {
		waitForAPItoResponse(2);
		version = Version;
		call_the_disclamier_ID_API(Version);
		verify_the_response_messaage_and_get_disclaimer_ID();
		if (Version.contains("v3")) {

			inputJsonPath = GlobalConstant.accountInputV3;
			setEndPoint(GlobalConstant.createUserID3);
			responseData = lps.call_looksups_API(GlobalConstant.subjectsLookup3);
		} else if (Version.contains("v2.1")) {

			inputJsonPath = GlobalConstant.accountInputV2point1;
			setEndPoint(GlobalConstant.createUserID2point1);
			responseData = lps.call_looksups_API(GlobalConstant.subjectsLookup3);
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, CreateUser.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "disclaimerId", generatedDisclaimerID));
		String testString = randomString(5);
		firstName = "Test Account First name" + testString;
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "firstName", firstName));
		testString = randomString(5);
		lastName = "Test Account Last name" + testString;
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "lastName", lastName));
		testString = randomString(5);
		emailID = "Test@" + testString + ".com";
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "email", emailID));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "preferredLanguageId", "28"));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "webApiClientId", webAPIClientID));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));
		webApiUserClientId = getCreatedUserFromResponse(getResponse(), "webApiUserClientId", version);
		ReadAndWritePropertiesFile.WritePropertiesFile("webApiUserClientId", webApiUserClientId.toString(),
				"LoginWithRegionalRestriction");
		return getResponse();

	}

	@Then("^Verify the created user Name and response data$")
	public void verify_the_created_user_Name_and_response_data() throws Throwable {
		responseResult = getCreatedUserFromResponse(getResponse(), "userFirstName", version);
		verifyResposeParameter(responseResult, firstName);

		responseResult = getCreatedUserFromResponse(getResponse(), "userLastName", version);
		verifyResposeParameter(responseResult, lastName);

		responseResult = getCreatedUserFromResponse(getResponse(), "accountName", version);
		verifyResposeParameter(responseResult, createdAccountName);

		responseResult = getCreatedUserFromResponse(getResponse(), "webAPIClientId", version);
		verifyResposeParameter(responseResult, webAPIClientID.toString());
	}

	@Then("^Verify the created user Name and response data in version four$")
	public void verify_the_created_user_Name_and_response_data_in_version_four() throws Throwable {
		responseResult = getCreatedUserFromResponseV4(getResponse(), "firstName", version);
		verifyResposeParameter(responseResult, firstName);

		responseResult = getCreatedUserFromResponseV4(getResponse(), "lastName", version);
		verifyResposeParameter(responseResult, lastName);

		responseResult = getCreatedUserFromResponseV4(getResponse(), "accountName", version);
		verifyResposeParameter(responseResult, createdAccountName);

		responseResult = getCreatedUserFromResponseV4(getResponse(), "clientId", version);
		verifyResposeParameter(responseResult, webAPIClientID.toString());
	}

	@Then("^Call the update user API\"([^\"]*)\"$")
	public void call_the_update_user_API(String Version) throws Throwable {
		waitForAPItoResponse(1);
		call_the_create_user_API(Version);
		call_the_disclamier_ID_API(Version);

		if (Version.contains("v3")) {

			inputJsonPath = GlobalConstant.accountInputV3;
			setEndPoint(GlobalConstant.updateUserID3);
			responseData = lps.call_looksups_API(GlobalConstant.subjectsLookup3);
		} else if (Version.contains("v2.1")) {

			inputJsonPath = GlobalConstant.accountInputV2point1;
			setEndPoint(GlobalConstant.updateUserID2point1);
			responseData = lps.call_looksups_API(GlobalConstant.subjectsLookup3);
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, UpdateUser.toString(), true));
		setPoiJSONObject(
				JsonFilesUtil.updateAccountJsonValue(getPoiJSONObject(), "disclaimerId", generatedDisclaimerID));
		String testString = randomString(5);
		firstName = "Updated First name" + testString;
		setPoiJSONObject(JsonFilesUtil.updateAccountJsonValue(getPoiJSONObject(), "firstName", firstName));
		testString = randomString(5);
		lastName = "Updated Last name" + testString;
		setPoiJSONObject(JsonFilesUtil.updateAccountJsonValue(getPoiJSONObject(), "lastName", lastName));
		testString = randomString(5);
		emailID = "UpdatedTest@" + testString + ".com";
		setPoiJSONObject(JsonFilesUtil.updateAccountJsonValue(getPoiJSONObject(), "email", emailID));
		setPoiJSONObject(JsonFilesUtil.updateAccountJsonValue(getPoiJSONObject(), "webApiClientId", webAPIClientID));
		setPoiJSONObject(JsonFilesUtil.updateAccountJsonValue(getPoiJSONObject(), "webApiUserClientId",
				webApiUserClientId.toString()));
		setPoiJSONObject(JsonFilesUtil.updateAccountJsonValue(getPoiJSONObject(), "preferredLanguageId", "28"));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));

	}

	@Then("^Call the update user API in version \"([^\"]*)\"$")
	public void call_the_update_user_API_in_version(String Version) throws Throwable {
		waitForAPItoResponse(1);
		inputJsonPath = GlobalConstant.accountInputV4;
		setEndPoint(GlobalConstant.updateUserID4 + webApiUserClientId);
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, UpdateUser.toString(), true));
		String testString = randomString(5);
		firstName = "Updated First name" + testString;
		setPoiJSONObject(JsonFilesUtil.updateAccountJsonValue(getPoiJSONObject(), "firstName", firstName));
		testString = randomString(5);
		lastName = "Updated Last name" + testString;
		setPoiJSONObject(JsonFilesUtil.updateAccountJsonValue(getPoiJSONObject(), "lastName", lastName));
		// testString = randomString(5);
		// emailID = "UpdatedTest@" + testString + ".com";
		// setPoiJSONObject(JsonFilesUtil.updateAccountJsonValue(getPoiJSONObject(),
		// "email", emailID));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "languageCode", "fr"));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "clientId", webAPIClientID));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().put(getEndPoint()));
	}

	@Then("^Verify the updated user Name and response data in version \"([^\"]*)\"$")
	public void verify_the_updated_user_Name_and_response_data_in_version(String Version) throws Throwable {
		responseResult = getCreatedUserFromResponseV4(getResponse(), "firstName", version);
		verifyResposeParameter(responseResult, firstName);

		responseResult = getCreatedUserFromResponseV4(getResponse(), "lastName", version);
		verifyResposeParameter(responseResult, lastName);

		responseResult = getCreatedUserFromResponseV4(getResponse(), "accountName", version);
		verifyResposeParameter(responseResult, createdAccountName);

		responseResult = getCreatedUserFromResponseV4(getResponse(), "clientId", version);
		verifyResposeParameter(responseResult, webAPIClientID.toString());
	}

	@Then("^Verify the updated user Name and response data$")
	public void verify_the_updated_user_Name_and_response_data() throws Throwable {
		responseResult = getUpdatedUserFromResponse(getResponse(), "accountName", version);
		verifyResposeParameter(responseResult, createdAccountName);

		responseResult = getUpdatedUserFromResponse(getResponse(), "webAPIClientId", version);
		webAPIClientID = Configuration.readApplicationData("webApiClientId", "CreateUser");
		verifyResposeParameter(responseResult, webAPIClientID.toString());

		responseResult = getUpdatedUserFromResponse(getResponse(), "userFirstName", version);
		verifyResposeParameter(responseResult, firstName);

		responseResult = getUpdatedUserFromResponse(getResponse(), "userLastName", version);
		verifyResposeParameter(responseResult, lastName);

		responseResult = getUpdatedUserFromResponse(getResponse(), "userEmail", version);
		verifyResposeParameter(responseResult, emailID);

		responseResult = getUpdatedUserFromResponse(getResponse(), "webApiUserClientId", version);
		webApiUserClientId = Configuration.readApplicationData("webApiUserClientId", "CreateUser");
		verifyResposeParameter(responseResult, webApiUserClientId.toString());

		responseResult = getUpdatedUserFromResponse(getResponse(), "createdDate", version);
		verifyResposeParameter(responseResult, createdDate.toString());

		responseResult = getUpdatedUserFromResponse(getResponse(), "lastModifiedDate", version);
		verifyResposeParameter(responseResult, CurrentDate().toString());

		responseResult = getUpdatedUserFromResponse(getResponse(), "preferredLanguageId", version);
		verifyResposeParameter(responseResult, "28");
	}

	@Then("^Call the deactivate user API\"([^\"]*)\"$")
	public void call_the_deactivate_user_API(String Version) throws Throwable {
		waitForAPItoResponse(2);
		version = Version;
		if (Version.contains("v3")) {

			inputJsonPath = GlobalConstant.accountInputV3;
			setEndPoint(GlobalConstant.deactivateUserID3);
			setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, DeactivateUser.toString(), true));
			webApiUserClientId = Configuration.readApplicationData("webApiUserClientId", "CreateUser");

			setPoiJSONObject(
					JsonFilesUtil.updateAccountJsonValue(getPoiJSONObject(), "webApiUserClientId", webApiUserClientId));
			getRequest().body(getPoiJSONObject().toString());
			setResponse(getRequest().post(getEndPoint()));

		} else if (Version.contains("v2.1")) {
			inputJsonPath = GlobalConstant.accountInputV2point1;
			setEndPoint(GlobalConstant.deactivateUserID2point1);
			setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, DeactivateUser.toString(), true));
			webApiUserClientId = Configuration.readApplicationData("webApiUserClientId", "CreateUser");
			setPoiJSONObject(
					JsonFilesUtil.updateAccountJsonValue(getPoiJSONObject(), "webApiUserClientId", webApiUserClientId));
			getRequest().body(getPoiJSONObject().toString());
			setResponse(getRequest().post(getEndPoint()));
		} else if (Version.contains("v4")) {
			webApiUserClientId = Configuration.readApplicationData("webApiUserClientId", "CreateUser");
			inputJsonPath = GlobalConstant.accountInputV4;
			setEndPoint(GlobalConstant.deactivateUserID4 + "A585C22A-F923-4F87-B6F9-EC911F0EF857" + "/active");
			setResponse(getRequest().delete(getEndPoint()));
		}

	}

	@Then("^Verify the updated user status and response data$")
	public void verify_the_updated_user_status_and_response_data() throws Throwable {
		responseResult = getdeActivateddUserFromResponse(getResponse(), "previousStatus", version);
		Object previousState = Configuration.readMessageFile("beforedeactivatepreviousStatus");
		verifyResposeParameter(responseResult, previousState.toString());
		responseResult = getdeActivateddUserFromResponse(getResponse(), "newStatus", version);
		Object afterState = Configuration.readMessageFile("afterdeactivatenewStatus");
		verifyResposeParameter(responseResult, afterState.toString());
	}

	@Then("^Call the activate user API\"([^\"]*)\"$")
	public void call_the_activate_user_API(String Version) throws Throwable {
		waitForAPItoResponse(2);
		version = Version;
		if (Version.contains("v3")) {

			inputJsonPath = GlobalConstant.accountInputV3;
			setEndPoint(GlobalConstant.activateUserID3);
			setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, ActivateUser.toString(), true));
			webApiUserClientId = Configuration.readApplicationData("webApiUserClientId", "CreateUser");

			setPoiJSONObject(
					JsonFilesUtil.updateAccountJsonValue(getPoiJSONObject(), "webApiUserClientId", webApiUserClientId));
			getRequest().body(getPoiJSONObject().toString());
			setResponse(getRequest().post(getEndPoint()));
		} else if (Version.contains("v2.1")) {

			inputJsonPath = GlobalConstant.accountInputV2point1;
			setEndPoint(GlobalConstant.activateUserID2point1);
			setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, ActivateUser.toString(), true));
			webApiUserClientId = Configuration.readApplicationData("webApiUserClientId", "CreateUser");

			setPoiJSONObject(
					JsonFilesUtil.updateAccountJsonValue(getPoiJSONObject(), "webApiUserClientId", webApiUserClientId));
			getRequest().body(getPoiJSONObject().toString());
			setResponse(getRequest().post(getEndPoint()));
		} else if (Version.contains("v4")) {
			webApiUserClientId = Configuration.readApplicationData("webApiUserClientId", "CreateUser");
			inputJsonPath = GlobalConstant.accountInputV4;
			setEndPoint(GlobalConstant.deactivateUserID4 + "A585C22A-F923-4F87-B6F9-EC911F0EF857" + "/active");
			setResponse(getRequest().put(getEndPoint()));
		}

	}

	@Then("^Verify the updated user status after activate and response data$")
	public void verify_the_updated_user_status_after_activate_and_response_data() throws Throwable {
		responseResult = getdeActivateddUserFromResponse(getResponse(), "previousStatus", version);
		Object previousState = Configuration.readMessageFile("afteractivatepreviousStatus");
		verifyResposeParameter(responseResult, previousState.toString());
		responseResult = getdeActivateddUserFromResponse(getResponse(), "newStatus", version);
		Object afterState = Configuration.readMessageFile("afteractivatenewStatus");
		verifyResposeParameter(responseResult, afterState.toString());
	}

	@Then("^Call the swap user API\"([^\"]*)\"$")
	public void call_the_swap_user_API(String Version) throws Throwable {
		waitForAPItoResponse(2);
		version = Version;
		call_the_disclamier_ID_API(Version);
		verify_the_response_messaage_and_get_disclaimer_ID();
		if (Version.contains("v3")) {

			inputJsonPath = GlobalConstant.accountInputV3;
			setEndPoint(GlobalConstant.swapUserID3);
		} else if (Version.contains("v2.1")) {

			inputJsonPath = GlobalConstant.accountInputV2point1;
			setEndPoint(GlobalConstant.swapUserID2point1);
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, SwapUser.toString(), true));
		webApiUserClientId = Configuration.readApplicationData("webApiUserClientId", "CreateUser");

		setPoiJSONObject(JsonFilesUtil.updateAccountJsonValue(getPoiJSONObject(), "swappedFromWebApiUserClientID",
				webApiUserClientId));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "disclaimerId", generatedDisclaimerID));
		firstName = "Test Account First name" + randomString(5);
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "firstName", firstName));
		lastName = "Test Account Last name" + randomString(5);
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "lastName", lastName));
		emailID = "Test@" + randomString(5) + ".com";
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "email", emailID));
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "preferredLanguageId", "28"));
		webAPIClientID = Configuration.readApplicationData("webApiClientId", "CreateUser");
		setPoiJSONObject(JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "webApiClientId", webAPIClientID));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));

	}

	@Then("^Verify the swap user status after activate and response data$")
	public void verify_the_swap_user_status_after_activate_and_response_data() throws Throwable {
		responseResult = getCreatedUserFromResponse(getResponse(), "webAPIClientId", version);
		webAPIClientID = Configuration.readApplicationData("webApiClientId", "CreateUser");
		verifyResposeParameter(responseResult, webAPIClientID.toString());
		responseResult = getCreatedUserFromResponse(getResponse(), "accountName", version);
		actualAccountName = Configuration.readApplicationData("accountName", "CreateUser");
		verifyResposeParameter(responseResult, actualAccountName.toString());
		responseResult = getCreatedUserFromResponse(getResponse(), "createdDate", version);
		verifyResposeParameter(responseResult, CurrentDate());
	}

	@Then("^Call the partner reseller user API\"([^\"]*)\"$")
	public void call_the_partner_reseller_user_API(String Version) throws Throwable {
		waitForAPItoResponse(2);
		version = Version;
		if (Version.contains("v3")) {
			setEndPoint(GlobalConstant.partnerResellerUserID3);
			setResponse(getRequest().post(getEndPoint()));
		} else if (Version.contains("v2.1")) {
			setEndPoint(GlobalConstant.partnerResellerUserID2point1);
			setResponse(getRequest().post(getEndPoint()));
		} else if (Version.contains("v4")) {
			setEndPoint("/api/v4/partner-resellers/self");
			setResponse(getRequest().get(getEndPoint()));
		}

	}

	@Then("^Verify the partner reseller user status after activate and response data$")
	public void verify_the_partner_reseller_user_status_after_activate_and_response_data() throws Throwable {
		webAPIClientID = Configuration.readApplicationData("webApiClientId", "CreateUser");
		responseResult = accountListFromResponse(getResponse(), webAPIClientID.toString(), version);
		actualAccountName = Configuration.readApplicationData("accountName", "CreateUser");
		verifyResposeParameter(responseResult, actualAccountName.toString());
	}

	@Then("^Call the account Views API\"([^\"]*)\"$")
	public void call_the_account_Views_API(String Version) throws Throwable {
		waitForAPItoResponse(2);
		version = Version;
		if (Version.contains("v3")) {

			inputJsonPath = GlobalConstant.accountInputV3;
			setEndPoint(GlobalConstant.accountViewsID3);
		} else if (Version.contains("v2.1")) {

			inputJsonPath = GlobalConstant.accountInputV2point1;
			setEndPoint(GlobalConstant.accountViewsID2point1);
		}
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, AccountViews.toString(), true));
		webAPIClientID = Configuration.readApplicationData("webApiClientId", "CreateUser");
		setPoiJSONObject(
				JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "WebApiClientIDs", webAPIClientID.toString()));
		getRequest().body(getPoiJSONObject().toString());
		setResponse(getRequest().post(getEndPoint()));

	}

	@Then("^Verify the account Views status after activate and response data$")
	public void verify_the_account_Views_status_after_activate_and_response_data() throws Throwable {
		responseResult = getCreatedAccountsFromResponse(getResponse(), "AccountName", version);
		actualAccountName = Configuration.readApplicationData("accountName", "CreateUser");
		verifyResposeParameter(responseResult, actualAccountName.toString());

		responseResult = getCreatedAccountsFromResponse(getResponse(), "ContractStartDate", version);
		ContractStartDate = Configuration.readApplicationData("contractStartDate", "CreateUser");
		verifyResposeParameter(responseResult, ContractStartDate.toString());

		responseResult = getCreatedAccountsFromResponse(getResponse(), "ContractEndDate", version);
		ContractEndDate = Configuration.readApplicationData("contractEndDate", "CreateUser");
		verifyResposeParameter(responseResult, ContractEndDate.toString());

		responseResult = getCreatedAccountsFromResponse(getResponse(), "WebApiClientID", version);
		webAPIClientID = Configuration.readApplicationData("webApiClientId", "CreateUser");
		verifyResposeParameter(responseResult, webAPIClientID.toString());

		responseResult = getCreatedAccountsFromResponse(getResponse(), "AccessToken", version);
		webApiAccessToken = Configuration.readApplicationData("webApiAccessToken", "CreateUser");
		verifyResposeParameter(responseResult, webApiAccessToken.toString());
	}

	@Then("^Call the user Views API\"([^\"]*)\"$")
	public void call_the_user_Views_API(String Version) throws Throwable {
		waitForAPItoResponse(2);
		version = Version;
		if (Version.contains("v3")) {

			inputJsonPath = GlobalConstant.accountInputV3;
			setEndPoint(GlobalConstant.userViewsID3);
			setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, UserViews.toString(), true));
			webApiUserClientId = Configuration.readApplicationData("webApiUserClientId", "CreateUser");
			setPoiJSONObject(
					JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "WebApiUserClientIDs", webApiUserClientId));
			getRequest().body(getPoiJSONObject().toString());
			setResponse(getRequest().post(getEndPoint()));
		} else if (Version.contains("v2.1")) {

			inputJsonPath = GlobalConstant.accountInputV2point1;
			setEndPoint(GlobalConstant.userViewsID2point1);
			setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, UserViews.toString(), true));
			webApiUserClientId = Configuration.readApplicationData("webApiUserClientId", "CreateUser");
			setPoiJSONObject(
					JsonFilesUtil.updateJsonValue(getPoiJSONObject(), "WebApiUserClientIDs", webApiUserClientId));
			getRequest().body(getPoiJSONObject().toString());
			setResponse(getRequest().post(getEndPoint()));
		} else if (Version.contains("v4")) {
			webApiUserClientId = Configuration.readApplicationData("webApiUserClientId", "CreateUser");
			inputJsonPath = GlobalConstant.accountInputV4;
			setEndPoint(GlobalConstant.userViewsID4 + webApiUserClientId);
			setResponse(getRequest().get(getEndPoint()));
		}

	}

	@Then("^Verify the user Views status after activate and response data$")
	public void verify_the_user_Views_status_after_activate_and_response_data() throws Throwable {
		responseResult = getUserViewsFromResponse(getResponse(), "accountName", version);
		actualAccountName = Configuration.readApplicationData("accountName", "CreateUser");
		verifyResposeParameter(responseResult, actualAccountName.toString());

		responseResult = getUserViewsFromResponse(getResponse(), "webAPIClientId", version);
		webAPIClientID = Configuration.readApplicationData("webApiClientId", "CreateUser");
		verifyResposeParameter(responseResult, webAPIClientID.toString());

		responseResult = getUserViewsFromResponse(getResponse(), "webApiUserClientId", version);
		webApiUserClientId = Configuration.readApplicationData("webApiUserClientId", "CreateUser");
		verifyResposeParameter(responseResult, webApiUserClientId.toString());
	}

	@Then("^Verify the specific user status after activate and response data$")
	public void verify_the_specific_user_status_after_activate_and_response_data() throws Throwable {
		responseResult = getUserViewsFromResponse(getResponse(), "accountName", version);
		actualAccountName = Configuration.readApplicationData("accountName", "CreateUser");
		verifyResposeParameter(responseResult, actualAccountName.toString());

		responseResult = getUserViewsFromResponse(getResponse(), "clientId", version);
		webAPIClientID = Configuration.readApplicationData("webApiClientId", "CreateUser");
		verifyResposeParameter(responseResult, webAPIClientID.toString());

		responseResult = getUserViewsFromResponse(getResponse(), "userClientId", version);
		webApiUserClientId = Configuration.readApplicationData("webApiUserClientId", "CreateUser");
		verifyResposeParameter(responseResult, webApiUserClientId.toString());
	}

	@Then("^Call the user information API with status\"([^\"]*)\" in version \"([^\"]*)\"$")
	public void call_the_user_information_API_with_status_in_version(String Status, String Version) throws Throwable {
		waitForAPItoResponse(2);
		setEndPoint("/api/v4/accounts?statusFilter=" + Status);
		setResponse(getRequest().get(getEndPoint()));
	}

	@Then("^Call the all user information API with status\"([^\"]*)\" in version \"([^\"]*)\"$")
	public void call_the_all_user_information_API_with_status_in_version(String Status, String Version)
			throws Throwable {
		waitForAPItoResponse(2);
		setEndPoint("/api/v4/users?statusFilter=" + Status);
		setResponse(getRequest().get(getEndPoint()));
	}

	@Then("^Call the user information API$")
	public void call_the_user_information_API() throws Throwable {
		waitForAPItoResponse(2);
		setEndPoint("/api/v4/accounts");
		setResponse(getRequest().get(getEndPoint()));
	}

	@Then("^Call the all user information API$")
	public void call_the_all_user_information_API() throws Throwable {
		waitForAPItoResponse(2);
		setEndPoint("/api/v4/users");
		setResponse(getRequest().get(getEndPoint()));
	}

	@Then("^Call the account geography API with geography filter \"([^\"]*)\" in version \"([^\"]*)\"$")
	public void call_the_account_geography_API_with_geography_filter_in_version(String geographyOption, String Version)
			throws Throwable {
		waitForAPItoResponse(2);
		setEndPoint("/api/v4/accounts/self/available-geographies?geographyFilter=" + geographyOption);
		setResponse(getRequest().get(getEndPoint()));
	}

	@When("^Call the get account geography configuration api with client id")
	public void call_the_get_account_geography_configuration_api_with_Client_id() throws Throwable {
		waitForAPItoResponse(2);
		webAPIClientID = Configuration.readApplicationData("webApiClientId", "CreateUser");
		System.out.println("webAPIClientIDwebAPIClientIDwebAPIClientIDwebAPIClientIDwebAPIClientID " + webAPIClientID);
		setEndPoint("/api/v4/accounts/" + webAPIClientID + "/geography-configurations");
		setResponse(getRequest().get(getEndPoint()));
	}

	@When("^Call the Retrieve all users from a specific account api with client id")
	public void call_the_retrieve_users_from_a_specific_account_api_api_client_id() {
		waitForAPItoResponse(2);
		setEndPoint("/api/v4/accounts/" + webAPIClientID + "/users");
		setResponse(getRequest().get(getEndPoint()));
	}

	@Then("^Call the account geography API$")
	public void call_the_account_geography_API() throws Throwable {
		waitForAPItoResponse(2);
		setEndPoint("/api/v4/accounts/self/available-geographies");
		setResponse(getRequest().get(getEndPoint()));
	}

	@When("^Call the supported language information API$")
	public void call_the_supported_language_information_API() throws Throwable {
		waitForAPItoResponse(2);
		setEndPoint("/api/v4/users/supported-localization-languages");
		setResponse(getRequest().get(getEndPoint()));
	}

	@Then("^Verify all the supported langauge$")
	public void verify_all_the_supported_langauge() throws Throwable {
		List language = getResponse().path("results.name");
		Assert.assertTrue(language.contains("Dutch"));
		Assert.assertTrue(language.contains("English"));
		Assert.assertTrue(language.contains("French"));
		Assert.assertTrue(language.contains("German"));
	}

	@When("^Update model json of update account geography configure API")
	public void update_model_jdon_of_update_Account_geography_Configuration_Api() throws Exception {
		waitForAPItoResponse(3);
		inputJsonPath = GlobalConstant.accountInputV4;
		setPoiJSONObject(JsonFilesUtil.readJsonData(inputJsonPath, updateAccountgeography.toString(), true));
		setPoiJSONObject(JsonFilesUtil.updateAccountGeographyJson(getPoiJSONObject(), "restrictionType", "Limit"));
		setPoiJSONObject(JsonFilesUtil.updateAccountGeographyJson(getPoiJSONObject(), "accountGeos", "Limit"));
		getRequest().body(getPoiJSONObject().toString());
	}

	@Then("^Verify the response messaage and get client ID")
	public void verify_the_response_messaage_and_get_client_ID() throws Throwable {
		waitForAPItoResponse(2);
	}
}
