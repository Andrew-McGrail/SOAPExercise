package com.Reqres.singleUser;

import org.testng.annotations.Test;

import com.Reqres.RestReqres;
import com.Reqres.singleUser.object.Request;
import com.Reqres.singleUser.object.Response;
import com.orasi.api.restServices.RestResponse;
import com.orasi.utils.TestReporter;

public class TestSingleResource {
	@Test
	public void testSingleResource() {				// Tests https://reqres.in/   "Single <Resource>" Updated			PASS
		
		Request request = new Request();
		
		RestResponse response = RestReqres.singleUser().createSingleResponses(request);
		Response data = response.mapJSONToObject(Response.class);
		
		TestReporter.logAPI(response.getStatusCode() == 200,
				"Validating the Correct Response", response);
		
		TestReporter.assertTrue(data.getData().getId() == 2,
				"Validating the resource ID");
		
		TestReporter.assertTrue(data.getData().getName().equals("fuchsia rose"),
				"Validating the resource name");
		
		TestReporter.assertTrue(data.getData().getYear() == 2001,
				"Validating the resource year");
		
		TestReporter.assertTrue(data.getData().getColor().equals("#C74375"),
				"Validating the resource color");
		
		TestReporter.assertTrue(data.getData().getPantoneValue().equals("17-2031"),
				"Validating the resource pantone value");
	}
}
