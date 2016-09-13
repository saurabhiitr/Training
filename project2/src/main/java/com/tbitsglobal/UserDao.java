package com.tbitsglobal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "submit")
public class UserDao {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/training";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "mysql";
	static User usr;

	public void input() {
		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();

			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date();

			System.out.println(dateFormat.format(date)); // 2014/08/06 15:59:48
			String sql;
			sql = "INSERT INTO user( firstname,lastname,date) VALUES ( \"" + usr.getFirstname() + "\" , \""
					+ usr.getLastname() + "\" , \"" + new SimpleDateFormat("yyyy-MM-dd").format(date) + "\" )";
			PreparedStatement stmt1 = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			// stmt1.setInt(1, id);

			// stmt1.setString(2,);
			// stmt1.setString(3, usr.getLastname());
			// stmt1.setString(4, new
			// SimpleDateFormat("yyyy/MM/dd").format(date));
//			stmt1.execute();
			int generatedkey=0;
			stmt1.executeUpdate();
			ResultSet rs=stmt1.getGeneratedKeys();
		    if (rs.next()) {
		       generatedkey=rs.getInt(1);
		    }
			sql = "INSERT INTO detail(id,dob,gender,city,state,pincode,description) VALUES ( ?,\"" + new SimpleDateFormat("yyyy-MM-dd").format(usr.getDob()) + "\",?,?,?,?,?)";
			PreparedStatement stmt2 = conn.prepareStatement(sql);
			stmt2.setInt(1, generatedkey);
//			stmt2.setDate(2, ));
			stmt2.setString(2, usr.getGender());
			stmt2.setString(3, usr.getCity());
			stmt2.setString(4, usr.getState());
			stmt2.setString(5, usr.getPostalCode());
			stmt2.setString(6, usr.getText());
			stmt2.execute();
			// STEP 5: Clean-up environment
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		System.out.println("Goodbye!");
	}
}
