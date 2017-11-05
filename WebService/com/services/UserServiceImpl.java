package com.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.jws.WebService;

import com.models.User;

@WebService(endpointInterface = "com.services.UserService")
public class UserServiceImpl implements UserService {

	@Override
	public User getUser(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// Setting up
			Class.forName("com.mysql.jdbc.Driver");
			
			// Open connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gaussianlord_main", "root", "");

			ps = conn.prepareStatement("SELECT * FROM user WHERE id=?");
			ps.setString(1, String.valueOf(id));

			// Execute query
			rs = ps.executeQuery();
			if (!rs.isBeforeFirst()) { // rs is empty
				return new User();
			} else {
				return new User(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
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
		return new User();
	}
}