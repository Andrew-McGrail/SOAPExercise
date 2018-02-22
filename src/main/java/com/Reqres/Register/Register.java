package com.Reqres.Register;

import com.Reqres.RestReqres;
import com.Reqres.Register.object.Request;
import com.orasi.api.restServices.RestService;
import com.orasi.api.restServices.Headers.HeaderType;
import com.orasi.api.restServices.RestResponse;

public class Register {
	
	private RestService restService = new RestService();
	public String Path = RestReqres.baseUrl + "/api";
	
	public RestResponse createRegister(Request request) {
		return restService.sendPostRequest(Path+"/register",  HeaderType.JSON,
				RestService.getJsonFromObject(request));
	}
	
	public RestResponse createLogin(Request request) {
		return restService.sendPostRequest(Path+"/login", HeaderType.JSON,
				RestService.getJsonFromObject(request));
	}
}