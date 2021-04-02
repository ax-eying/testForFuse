package com.hitachi;

public class Car {

	private String name;
	private String model;
	private int year;

	public Car(String name, String model, int year) {
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
