package edu.pnu;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class H2_test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		
		//
		try(Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/.h2/sqlprg","sa","abcd")){
			Random rnd = new Random();
			
			// =========== 데이터 수정/삭제 ============ 
			// 1
//			int num1 = rnd.nextInt(1,51);
//			PreparedStatement psmt = con.prepareStatement("DELETE FROM `BOARD` WHERE (`NUM` = " + num1 + ");");
//			int result = psmt.executeUpdate();	
//			System.out.println("Board 테이블에 " + result + "가 삭제되었습니다.");
			
			// 2
//			int num2 = rnd.nextInt(1,51);
//			PreparedStatement psmt2 = con.prepareStatement("UPDATE `board` SET `title` = 'title99', `content` = 'content99' WHERE (`NUM` = "+num2+");");
//			int result2 = psmt2.executeUpdate();	
//			System.out.println("Board 테이블에 " + result2 + "가 수정되었습니다.");
					
			// 3
//			int num3 = rnd.nextInt(1,51);
//			PreparedStatement psmt3 = con.prepareStatement("DELETE FROM `BOARD` WHERE (`NUM` = " + num3 + ");");
//			int result3 = psmt3.executeUpdate();	
//			System.out.println("Board 테이블에 " + result3 + "가 삭제되었습니다.");
			
			// 4
//			int id = rnd.nextInt(1,6);
//			PreparedStatement psmt4 = con.prepareStatement("UPDATE `MEMBER` SET `username` = 'username99', `password` = 'pass99' WHERE (`ID` = "+id+");");
//			int result4 = psmt4.executeUpdate();	
//			System.out.println("Member 테이블에 " + result4 + "가 수정되었습니다.");
			
			// ======= 조회 ======== //
			// 1
//			PreparedStatement pt = con.prepareStatement("select * from member");
//			ResultSet rs = pt.executeQuery();
//			
//			while(rs.next()) {
//				System.out.print(rs.getInt("id") + ",");
//				System.out.print(rs.getString("username") + ",");
//				System.out.print(rs.getString("password") + ",");
//				System.out.print(rs.getString("birthyear") + ",");
//				System.out.print(rs.getString("regidate") + "\n");
//				
//			}
//			
//			rs.close();
//			pt.close();
//			con.close();
			
			
			// 2
				
			int num = 0;
			while(true) {
				
				try {
					
					PreparedStatement pt = con.prepareStatement("select * from board limit " + num +",5");
					ResultSet rs = pt.executeQuery();		
					ResultSetMetaData meta = rs.getMetaData();
//					int col = meta.getrow();
					
					System.out.print(rs.getInt("num") + ",");
					System.out.print(rs.getString("title") + ",");
					System.out.print(rs.getString("content") + ",");
					System.out.print(rs.getString("id") + ",");
					System.out.print(rs.getString("postdate") + ",");
					System.out.print(rs.getString("visitcount") + "\n");
					System.out.println("-".repeat(30));
					num += 5;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					
					System.out.println("finished");
					break;
				}
				
				
			}
			
			// 3
//			PreparedStatement pt = con.prepareStatement("select * from board join member board.id");
//			ResultSet rs = pt.executeQuery();
//			
//			int i = 0;
//			while(rs.next()) {
//				System.out.print(rs.getInt("num") + ",");
//				System.out.print(rs.getString("title") + ",");
//				System.out.print(rs.getString("content") + ",");
//				System.out.print(rs.getString("id") + ",");
//				System.out.print(rs.getString("postdate") + ",");
//				System.out.print(rs.getString("visitcount") + "\n");
//				i ++;
//				if(i == 5) {
//					System.out.println("-".repeat(35));
//					i = 0;
//				}
//				
//			}
			
			
			
			
			
			
			
			
			
			con.close();
			
			
			
			
			
			
			
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
