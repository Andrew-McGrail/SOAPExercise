package com.Reqres.postsNew.object;

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

public class Request {
	@JsonProperty("id")
	private Long id;
	@JsonProperty("first_name")
	private String firstName;
	@JsonProperty("last_name")
	private String lastName;
	@JsonProperty("avatar")
	private String avatar;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	@JsonProperty("id")
	public Long getId() {
	return id;
	}
	
	@JsonProperty("id")
	public void setId(Long id) {
	this.id = id;
	}
	
	@JsonProperty("first_name")
	public String getFirstName() {
	return firstName;
	}
	
	@JsonProperty("first_name")
	public void setFirstName(String firstName) {
	this.firstName = firstName;
	}
	
	@JsonProperty("last_name")
	public String getLastName() {
	return lastName;
	}
	
	@JsonProperty("last_name")
	public void setLastName(String lastName) {
	this.lastName = lastName;
	}
	
	@JsonProperty("avatar")
	public String getAvatar() {
	return avatar;
	}
	
	@JsonProperty("avatar")
	public void setAvatar(String avatar) {
	this.avatar = avatar;
	}
	
	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
	return this.additionalProperties;
	}
	
	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
	}
}