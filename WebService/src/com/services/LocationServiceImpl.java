package com.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import javax.jws.WebService;

import com.models.Location;

@WebService(endpointInterface = "com.services.LocationService")
public class LocationServiceImpl implements LocationService {

	@Override
	public ArrayList<Location> getLocation(String token, int id) throws TokenException {
		if (!TokenValidator.validateToken(token, id)) {
			throw new TokenException();
		}
		
		ArrayList<Location> ans = new ArrayList<Location>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// Setting up
			Class.forName("com.mysql.jdbc.Driver");
			
			// Open connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gaussianlord_main", "root", "");

			ps = conn.prepareStatement("SELECT * FROM preferredlocation WHERE id=?");
			ps.setString(1, String.valueOf(id));

			// Execute query
			rs = ps.executeQuery();
			if (!rs.isBeforeFirst()) { // rs is empty
				
			} else {
				while (!rs.isAfterLast()) {
					rs.next();
					Location loc = new Location(rs.getString("location"));
					ans.add(loc);
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
		return ans;
	}

	@Override
	public boolean updateLocation(String token, int id, Location oldLoc, Location newLoc) throws TokenException {
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

			ps = conn.prepareStatement("UPDATE preferredlocation SET location=? WHERE location=? AND id=?");
			ps.setString(1, newLoc.getLocation());
			ps.setString(2, oldLoc.getLocation());
			ps.setString(3,  String.valueOf(id));

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
	public boolean deleteLocation(String token, int id, Location loc) throws TokenException {
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

			ps = conn.prepareStatement("DELETE FROM preferredlocation WHERE id=? AND location=?");
			ps.setString(1,  String.valueOf(id));
			ps.setString(2,  loc.getLocation());

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
	public boolean insertLocation(String token, int id, Location loc) throws TokenException {
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

			ps = conn.prepareStatement("INSERT INTO preferredlocation (id, location) VALUES (?,?)");
			ps.setString(1,  String.valueOf(id));
			ps.setString(2,  loc.getLocation());

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
}