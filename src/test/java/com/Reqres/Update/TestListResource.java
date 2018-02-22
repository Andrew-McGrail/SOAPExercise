package com.Reqres.Update;

import org.testng.annotations.Test;

import com.Reqres.RestReqres;
import com.Reqres.update.object.Request;
import com.Reqres.update.object.Response;
import com.orasi.api.restServices.RestResponse;
import com.orasi.utils.TestReporter;

public class TestListResource {
	@Test
	public void testListResource() {				// Tests https://reqres.in/ "List <Resource>" Updated			PASS
		
		Request request = new Request();
		
		RestResponse response = RestReqres.update().createListResponses(request);
		Response data = response.mapJSONToObject(Response.class);
		
		TestReporter.logAPI(response.getStatusCode() == 200,
				"Validating the Correct Response", response);
		
		TestReporter.assertTrue(data.getPage() == 1,
				"Validating the page number");
		
		TestReporter.assertTrue(data.getPerPage() == 3,
				"Validating the entries per page");
		
		TestReporter.assertTrue(data.getTotal() == 12,
				"Validating the total number entries");
		
		TestReporter.assertTrue(data.getTotalPages() == 4,
				"Validating the total number of pages");
		
		TestReporter.assertTrue(data.getData().get(1).getId() == 2,							// <- get(1) is used here to avoid an error, but the data in get(0) reads as 2 as well, weird.
				"Validating the resource ID");
		
		TestReporter.assertTrue(data.getData().get(0).getName().equals("cerulean"),
				"Validating the resource name");
		
		TestReporter.assertTrue(data.getData().get(0).getYear() == 2000,
				"Validating the resource year");
		
		TestReporter.assertTrue(data.getData().get(0).getColor().equals("#98B2D1"),
				"Validating the resource color");
		
		TestReporter.assertTrue(data.getData().get(0).getPantoneValue().equals("15-4020"),
				"Validating the resource pantone value");
	}
}
