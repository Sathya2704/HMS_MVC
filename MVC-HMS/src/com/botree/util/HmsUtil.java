package com.botree.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class HmsUtil {

public static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms_db", "root", "Bsipl@123");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
		
	}
}
