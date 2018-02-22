package com.Reqres.Register;

import com.Reqres.RestReqres;
import com.Reqres.Register.object.Request;
import com.Reqres.Register.object.Response;
import com.orasi.api.restServices.RestResponse;
import com.orasi.utils.TestReporter;
import org.testng.annotations.Test;

public class TestRegister {
	@Test
	public void testRegister() {				// Tests https://reqres.in/ Register Successful					PASS
		
		String email = "sydney@fife";
		String password = "pistol";
		
		Request request = new Request();
		request.setEmail(email);
		request.setPassword(password);
		
		RestResponse response = RestReqres.register().createRegister(request);
		Response data = response.mapJSONToObject(Response.class);
		
		TestReporter.logAPI(response.getStatusCode() == 201,
				"Validating the Correct Response", response);
		
		TestReporter.assertTrue(data.getToken().equals("QpwL5tke4Pnpja7X"),
				"Validating the Token ID");
	}
	
}