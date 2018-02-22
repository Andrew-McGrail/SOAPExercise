package com.Reqres.singleUser;

import org.testng.annotations.Test;

import com.Reqres.RestReqres;
import com.Reqres.singleUser.object.Request;
import com.orasi.api.restServices.RestResponse;
import com.orasi.utils.TestReporter;

public class TestSingleResourceFail {
	@Test
	public void testSingleResourceFail() {				// Tests https://reqres.in/   "Single <Resource>" Updated			PASS
		
		Request request = new Request();
		
		RestResponse response = RestReqres.singleUser().createSingleResponsesFail(request);
		
		TestReporter.logAPI(response.getStatusCode() == 404,
				"Validating the Correct Response", response);
	}
}