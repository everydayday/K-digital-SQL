package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Statement1 {

	public static void main(String[] args) {
		Connection con = null;
		
		String driver = "com.mysql.cj.jdbc.Driver";
		
		try {
			Class.forName(driver);
			
			
			String url = "jdbc:mysql://localhost::3306/world";
			String username = "scott";
			String password = "tiger";
			
			con = DriverManager.getConnection(url, username, password);
			Statement st =con.createStatement();
			ResultSet rs = st.executeQuery("select * from city");
			ResultSet rs2 = st.executeQuery("select * from country");
			ResultSet rs3 = st.executeQuery("select * from countrylanguage");
		
		while(rs.next()) {
//			System.out.println(rs.get + ",");
		}
		
		rs.close();
		st.close();
		con.close();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
