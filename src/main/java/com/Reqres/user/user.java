package com.Reqres.user;

import com.Reqres.RestReqres;
import com.Reqres.user.object.Request;
import com.orasi.api.restServices.RestResponse;
import com.orasi.api.restServices.RestService;
import com.orasi.api.restServices.Headers.HeaderType;

public class user {
	
	private RestService restService = new RestService();
	public String Path = RestReqres.baseUrl + "/api/users/";
	
	public RestResponse createUser(Request request) {
		return restService.sendGetRequest(Path+"2", HeaderType.JSON);
			
	}
	
	public RestResponse createFalseUser(Request request) {
		return restService.sendGetRequest(Path+"23", HeaderType.JSON);
	}
}
