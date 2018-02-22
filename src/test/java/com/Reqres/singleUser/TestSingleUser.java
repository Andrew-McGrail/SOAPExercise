package com.Reqres.singleUser;

import org.testng.annotations.Test;

import com.Reqres.RestReqres;
import com.Reqres.singleUser.object.Request;
import com.Reqres.singleUser.object.Response;
import com.orasi.api.restServices.RestResponse;
import com.orasi.utils.TestReporter;

public class TestSingleUser {						// Tests the https://reqres.in/ Single user 				PASS
	@Test
	public void testSingleUser() {
		
		Request request = new Request();
		
		RestResponse response = RestReqres.singleUser().createUser(request);
		Response data = response.mapJSONToObject(Response.class);
		
		TestReporter.logAPI(response.getStatusCode() == 200,
				"Validating the Correct Response", response);
		
		TestReporter.assertTrue(data.getData().getId() == 2,
				"Validating the user ID");
		
		TestReporter.assertTrue(data.getData().getFirstName().equals("Janet"),
				"Validating the user first name");
		
		TestReporter.assertTrue(data.getData().getLastName().equals("Weaver"),
				"Validating the user last name");
		
		TestReporter.assertTrue(data.getData().getAvatar().equals("https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg"),
				"Validating the user's avatar");
	}
}
