package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/mysql";
			String username = "scott";
			String password = "tiger";
			
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,username,password);
			
			Statement st = con.createStatement();
			
			System.out.println("연결성공");
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println();
		} 
	
	
	}

}
