package com.api.utils;

import cucumber.api.java.en.When;

public class CommanSteps extends Utilities {

	/**
	 * @author Rishabh Srivastava
	 * This method is used to Login in API and it takes value from Base Test
	 * Which are required to login.
	 * 
	 * @throws Throwable
	 */
	@When("^Login in to API$")
	public void login_in_to_API() throws Throwable {
		setRequest(getAllHeaders(BaseTest.getAuthorization(), BaseTest.getClient_id(), BaseTest.getUserclient_id(),
				BaseTest.getContenttype()));
	}
}
