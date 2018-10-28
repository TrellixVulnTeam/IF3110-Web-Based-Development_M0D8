package com.services;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONObject;

public interface TokenValidator  {
	public static Boolean validateToken(String token, int id) {
		try {
			URL url = new URL ("http://localhost:7000/IdentityService/Validate");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			String body = "{\"token\":\"" + token + "\",\"id\":" + id + "}";
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
			connection.setRequestProperty("Content-Length", "" +  Integer.toString(body.getBytes().length));
			
			DataOutputStream out = new DataOutputStream(connection.getOutputStream ());
		    out.writeBytes(body);
		    out.flush();
		    out.close();
			
		    connection.connect();
		    
		    String result;
		    BufferedInputStream bis = new BufferedInputStream(connection.getInputStream());
		    ByteArrayOutputStream buf = new ByteArrayOutputStream();
		    int result2 = bis.read();
		    while(result2 != -1) {
		        buf.write((byte) result2);
		        result2 = bis.read();
		    }
		    result = buf.toString();
		    JSONObject resultJSON = null;
		    String status = "";
		    try {
				resultJSON = new JSONObject(result);
				status = resultJSON.getString("token_status");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    if(status.equals("valid")) {
		    	try {
		    		// prolong expiry time in db
		    		// modify cookie expiry time
		    		
		    		return true;
		    		
					// Cookie cookieToken = new Cookie("token", token);
					// Cookie cookieExpiry = new Cookie("expiry", expiryTime);
					// response.addCookie(cookieToken);
					// response.addCookie(cookieExpiry);
		    	} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	
		    }
		    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
