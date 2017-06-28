package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Member;


public class MemberDao {

	private static MemberDao instance;
	public static MemberDao getInstance(){
		if(instance == null){
			instance = new MemberDao();
		}
		return instance;
	}
private MemberDao(){
		
	}

public void insertMember(Member member){
	String sql = "insert into member1(id,pw,name,email) "
			+ "values (?,?,?,?)";
			
	Connection connection = null;
	PreparedStatement pstmt = null;
	
	
	try {
		connection = ConnectionProvider.getConnection();
		pstmt = connection.prepareStatement(sql);
		
		pstmt.setString(1,member.getId());
		pstmt.setString(2,member.getPw());
		pstmt.setString(3,member.getName());
		pstmt.setString(4,member.getEmail());

		
		pstmt.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally{
		JdbcUtil.close(connection);
		JdbcUtil.close(pstmt);
	}
}

public Member selectOneMember(String id){
	//커넥션 얻어오고,sql 작성하고, 구문객체 얻어오고, 쿼리 실행
	Connection connection = null;
	String sql = "select * from member1 where id = ?";
	ResultSet rs =null; //결과 받을 준비
	PreparedStatement pstmt = null; //sql 전송 을 위한 구문객체
	Member member = null;
	try {
		connection = ConnectionProvider.getConnection();
		
		pstmt = connection.prepareStatement(sql);
		
		pstmt.setString(1, id);
		
		rs = pstmt.executeQuery();
		
		if(rs.next()){
			
			member = new Member();
			
			member.setEmail(rs.getString("email"));
			member.setName(rs.getString("name"));
			member.setPw(rs.getString("pw"));
		
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		JdbcUtil.close(connection);
		JdbcUtil.close(pstmt);
		JdbcUtil.close(rs);
	}
	return member;
}




	
}
