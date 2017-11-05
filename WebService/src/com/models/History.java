package com.models;

import java.util.Date;

public class History {

	private int id;
	private int idCustomer;
	private int idDriver;
	private int rating;
	private String feedback;
	private Date date;
	private String pickup;
	private String dest;
	private boolean isHiddenCust;
	private boolean isHiddenDriver;

	public History() {
		id = 0;
		idCustomer = 0;
		idDriver = 0;
		rating = 0;
		feedback = "";
		date = new Date();
		pickup = "";
		dest = "";
		isHiddenDriver = false;
		isHiddenCust = false;
	}

	public int getId() {
		return id;
	}

	public int getIdCustomer() {
		return idCustomer;
	}

	public int getIdDriver() {
		return idDriver;
	}

	public int getRating() {
		return rating;
	}

	public String getFeedback() {
		return feedback;
	}

	public Date getDate() {
		return date;
	}

	public String getPickUp() {
		return pickup;
	}

	public String getDestination() {
		return dest;
	}

	public boolean isHiddenByCustomer() {
		return isHiddenCust;
	}

	public boolean isHiddenByDriver() {
		return isHiddenDriver;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	public void setIdDriver(int idDriver) {
		this.idDriver = idDriver;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setPickUp(String pickup) {
		this.pickup = pickup;
	}

	public void setDestination(String dest) {
		this.dest = dest;
	}

	public void setHiddenCustomer() {
		isHiddenCust = true;
	}

	public void setHiddenDriver() {
		isHiddenDriver = true;
	}
}