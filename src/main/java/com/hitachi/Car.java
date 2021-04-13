package com.hitachi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {

	private String name;
	private String model;
	private int year;

	@JsonCreator
	public Car(@JsonProperty("name") String name, @JsonProperty("model") String model, @JsonProperty("year") int year) {
		this.name = name;
		this.model = model;
		this.year = year;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getYear() {
		return year;
	}

	@Override
	public String toString() {
		return "{name=" + name + ", model=" + model + ", year=" + year + "}";
	}
}
