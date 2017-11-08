package com.services;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public interface TokenValidator  {
	public static Boolean validateToken(String token) {
		URL url = new URL ("http://localhost:7000/IdentityService/Validate");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		
		connection.setDoOutput(true);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
		connection.setRequestProperty("Content-Length", "" +  Integer.toString(token.length()));
		
		
		
	    connection.connect();
		
	}
}
