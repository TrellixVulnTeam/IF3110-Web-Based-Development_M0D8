package com.models;

public class Location {

	private String name;

	public Location() {
		name = "";
	}

	public Location(String loc) {
		name = loc;
	}

	@Override
	public String toString() {
		return name;
	}

	public String getLocation() {
		return name;
	}

	public void setLocation(String loc) {
		name = loc;
	}

}