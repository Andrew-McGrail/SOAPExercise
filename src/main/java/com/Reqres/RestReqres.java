package com.Reqres;

import com.Reqres.Register.Register;
import com.Reqres.delete.delete;
import com.Reqres.postsNew.postsNew;
import com.Reqres.user.user;
import com.Reqres.update.update;

public class RestReqres {
	
	public final static String baseUrl = "https://reqres.in/";
	
	public static postsNew posts() {
		return new postsNew();
	}
	
	public static user user() {
		return new user();
	}
	
	public static update update() {
		return new update();
	}
	
	public static delete delete() {
		return new delete();
	}

	public static Register register() {
		return new Register();
	}
}
