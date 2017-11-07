package com.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.models.History;

@WebService(endpointInterface = "com.services.HistoryService")
public class HistoryServiceImpl implements HistoryService {

	@Override
	public History[] getHistoryAsCustomer(int id) {
		ArrayList<History> ans = new ArrayList<History>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// Setting up
			Class.forName("com.mysql.jdbc.Driver");
			
			// Open connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gaussianlord_main", "root", "");

			ps = conn.prepareStatement("SELECT * FROM orderhistory WHERE id_customer=?");
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
	public History[] getHistoryAsDriver(int id) {
		ArrayList<History> ans = new ArrayList<History>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// Setting up
			Class.forName("com.mysql.jdbc.Driver");
			
			// Open connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gaussianlord_main", "root", "");

			ps = conn.prepareStatement("SELECT * FROM orderhistory WHERE id_driver=?");
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
	public boolean hideHistoryAsDriver(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			// Setting up
			Class.forName("com.mysql.jdbc.Driver");
			
			// Open connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gaussianlord_main", "root", "");

			ps = conn.prepareStatement("UPDATE orderhistory SET hidden_d=? WHERE id_order=?");
			ps.setString(1, "true");
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
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean hideHistoryAsCustomer(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			// Setting up
			Class.forName("com.mysql.jdbc.Driver");
			
			// Open connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gaussianlord_main", "root", "");

			ps = conn.prepareStatement("UPDATE orderhistory SET hidden_c=? WHERE id_order=?");
			ps.setString(1, "true");
			ps.setString(2, String.valueOf(id));

			// Execute query
			ps.executeQuery();
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
	public boolean createHistory(History history) {
		
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
}