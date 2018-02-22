package com.Reqres.user.object;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"page",
"per_page",
"total",
"total_pages",
"data"
})
public class Response {
	@JsonProperty("page")
	private Integer page;
	@JsonProperty("per_page")
	private Integer perPage;
	@JsonProperty("total")
	private Integer total;
	@JsonProperty("total_pages")
	private Integer totalPages;
	@JsonProperty("data")
	private List<Datum> data = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
//---------------^^From jsonschema2pojo.org^^-----------------------------------------------
	private int id;
	private String first_name;
	private String last_name;
	private String avatar;
	
	
	@JsonProperty("page")
	public Integer getPage() {
	return page;
	}

	@JsonProperty("page")
	public void setPage(Integer page) {
	this.page = page;
	}

	@JsonProperty("per_page")
	public Integer getPerPage() {
	return perPage;
	}

	@JsonProperty("per_page")
	public void setPerPage(Integer perPage) {
	this.perPage = perPage;
	}

	@JsonProperty("total")
	public Integer getTotal() {
	return total;
	}

	@JsonProperty("total")
	public void setTotal(Integer total) {
	this.total = total;
	}

	@JsonProperty("total_pages")
	public Integer getTotalPages() {
	return totalPages;
	}

	@JsonProperty("total_pages")
	public void setTotalPages(Integer totalPages) {
	this.totalPages = totalPages;
	}

	@JsonProperty("data")
	public List<Datum> getData() {
	return data;
	}

	@JsonProperty("data")
	public void setData(List<Datum> data) {
	this.data = data;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
	return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
	}
//--------------------^^From jsonschema2pojo.org^^--------------------------------------------------------------------------------------------------//
	
	
	

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
}
