package com.Reqres.delete;

import com.Reqres.RestReqres;
import com.Reqres.delete.object.Request;
import com.orasi.api.restServices.RestResponse;
import com.orasi.api.restServices.RestService;
import com.orasi.api.restServices.Headers.HeaderType;

public class delete {
	
	private RestService restService = new RestService();
	public String Path = RestReqres.baseUrl + "/api/users?page=2";
	
	public RestResponse createDelete(Request request) {
		return restService.sendDeleteRequest(Path, HeaderType.JSON);
	}
}
