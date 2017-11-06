package com.services;

import javax.xml.ws.Endpoint;

public class Publisher {

	public static void main(String[] args) {
		 Endpoint.publish("http://localhost:8001/WebService/User", new UserServiceImpl());
		 Endpoint.publish("http://localhost:8001/WebService/Location", new LocationServiceImpl());
		 Endpoint.publish("http://localhost:8001/WebService/History", new HistoryServiceImpl());
	}

}