package com.Reqres.User;

import org.testng.annotations.Test;

import com.Reqres.RestReqres;
import com.Reqres.user.object.Request;
import com.orasi.api.restServices.RestResponse;
import com.orasi.utils.TestReporter;

public class TestSingleUserNotFound {
	@Test
	public void testFalseUser() {							// Tests https://reqres.in/ Single User Not Found						PASSED
		
		Request request = new Request();
		
		RestResponse response = RestReqres.user().createFalseUser(request);
		
		TestReporter.logAPI(response.getStatusCode() == 404,
				"Validating the Correct Response", response);
	}
}
