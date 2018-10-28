package com.services;

import javax.xml.ws.Endpoint;

public class Publisher {

	public static void main(String[] args) {
		 Endpoint.publish("http://localhost:8000/WebService/User", new UserServiceImpl());
		 Endpoint.publish("http://localhost:8000/WebService/Location", new LocationServiceImpl());
		 Endpoint.publish("http://localhost:8000/WebService/History", new HistoryServiceImpl());
	}

}