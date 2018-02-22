package com.Reqres.singleUser.object;

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
"avatar",
"name",
"year",
"color",
"pantone_value"
})
public class Data {

@JsonProperty("id")
private Integer id;
@JsonProperty("first_name")
private String firstName;
@JsonProperty("last_name")
private String lastName;
@JsonProperty("avatar")
private String avatar;
@JsonProperty("name")
private String name;
@JsonProperty("year")
private Integer year;
@JsonProperty("color")
private String color;
@JsonProperty("pantone_value")
private String pantoneValue;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("id")
public Integer getId() {
return id;
}

@JsonProperty("id")
public void setId(Integer id) {
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

@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

@JsonProperty("year")
public Integer getYear() {
return year;
}

@JsonProperty("year")
public void setYear(Integer year) {
this.year = year;
}

@JsonProperty("color")
public String getColor() {
return color;
}

@JsonProperty("color")
public void setColor(String color) {
this.color = color;
}

@JsonProperty("pantone_value")
public String getPantoneValue() {
return pantoneValue;
}

@JsonProperty("pantone_value")
public void setPantoneValue(String pantoneValue) {
this.pantoneValue = pantoneValue;
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