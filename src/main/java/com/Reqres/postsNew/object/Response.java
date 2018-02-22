package com.Reqres.postsNew.object;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Response {
	
	private Long page;
	private Long perPage;
	private Long total;
	private Long totalPages;
	private Long id;
	private String name;
	private String job;
	private String createdAt;
	private List<Response> data = null;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public Long getPage() {
	return page;
	}

	public void setPage(Long page) {
	this.page = page;
	}

	public Long getPerPage() {
	return perPage;
	}

	public void setPerPage(Long perPage) {
	this.perPage = perPage;
	}

	public Long getTotal() {
	return total;
	}

	public void setTotal(Long total) {
	this.total = total;
	}

	public Long getTotalPages() {
	return totalPages;
	}

	public void setTotalPages(Long totalPages) {
	this.totalPages = totalPages;
	}
	
	public Long getID() {
	return id;
	}

	public void setID(Long id) {
	this.id = id;
	}
	
	public String getName() {
	return name;
	}
		
	public void setName(String name) {
	this.name = name;
	}
	
	public String getJob() {
	return job;
	}
			
	public void setJob(String job) {
	this.job = job;
	}
	
	public String getCreatedAt() {
	return createdAt;
	}
			
	public void setCreatedAt(String createdAt) {
	this.createdAt = createdAt;
	}

	public List<Response> getData() {
	return data;
	}

	public void setData(List<Response> data) {
	this.data = data;
	}

	public Map<String, Object> getAdditionalProperties() {
	return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
	}
}