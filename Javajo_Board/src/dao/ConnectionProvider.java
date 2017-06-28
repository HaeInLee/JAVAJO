package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	//드라이버 로딩, 연결생성
	private static String URL = "jdbc:mysql://localhost:3306/ex";
	private static String USERNAME = "root";
	private static String PASSWORD = "test123";
	
	//연결 생성후 반환하는 메서드
	public static Connection getConnection() throws SQLException{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return DriverManager.getConnection(URL,USERNAME,PASSWORD);
	}
	
	
	
}
