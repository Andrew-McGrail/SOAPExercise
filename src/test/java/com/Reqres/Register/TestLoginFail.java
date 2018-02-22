package com.Reqres.Register;

import org.testng.annotations.Test;

import com.Reqres.RestReqres;
import com.Reqres.Register.object.Request;
import com.Reqres.Register.object.Response;
import com.orasi.api.restServices.RestResponse;
import com.orasi.utils.TestReporter;

public class TestLoginFail {
	@Test
	public void testLoginFail() {				// Tests https://reqres.in/ Login Unsuccess					PASS
		
		String email = "peter@klaven";	
		
		Request request = new Request();
		request.setEmail(email);
		
		RestResponse response = RestReqres.register().createLogin(request);
		Response data = response.mapJSONToObject(Response.class);
		
		TestReporter.logAPI(response.getStatusCode() == 400,
				"Validating the Correct Response", response);
		
		TestReporter.assertTrue(data.getError().equals("Missing password"),
				"Validating the Error Message");
	}
}
