package com.Reqres.create;

import org.testng.annotations.Test;

import com.Reqres.RestReqres;
import com.Reqres.create.object.Request;
import com.Reqres.create.object.Response;
import com.orasi.api.restServices.RestResponse;
import com.orasi.utils.TestReporter;

public class TestPutUpdate {
	@Test 
	public void testPatchUpdate() {							// Tests https://reqres.in/ Create example						FAIL
		
		String name = "morpheus";
		String job = "zion resident";
		
		Request request = new Request();
		request.setName(name);
		request.setJob(job);
		
		RestResponse response = RestReqres.create().createPutUpdate(request);
		Response data = response.mapJSONToObject(Response.class);
		
		TestReporter.logAPI(response.getStatusCode() == 200,
				"Validating the Correct Response", response);
		
		TestReporter.assertTrue(data.getName().equals("morpheus"),
				"Validating the entry name");
		
		TestReporter.assertTrue(data.getJob().equals("zion resident"),
				"Validating the entry job");		
		
		TestReporter.assertTrue(data.getUpdatedAt().contains(("2018")),				// <-- Changes when created (obviously)
				"Validating the date the entry was updated");
	}
}
