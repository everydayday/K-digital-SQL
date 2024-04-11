package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Statement1_1 {

	public static void main(String[] args) throws Exception{
		String driver = "com.mysql.cj.jdbc.Driver";
		
		
		Class.forName(driver);				
		String url = "jdbc:mysql://localhost:3306/world";
		String username = "scott";
		String password = "tiger";
			
		Connection con = DriverManager.getConnection(url, username, password);
		getData(con,"country");
		getData(con,"city");
		con.close();
		
	}
	
	
	public static void getData(Connection con,String str) throws Exception{

		Statement st =con.createStatement();
		ResultSet rs = st.executeQuery("select * from " + str );

		ResultSetMetaData meta = rs.getMetaData(); // data에 대한 data
		int count = meta.getColumnCount();
		while(rs.next()) {
			for(int i = 1; i <= count ; i++)
				System.out.print(rs.getString(i) + ((i==count) ?"" : ","));
			System.out.println();
		}
		
		rs.close();
		st.close();	 
		
	}
	
}
