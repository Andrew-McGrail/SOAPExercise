package com.Reqres.Update;

import org.testng.annotations.Test;

import com.Reqres.RestReqres;
import com.Reqres.update.object.Request;
import com.Reqres.update.object.Response;
import com.orasi.api.restServices.RestResponse;
import com.orasi.utils.TestReporter;

public class TestSingleResource {
	@Test
	public void testSingleResource() {				// Tests https://reqres.in/   "Single <Resource>" Updated			FAILED, cant parse "per_page" from the JSON
		
		Request request = new Request();
		
		RestResponse response = RestReqres.update().createListResponses(request);
		Response data = response.mapJSONToObject(Response.class);
		
		TestReporter.logAPI(response.getStatusCode() == 200,
				"Validating the Correct Response", response);
		
		TestReporter.softAssertTrue(data.getID() == 2,						//<-- Not Checked?
				"Validating the table id for the item");
		
		TestReporter.softAssertTrue(data.getName() == "fuchsia rose",		//<-- Not Checked?
				"Validating the name for the entry");
		
		TestReporter.softAssertTrue(data.getYear() == 2001,
				"Validating the year associated with the entry");
		
		TestReporter.softAssertTrue(data.getColor() == "#C74375",
				"Validating the color for the entry");
		
		TestReporter.softAssertTrue(data.getPantoneValue() == "17-2031",
				"Validating the Pantone Value for the entry");
	}
}
