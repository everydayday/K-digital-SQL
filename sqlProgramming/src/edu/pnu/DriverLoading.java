package edu.pnu;

public class DriverLoading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			Class.forName(driver);
			System.out.println("로딩 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("로딩 실패");
			System.out.println(e.getMessage());
			
		}
		
		
	}

}
