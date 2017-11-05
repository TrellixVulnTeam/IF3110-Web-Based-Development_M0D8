package com.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

public class User {

	private int id;
	private String email;
	private String username;
	private String phoneNumber;
	private String imgPath;
	private String fullName;
	private boolean isDriver;
	private float star;
	private int vote;
	private ArrayList<Location> preferredLocations;

	public User() {
		id = 0;
		email = "";
		username = "";
		phoneNumber = "";
		imgPath = "";
		fullName = "";
		isDriver = false;
		star = 0;
		vote = 0;
		preferredLocations = new ArrayList();
	}

	public User(ResultSet rs) {
		try {
			id = rs.getInt("id");
			email = rs.getString("email");
			username = rs.getString("username");
			phoneNumber = rs.getString("phone_num");
			imgPath = rs.getString("imgPath");
			fullName = rs.getString("fullName");
			isDriver = rs.getBoolean("is_driver");
			star = rs.getFloat("star");
			vote = rs.getInt("vote");
			preferredLocations = new ArrayList();
		} catch (SQLException e) {
			e.printStackTrace();
			id = 0;
			email = "";
			username = "";
			phoneNumber = "";
			imgPath = "";
			fullName = "";
			isDriver = false;
			star = 0;
			vote = 0;
			preferredLocations = new ArrayList();
		}
	}

	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getUsername() {
		return username;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getImagePath() {
		return imgPath;
	}

	public String getName() {
		return fullName;
	}

	public float getStar() {
		return star;
	}

	public int getVote() {
		return vote;
	}

	public ArrayList<Location> getPreferredLocations() {
		return preferredLocations;
	}

	public boolean isDriver() {
		return isDriver;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setImagePath(String imgPath) {
		this.imgPath = imgPath;
	}

	public void setName(String fullName) {
		this.fullName = fullName;
	}

	public void setStar(float star) {
		this.star = star;
	}

	public void setVote(int vote) {
		this.vote = vote;
	}

	public void addLocation(Location loc) {
		preferredLocations.add(loc);
	}

	public void addLocation(String loc) {
		preferredLocations.add(new Location(loc));
	}

	public void setDriver() {
		isDriver = true;
	}

	public void setNonDriver() {
		isDriver = false;
	}
}