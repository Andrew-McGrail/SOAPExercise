package com.Reqres.postsNew;

import com.Reqres.RestReqres;
import com.Reqres.postsNew.object.Request;
import com.orasi.api.restServices.RestResponse;
import com.orasi.api.restServices.RestService;
import com.orasi.api.restServices.Headers.HeaderType;

public class postsNew {
	
	private RestService restService = new RestService();
	public String Path = RestReqres.baseUrl + "/api/users";
	
	public RestResponse createPostsNew(Request request) {
		return restService.sendGetRequest(Path+"?page=2", HeaderType.JSON);
	}
	
	public RestResponse createCreate(Request request) {
		return restService.sendPostRequest(Path, HeaderType.JSON, "");
	}
}
