package com.Reqres.PostsNew;

import org.testng.annotations.Test;

import com.Reqres.RestReqres;
import com.Reqres.postsNew.object.Request;
import com.Reqres.postsNew.object.Response;
import com.orasi.api.restServices.RestResponse;
import com.orasi.utils.TestReporter;

public class TestCreate {
	@Test 
	public void testCreate() {							// Tests https://reqres.in/ Create example						ALWAYS PASS(FAIL)
		
		String name = "morpheus";
		String job = "leader";
		
		Request request = new Request();
		request.setName(name);
		request.setJob(job);
		
		RestResponse response = RestReqres.posts().createCreate(request);
		Response data = response.mapJSONToObject(Response.class);
		
		TestReporter.logAPI(response.getStatusCode() == 201,
				"Validating the Correct Response", response);
		
		TestReporter.softAssertTrue(data.getName() == "morpheus",
				"Validating the entry name");
		
		TestReporter.softAssertTrue(data.getJob() == "leader",
				"Validating the entry name");
		
		TestReporter.softAssertTrue(data.getID() == 409,
				"Validating the entry name");
		
		TestReporter.softAssertTrue(data.getCreatedAt() == "2018-02-21T13:46:07.112Z",
				"Validating the entry name");
		
	}
}
