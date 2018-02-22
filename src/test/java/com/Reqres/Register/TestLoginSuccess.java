package com.Reqres.Register;

import org.testng.annotations.Test;

import com.Reqres.RestReqres;
import com.Reqres.Register.object.Request;
import com.Reqres.Register.object.Response;
import com.orasi.api.restServices.RestResponse;
import com.orasi.utils.TestReporter;

public class TestLoginSuccess {
	@Test
	public void testLoginSuccess() {				// Tests https://reqres.in/ Login Success						PASS
		
		String email = "peter@klaven";
		String password = "cityslicka";
		
		Request request = new Request();
		request.setEmail(email);
		request.setPassword(password);
		
		RestResponse response = RestReqres.register().createLogin(request);
		Response data = response.mapJSONToObject(Response.class);
		
		TestReporter.logAPI(response.getStatusCode() == 200,
				"Validating the Correct Response", response);
		
		TestReporter.assertTrue(data.getToken().equals("QpwL5tke4Pnpja7X"),
				"Validating the Token Message");
	}
}
