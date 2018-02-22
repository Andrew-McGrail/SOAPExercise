package com.Reqres.singleUser;

import com.Reqres.RestReqres;
import com.Reqres.singleUser.object.Request;
import com.orasi.api.restServices.RestResponse;
import com.orasi.api.restServices.RestService;
import com.orasi.api.restServices.Headers.HeaderType;

public class singleUser {

	private RestService restService = new RestService();
	public String Path = RestReqres.baseUrl + "/api/";
	
	public RestResponse createUser(Request request) {							// Creates https://reqres.in/ "Get" "Single User"
		return restService.sendGetRequest(Path+"users/2", HeaderType.JSON);
	}
	
	public RestResponse createSingleResponses(Request request) {				// Creates https://reqres.in/ "Get" "Single<resource>"
		return restService.sendGetRequest(Path+"unknown/2", HeaderType.JSON);
	}
	
	public RestResponse createSingleResponsesFail(Request request) {			// Creates https://reqres.in/ "Get" "Single<resource>" Not Found
		return restService.sendGetRequest(Path+"unknown/23", HeaderType.JSON);
	}
}
