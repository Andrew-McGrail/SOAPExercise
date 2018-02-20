package com.Reqres.Update;

import org.testng.annotations.Test;

import com.Reqres.RestReqres;
import com.Reqres.update.object.Request;
import com.Reqres.update.object.Response;
import com.orasi.api.restServices.RestResponse;
import com.orasi.utils.TestReporter;

public class TestListResource {
	@Test
	public void testListResource() {				// Tests https://reqres.in/ "List <Resource>" Updated			FAILED, cant parse "per_page" from JSON
		
		Request request = new Request();
		
		RestResponse response = RestReqres.update().createListResponses(request);
		Response data = response.mapJSONToObject(Response.class);
		
		TestReporter.logAPI(response.getStatusCode() == 200,
				"Validating the Correct Response", response);
		
		TestReporter.softAssertTrue(data.getPage() == 1,
				"Validating the page number");
		
		TestReporter.softAssertTrue(data.getPerPage() == 3,
				"Validating the entries per page");
		
		TestReporter.softAssertTrue(data.getTotal() == 12,
				"Validating the total number entries");
		
		TestReporter.softAssertTrue(data.getTotalPages() == 4,
				"Validating the total number of pages");
	}
}
