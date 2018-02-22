package com.Reqres.update.object;

import java.util.HashMap;
import java.util.Map;


public class Response {

	private String name;
	private String job;
	private String updatedAt;
	private String color;
	private String pantone_value;
	private int page;
	private int perPage;
	private int total;
	private int totalPages;
	private int id;
	private int year;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	
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
	
	public String getUpdatedAt() {
		return updatedAt;
	}
	
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		this.page = page;
	}
	
	public int getPerPage() {
		return perPage;
	}
	
	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}
	
	public int getTotal() {
		return total;
	}
	
	public void setTotal(int total) {
		this.total = total;
	}
	
	public int getTotalPages() {
		return totalPages;
	}
	
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getID() {
		return id;
	}
	
	public void setName(int id) {
		this.id = id;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getPantoneValue() {
		return pantone_value;
	}
	
	public void setPantoneValue(String pantone_value) {
		this.pantone_value = pantone_value;
	}
												 							
	public Map<String, Object> getAdditionalProperties() {
	return this.additionalProperties;
	}
																				
	public void setAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
	}
}
