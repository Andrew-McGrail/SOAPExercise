package com.Reqres.User;

import org.testng.annotations.Test;

import com.Reqres.RestReqres;
import com.Reqres.user.object.Request;
import com.Reqres.user.object.Response;
import com.orasi.api.restServices.RestResponse;
import com.orasi.utils.TestReporter;

public class TestSingleUser {						// Tests the https://reqres.in/ Single user 				PASSED
	@Test
	public void testSingleUser() {
		
		Request request = new Request();
		
		RestResponse response = RestReqres.user().createUser(request);
		Response data = response.mapJSONToObject(Response.class);
		
		TestReporter.logAPI(response.getStatusCode() == 200,
				"Validating the Correct Response", response);
		
		TestReporter.softAssertTrue(data.getID() == 2,
				"Validating the user ID");
		
		TestReporter.softAssertTrue(data.getFirstName() == "Janet",
				"Validating the user first name");
		
		TestReporter.softAssertTrue(data.getLastName() == "Weaver",
				"Validating the user last name");
		
		TestReporter.softAssertTrue(data.getAvatar() == "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg",
				"Validating the user's avatar");
	}
}
