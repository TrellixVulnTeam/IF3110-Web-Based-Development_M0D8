package com.services;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.json.JSONObject;

import com.models.History;

@WebService(endpointInterface = "com.services.HistoryService")
public class HistoryServiceImpl implements HistoryService {

	@Override
	public History[] getHistoryAsCustomer(String token, int id) throws TokenException{
		if (!TokenValidator.validateToken(token, id)) {
			throw new TokenException();
		}
		
		
		ArrayList<History> ans = new ArrayList<History>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// Setting up
			Class.forName("com.mysql.jdbc.Driver");
			
			// Open connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gaussianlord_main", "root", "");

			ps = conn.prepareStatement("SELECT * FROM orderhistory WHERE id_customer=? AND hidden_c=0");
			ps.setString(1, String.valueOf(id));

			// Execute query
			rs = ps.executeQuery();
			if (!rs.isBeforeFirst()) { // rs is empty
				
			} else {
				rs.next();
				while (!rs.isAfterLast()) {
					History his = new History(rs);
					ans.add(his);
					rs.next();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			ans.clear();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ans.toArray(new History[ans.size()]);
	}

	@Override
	public History[] getHistoryAsDriver(String token, int id) throws TokenException{
		if (!TokenValidator.validateToken(token, id)) {
			throw new TokenException();
		}
		
		ArrayList<History> ans = new ArrayList<History>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// Setting up
			Class.forName("com.mysql.jdbc.Driver");
			
			// Open connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gaussianlord_main", "root", "");

			ps = conn.prepareStatement("SELECT * FROM orderhistory WHERE id_driver=? AND hidden_d=0");
			ps.setString(1, String.valueOf(id));

			// Execute query
			rs = ps.executeQuery();
			if (!rs.isBeforeFirst()) { // rs is empty
				
			} else {
				rs.next();
				while (!rs.isAfterLast()) {
					History his = new History(rs);
					ans.add(his);
					rs.next();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			ans.clear();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ans.toArray(new History[ans.size()]);
	}

	@Override
	public boolean hideHistoryAsDriver(String token, int id)throws TokenException {
		if (!TokenValidator.validateToken(token, id)) {
			throw new TokenException();
		}
		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			// Setting up
			Class.forName("com.mysql.jdbc.Driver");
			
			// Open connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gaussianlord_main", "root", "");

			ps = conn.prepareStatement("UPDATE orderhistory SET hidden_d=1 WHERE id_order=?");
			ps.setString(1, String.valueOf(id));

			// Execute query
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean hideHistoryAsCustomer(String token, int id)throws TokenException {
		if (!TokenValidator.validateToken(token, id)) {
			throw new TokenException();
		}
		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			// Setting up
			Class.forName("com.mysql.jdbc.Driver");
			
			// Open connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gaussianlord_main", "root", "");

			ps = conn.prepareStatement("UPDATE orderhistory SET hidden_c=1 WHERE id_order=?");
			ps.setString(1, String.valueOf(id));

			// Execute query
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public boolean createHistory(String token, History history, int id) throws TokenException{
		if (!TokenValidator.validateToken(token, id)) {
			throw new TokenException();
		}
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// Setting up
			Class.forName("com.mysql.jdbc.Driver");
			
			// Open connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gaussianlord_main", "root", "");

			ps = conn.prepareStatement("insert into orderhistory (id_customer, id_driver, rating, feedback, order_date, pickup, dest) "
					+ "values(?,?,?,?,now(),?,?)");
			ps.setString(1, String.valueOf(history.getIdCustomer()));
			ps.setString(2, String.valueOf(history.getIdDriver()));
			ps.setString(3, String.valueOf(history.getRating()));
			ps.setString(4, history.getFeedback());
			ps.setString(5,  history.getPickUp());
			ps.setString(6,  history.getDestination());

			// Execute query
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public boolean updateCustomer(String token, int id, History history)throws TokenException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// Setting up
			Class.forName("com.mysql.jdbc.Driver");
			
			// Open connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gaussianlord_main", "root", "");
			
			String rating = String.valueOf(history.getRating());
			

			ps = conn.prepareStatement("UPDATE user SET star=((star*vote)+?)/(vote+1), vote=vote+1 WHERE id=?");
			ps.setString(1, rating);
			ps.setString(2, String.valueOf(id));

			// Execute query
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public String getValidation(String token, int id) {
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
		    
		    return status;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
}