package com.Reqres.update;

import com.Reqres.RestReqres;
import com.Reqres.update.object.Request;
import com.orasi.api.restServices.RestResponse;
import com.orasi.api.restServices.RestService;
import com.orasi.api.restServices.Headers.HeaderType;

public class update {

	private RestService restService = new RestService();
	public String Path = RestReqres.baseUrl + "/api/";
	
	public RestResponse createUpdate(Request request) {				// Creates https://reqres.in/ "Put" Updated
		return restService.sendPutRequest(Path+"users/2",  HeaderType.JSON,
				RestService.getJsonFromObject(request));
	}
	
	public RestResponse createListResponses(Request request) {		// Creates https://reqres.in/ "Get" "List<resource>" 
		return restService.sendGetRequest(Path+"unknown",  HeaderType.JSON);
	}	
}
