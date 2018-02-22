package com.Reqres.PostsNew;

import org.testng.annotations.Test;
import com.Reqres.RestReqres;
import com.Reqres.postsNew.object.Request;
import com.Reqres.postsNew.object.Response;
import com.orasi.api.restServices.RestResponse;
import com.orasi.utils.TestReporter;

public class TestPostsNew {
	@Test 
	public void testPostsNew() {						// Tests https://reqres.in/ List Users API example				ALWAYS PASS(FAIL)
		
		Request request = new Request();
		
		RestResponse response = RestReqres.posts().createPostsNew(request);
		Response data = response.mapJSONToObject(Response.class);
		
		TestReporter.logAPI(response.getStatusCode() == 200,
				"Validating the Correct Response", response);
		
		TestReporter.softAssertTrue(data.getPage() == 2,
				"Validating the page number");
		
		TestReporter.softAssertTrue(data.getPerPage() == 3,
				"Validating the number of entries per page");		
		
		TestReporter.softAssertTrue(data.getTotal() == 12,
				"Validating the total number of entries");
		
		TestReporter.softAssertTrue(data.getTotalPages() == 4,
				"Validating the number of pages");
	}
}
