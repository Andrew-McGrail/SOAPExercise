package com.Reqres.User;

import org.testng.annotations.Test;

import com.Reqres.RestReqres;
import com.Reqres.user.object.Request;
import com.Reqres.user.object.Response;
import com.orasi.api.restServices.RestResponse;
import com.orasi.utils.TestReporter;

public class TestSingleUser {						// Tests the https://reqres.in/ Single user 				ALWAYS PASS(FAIL)
	@Test
	public void testSingleUser() {
		
		Request request = new Request();
		
		RestResponse response = RestReqres.user().createUser(request);
		Response data = response.mapJSONToObject(Response.class);
		
		TestReporter.logAPI(response.getStatusCode() == 200,
				"Validating the Correct Response", response);
		
		TestReporter.softAssertTrue(data.getID() == 2,					//<-- Not Checked?
				"Validating the user ID");
		System.out.println("Data-ID is listed as: "+data.getAdditionalProperties());
		
		TestReporter.softAssertTrue(data.getFirstName() == "Janet",		//<-- Not Checked?
				"Validating the user first name");
		System.out.println("Data-FN is listed as: "+data.getFirstName());
		
		TestReporter.softAssertTrue(data.getLastName() == "Weaver",		//<-- Not Checked?
				"Validating the user last name");
		
		TestReporter.softAssertTrue(data.getAvatar() == "https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg",	//<-- Not Checked?
				"Validating the user's avatar");
	}
}
