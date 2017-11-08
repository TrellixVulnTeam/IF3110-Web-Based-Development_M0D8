package com.models;

import java.sql.ResultSet;
import java.sql.Date;

public class History {

	private int id;
	private int idCustomer;
	private int idDriver;
	private int rating;
	private String feedback;
	private String date;
	private String pickup;
	private String dest;
	private boolean hiddenCust;
	private boolean hiddenDriver;

	public History() {
		id = 0;
		idCustomer = 0;
		idDriver = 0;
		rating = 0;
		feedback = "";
		date = "0000-00-00";
		pickup = "";
		dest = "";
		hiddenDriver = false;
		hiddenCust = false;
	}

	public History(ResultSet rs) {
		try {
			id = rs.getInt("id_order");
			idCustomer = rs.getInt("id_customer");
			idDriver = rs.getInt("id_driver");
			rating = rs.getInt("rating");
			feedback = rs.getString("feedback");
			date = rs.getString("order_date");
			pickup = rs.getString("pickup");
			dest = rs.getString("dest");
			hiddenCust = rs.getBoolean("hidden_c");
			hiddenDriver = rs.getBoolean("hidden_d");
		} catch (Exception e) {
			e.printStackTrace();
			id = 0;
			idCustomer = 0;
			idDriver = 0;
			rating = 0;
			feedback = "";
			date = "0000-00-00";
			pickup = "";
			dest = "";
			hiddenDriver = false;
			hiddenCust = false;
		}
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

	public String getDate() {
		return date;
	}

	public String getPickUp() {
		return pickup;
	}

	public String getDestination() {
		return dest;
	}

	public boolean isHiddenCust() {
		return hiddenCust;
	}
	
	public boolean getHiddenCust() {
		return hiddenCust;
	}

	public boolean isHiddenDriver() {
		return hiddenDriver;
	}
	
	public boolean getHiddenDriver() {
		return hiddenDriver;
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

	public void setDate(String date) {
		this.date = date;
	}

	public void setPickUp(String pickup) {
		this.pickup = pickup;
	}

	public void setDestination(String dest) {
		this.dest = dest;
	}

	public void setHiddenCust(boolean hiddenCust) {
		this.hiddenCust = hiddenCust;
	}

	public void setHiddenDriver(boolean hiddenDriver) {
		this.hiddenDriver = hiddenDriver;
	}
}