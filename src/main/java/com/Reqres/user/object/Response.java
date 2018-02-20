package com.Reqres.user.object;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"id",
"first_name",
"last_name",
"avatar"
})

public class Response {
	@JsonProperty("id")
	private int id;
	@JsonProperty("first_name")
	private String first_name;
	@JsonProperty("last_name")
	private String last_name;
	@JsonProperty("avatar")
	private String avatar;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();		// <-- THIS IS IMPORTANT, SAVES THE TEST
	
	@JsonProperty("id")
	public int getID() {
		return id;
	}
	
	@JsonProperty("id")
	public void setID(int id) {
		this.id = id;
	}
	
	@JsonProperty("first_name")
	public String getFirstName() {
		return first_name;
	}
	
	@JsonProperty("first_name")
	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}

	@JsonProperty("last_name")
	public String getLastName() {
		return last_name;
	}
	
	@JsonProperty("last_name")
	public void setLastName(String last_name) {
		this.last_name = last_name;
	}
	
	@JsonProperty("avatar")
	public String getAvatar() {
		return avatar;
	}
	
	@JsonProperty("avatar")
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	@JsonAnyGetter													 							// <- THIS TOO!!
	public Map<String, Object> getAdditionalProperties() {
	return this.additionalProperties;
	}

	@JsonAnySetter																				// <- AND THIS!
	public void setAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
	}
}
