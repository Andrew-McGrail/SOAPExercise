package com.Reqres.PostsNew;

import org.testng.annotations.Test;
import com.Reqres.RestReqres;
import com.Reqres.postsNew.object.Request;
import com.Reqres.postsNew.object.Response;
import com.orasi.api.restServices.RestResponse;
import com.orasi.utils.TestReporter;

public class TestPostsNew {
	@Test 
	public void testPostsNew() {						// Tests https://reqres.in/ List Users API example				PASS
		
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
		
		TestReporter.assertTrue(data.getData().get(0).getId() == 4,
				"Validating the first entry's ID");
		
		TestReporter.assertTrue(data.getData().get(0).getFirstName().equals("Eve"),
				"Validating the first entry's first name");
		
		TestReporter.assertTrue(data.getData().get(0).getLastName().equals("Holt"),
				"Validating the first entry's last name");
		
		TestReporter.assertTrue(data.getData().get(0).getAvatar().equals("https://s3.amazonaws.com/uifaces/faces/twitter/marcoramires/128.jpg"),
				"Validating the first entry's avatar URL");
		
		TestReporter.assertAll();
	}
}
