package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Test1 {
	public static void main(String[] args) {
		Connection con = null;
		
		
		
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/world";
			String username = "scott";
			String password = "tiger";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url,username,password);
		
			Statement st = con.createStatement();
//			ResultSet rs = st.executeQuery("use world; select name, population from city where CountryCode = 'KOR' order by population desc");
			
			
			ResultSet rs = st.executeQuery("select name, population from city where CountryCode = 'KOR' order by population desc");
			
		
			while(rs.next()) {
				System.out.print(rs.getString("Name") + ",");
				System.out.print(rs.getString("Population") + "\n");
				
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
