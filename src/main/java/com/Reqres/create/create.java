package com.Reqres.create;

import com.Reqres.RestReqres;
import com.Reqres.create.object.Request;
import com.orasi.api.restServices.RestResponse;
import com.orasi.api.restServices.RestService;
import com.orasi.api.restServices.Headers.HeaderType;

public class create {

	private RestService restService = new RestService();
	public String Path = RestReqres.baseUrl + "/api/users";
	
	public RestResponse createCreate(Request request) {
		return restService.sendPostRequest(Path, HeaderType.JSON,
				RestService.getJsonFromObject(request));
	}
	
	public RestResponse createPutUpdate(Request request) {
		return restService.sendPutRequest(Path+"/2", HeaderType.JSON,
				RestService.getJsonFromObject(request));
	}
	
	public RestResponse createPatchUpdate(Request request) {
		return restService.sendPatchRequest(Path+"/2", HeaderType.JSON,
				RestService.getJsonFromObject(request));
	}
	
}
