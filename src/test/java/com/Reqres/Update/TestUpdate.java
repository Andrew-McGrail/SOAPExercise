package com.Reqres.Update;

import org.testng.annotations.Test;

import com.Reqres.RestReqres;
import com.Reqres.update.object.Request;
import com.Reqres.update.object.Response;
import com.orasi.api.restServices.RestResponse;
import com.orasi.utils.TestReporter;

public class TestUpdate {
	@Test
	public void testUpdate() {				// Tests https://reqres.in/ "Put" Updated			PASSED(FAILED NOW?)
		
		String name = "morpheus";
		String job = "zion resident";
		
		Request request = new Request();
		request.setName(name);
		request.setJob(job);
		
		RestResponse response = RestReqres.update().createUpdate(request);
		Response data = response.mapJSONToObject(Response.class);
		
		TestReporter.logAPI(response.getStatusCode() == 200,
				"Validating the Correct Response", response);
		
		TestReporter.softAssertTrue(data.getName() == "morpheus",
				"Validating the response Name");
		
		TestReporter.softAssertTrue(data.getJob() == "zion resident",
				"Validating the response Job");
		
		TestReporter.softAssertTrue(data.getUpdatedAt() != "",
				"Validating the time updated");
	}
}
