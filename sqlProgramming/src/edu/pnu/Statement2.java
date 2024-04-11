package edu.pnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Statement2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/world";
			String username = "scott";
			String password = "tiger";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url,username,password);
			
			st = con.createStatement();
			rs = st.executeQuery("select name from city where countrycode='kor' order by population desc");
			
			ResultSetMetaData meta = rs.getMetaData(); 
			rs.next();
			for(int i = 1; i <=count; i++, rs.next()) {	// row 갯수.. row만 출력하려면..
				rs.next();
				System.out.print(rs.getString(1) + ((i == count) ? "" : ","));
									
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			System.out.println("연결 실패 :" + e.getMessage());
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			}
			catch (Exception e) {
				// TODO: handle exception
				
			}
			
		}

	}

}
