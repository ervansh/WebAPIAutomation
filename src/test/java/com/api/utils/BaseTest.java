package com.api.utils;
import java.io.IOException;
/**
 * 
 * @author Rishabh Srivastava
 * @Description
 * This Class read the Base APIURL,Authorization,client_id,userclient_id,contenttype from the properties file.
 * and read request and response from Utilities once the script completed.
 */
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;

public class BaseTest {
	protected String endPointUrl;
	private static String Authorization;
	private static String client_id;
	private static String userclient_id;
	private static String contenttype;
	public static String languageValue;
	public static String userValue;
	public static String testCaseStatus;

	@Before
	public void setup() throws Exception {
		RestAssured.config = RestAssured.config().sslConfig(SSLConfig.sslConfig().allowAllHostnames());
		endPointUrl = Configuration.readConfigFile("APIURL");
		RestAssured.baseURI = endPointUrl;
		Authorization = Configuration.readConfigFile("Authorization");
		client_id = (Configuration.readConfigFile("client_id"));
		//String language =System.getenv("language_name");
		String User=System.getenv("user_name");
		if (User == null) {
			if (User == null) {
				User = Configuration.readConfigFile("DefaultUser");
			}
		}
		userValue=User;
		switch (userValue) {
		case "SMRP":
			System.out.println("*************** With SMRP User ***************************");
			Authorization=(Configuration.readConfigFile("Authorization_smrp"));
			client_id=(Configuration.readConfigFile("client_id_smrp"));
			userclient_id = (Configuration.readConfigFile("userClient_id_smrp"));
			break;
		case "Journodex":
			System.out.println("*************** With Journodex User ***************************");
			Authorization=(Configuration.readConfigFile("Authorization_journodex"));
			client_id=(Configuration.readConfigFile("client_id_journodex"));
			userclient_id = (Configuration.readConfigFile("userclient_id_journodex"));
			break;
		}

		/*if (language == null) {
			if (language == null) {
				language = Configuration.readConfigFile("Language");
			}
		}
		
		
		languageValue = language;
		switch (languageValue) {
		case "English (US)":
			userclient_id = (Configuration.readConfigFile("userclient_id_english"));
			break;
		case "Dutch":
			userclient_id = (Configuration.readConfigFile("userclient_id_dutch"));
			break;
		case "French":
			userclient_id = (Configuration.readConfigFile("userclient_id_french"));
			break;
		}*/
		contenttype = (Configuration.readConfigFile("contenttype"));
		System.gc();
	}

	public static String getAuthorization() {
		return Authorization;
	}

	public static String getClient_id() {
		return client_id;
	}

	public static String getUserclient_id() {
		return userclient_id;
	}

	public static String getContenttype() {
		return contenttype;
	}

	@After
	public void tearDown(Scenario scenario) throws IOException {
		testCaseStatus=scenario.getStatus();
		if (scenario.isFailed()) {
			scenario.write(
					"Failed TC :"+"#" + scenario.getName() + "#");
			scenario.write(
					"-------------------------Request and Response Content--------------------------------------");
			scenario.write(
					"*******************************************************************************************");
			scenario.write(
					"--------------------Class Name:" + Utilities.getClassName() + "----------------------------");
			scenario.write(
					"*******************************************************************************************");
			scenario.write("EndPoint URL=" + RestAssured.baseURI.toString() + Utilities.getEndPoint());
			scenario.write(
					"*******************************************************************************************");
			scenario.write("Request Body :" + Utilities.getPoiJSONObject());
			scenario.write(
					"*******************************************************************************************");
			scenario.write("Response" + Utilities.getResponse().asString());
			scenario.write(
					"*******************************************************************************************");
			scenario.write("Response" + Utilities.actualStatusCode);
			scenario.write(
					"*******************************************************************************************");
			scenario.write("Status of Test Case :" + scenario.getStatus());
		} else {
			scenario.write(
					"-------------------------Request and Response Content--------------------------------------");
			scenario.write(
					"*******************************************************************************************");
			scenario.write(
					"--------------------Class Name:" + Utilities.getClassName() + "----------------------------");
			scenario.write(
					"*******************************************************************************************");
			scenario.write("URI=" + RestAssured.baseURI.toString() + Utilities.getEndPoint());
			scenario.write(
					"*******************************************************************************************");
			scenario.write("Request Body :" + Utilities.getPoiJSONObject());
			scenario.write(
					"*******************************************************************************************");
			scenario.write("Response" + Utilities.getResponse().asString());
			scenario.write(
					"*******************************************************************************************");
			scenario.write("Response" + Utilities.actualStatusCode);
			scenario.write(
					"*******************************************************************************************");
			scenario.write("Status of Test Case :" + scenario.getStatus());
		}
		ReadAndWritePropertiesFile.LogRequestAndResponse( Utilities.getClassName(), RestAssured.baseURI.toString(),Utilities.getEndPoint(), Utilities.getPoiJSONObject(), Utilities.getResponse(),
		                                                            Utilities.actualStatusCode, scenario.getStatus(),scenario.getName());
	}
	
	
}
