package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	//자원 사용한 것들 예외처리해서..닫아주면됩니다..
	public static void close(ResultSet rs){
		if(rs != null){
			try{
				rs.close();
			}catch (Exception e) {
			}
		}
	}
	
	public static void close(Statement stmt){
		if(stmt != null){
			try{
				stmt.close();
			}catch (Exception e) {
			}
		}
	}
	
	public static void close(Connection connection){
		if(connection != null){
			try{
				connection.close();
			}catch (Exception e) {
			}
		}
	}
	
	public static void rollback(Connection connection){
		/* 데이터베이스에 쿼리를 실행하면...
		 * 데이터가 변경이 되는데..commit 작업전에는 데이터를 되돌릴 수 있음..
		 * 변경사항을 취소할 수 있다. >>rollback
		 * 트렌잭션 : 데이터 처리 단위 
		 * A =1, B=1 이라는 작업이 있을때 둘다 같이 처리 되어야 한다.
		 * 이를 트랜잭션이라고 부르고
		 * 하나만처리됐을때는 나머지 값은 rollback 한다.
		 * */
		
		if(connection !=null){
			try {
				connection.rollback();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		
	}	
}
