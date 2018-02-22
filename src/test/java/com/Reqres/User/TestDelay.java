package com.Reqres.User;

import org.testng.annotations.Test;

import com.Reqres.RestReqres;
import com.Reqres.user.object.Request;
import com.Reqres.user.object.Response;
import com.orasi.api.restServices.RestResponse;
import com.orasi.utils.TestReporter;

public class TestDelay {														// Tests https://reqres.in/ Delayed Response 		PASS
	@Test
	public void testDelay() {
		
		Request request = new Request();
		
		RestResponse response = RestReqres.user().delay(request);
		Response data = response.mapJSONToObject(Response.class);
		
		TestReporter.logAPI(response.getStatusCode() == 200,
				"Validating the Correct Response", response);
		
		TestReporter.softAssertTrue(data.getPage() == 1,
				"Validating the page");
		
		TestReporter.softAssertTrue(data.getPerPage() == 3,
				"Validating the listings per page");
		
		TestReporter.softAssertTrue(data.getTotal() == 12,
				"Validating the total number of listings");
		
		TestReporter.softAssertTrue(data.getTotalPages() == 4,
				"Validating the total number of pages");
		
		TestReporter.assertTrue(data.getData().get(0).getId() == 1,
				"Validating the first entry's ID");
		
		TestReporter.assertTrue(data.getData().get(0).getFirstName().equals("George"),
				"Validating the first entry's First Name");
		
		TestReporter.assertTrue(data.getData().get(0).getLastName().equals("Bluth"),
				"Validating the first entry's Last Name");
		
		TestReporter.assertTrue(data.getData().get(0).getAvatar().equals("https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg"),
				"Validating the first entry's avatar URL");
		
		TestReporter.assertAll();
	}
}
