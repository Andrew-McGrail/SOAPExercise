package com.Reqres.user.object;

import java.util.HashMap;
import java.util.Map;

public class Response {
	private int id;
	private String first_name;
	private String last_name;
	private String avatar;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();		// <-- THIS IS IMPORTANT, SAVES THE TEST
	
	public int getID() {
		return id;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return first_name;
	}
	
	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}

	public String getLastName() {
		return last_name;
	}
	
	public void setLastName(String last_name) {
		this.last_name = last_name;
	}
	
	public String getAvatar() {
		return avatar;
	}
	
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
												 							// <- THIS TOO!!
	public Map<String, Object> getAdditionalProperties() {
	return this.additionalProperties;
	}
																			// <- AND THIS!
	public void setAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
	}
}
