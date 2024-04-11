package edu.pnu;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class H2_test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		

		try(Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/.h2/sqlprg","sa","abcd")){
			if(!createTable(con)) return;
			
			
			PreparedStatement psmt = con.prepareStatement("insert into Member(username,password,birthyear) values(?,?,?)");
			PreparedStatement psmt2 = con.prepareStatement("insert into Board(title,content,id,visitcount) values(?,?,?,?)");
			
			for(int i = 1; i <= 5; i++) {
				psmt.setString(1, "user"+i);
				psmt.setString(2, "pass"+i);
				Random rnd = new Random();
				psmt.setInt(3, (rnd.nextInt(2000,2011)));
		
				
				
				
				
				for(int p = 1; p <= 10; p++) {
					Random rnd2 = new Random();
					psmt2.setString(1, "title" + i);
					psmt2.setString(2, "content" + i);
					psmt2.setInt(3, p);
					psmt2.setInt(4, rnd2.nextInt(100));
					
					int result2 = psmt2.executeUpdate();
					System.out.println("Board 테이블에 " + result2 + "개가 입력되었습니다.");
										
				}							
				int result = psmt.executeUpdate();				
				System.out.println("Member 테이블에 " + result + "개가 입력되었습니다.");
				
				
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static boolean createTable(Connection con) {
		Statement st = null;
		try {
			st = con.createStatement();
			st.execute("DROP TABLE MEMBER IF EXISTS");
			st.execute("CREATE TABLE MEMBER ("
					+ "id int NOT NULL AUTO_INCREMENT PRIMARY KEY,"
					+ "username varchar(10) NOT NULL,"
					+ "password varchar(10) NOT NULL,"
					+ "birthyear int NOT NULL,"
					+ "regidate date NOT NULL DEFAULT (curdate())) ");
			
			st.execute("DROP TABLE BOARD IF EXISTS ");
			st.execute("CREATE TABLE BOARD ("
			        + "num INT AUTO_INCREMENT PRIMARY KEY,"
			        + "title VARCHAR(200) NOT NULL,"
			        + "content VARCHAR(2000) NOT NULL,"
			        + "id INT NOT NULL,"
			        + "postdate DATE NOT NULL DEFAULT CURRENT_DATE(),"
			        + "visitcount INT DEFAULT 0)");
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (st != null) st.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
			
		return true;
			
		}
		
	
	
	
	

}
