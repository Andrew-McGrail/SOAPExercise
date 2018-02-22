package com.Reqres.Delete;

import org.testng.annotations.Test;

import com.Reqres.RestReqres;
import com.Reqres.delete.object.Request;
import com.orasi.api.restServices.RestResponse;
import com.orasi.utils.TestReporter;

public class TestDelete {
	@Test
	public void testDelete() {					// Tests https://reqres.in/ DELETE API example			PASSED
		Request request = new Request();
		
		RestResponse response = RestReqres.delete().createDelete(request);
		
		TestReporter.logAPI(response.getStatusCode() == 204,
				"Validating the Correct Response", response);
	}
}
