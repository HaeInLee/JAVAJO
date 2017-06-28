package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Board;

public class BoardDao {

	private static BoardDao instance;
	public static BoardDao getInstance(){
		if(instance == null){
			instance = new BoardDao();
		}
		return instance;
	}
	
	private BoardDao(){
		
	}
	

	public void insertBoard(Board board){
		String sql = "insert into board1(num,m_id,title,content,readcount,writedate) "
				+ "values (?,?,?,?,?,?)";
				
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		
		try {
			connection = ConnectionProvider.getConnection();
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setInt(1,board.getNum());
			pstmt.setString(2,board.getM_id());
			pstmt.setString(3,board.getTitle());
			pstmt.setString(4,board.getContent());
			pstmt.setInt(5,board.getReadCount());
			pstmt.setTimestamp(6, board.getWritedate());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JdbcUtil.close(connection);
			JdbcUtil.close(pstmt);
		}
	}
	
	public List<Board> selectAllBoard(){
		//커넥션 얻어오고,sql 작성하고, 구문객체 얻어오고, 쿼리 실행
		Connection connection = null;
		String sql = "select * from board1 order by num desc";
		ResultSet rs =null; //결과 받을 준비
		PreparedStatement pstmt = null; //sql 전송 을 위한 구문객체
		List<Board> result = new ArrayList<Board>(); //결과 저장할 리스트
		try {
			connection = ConnectionProvider.getConnection();
			
			pstmt = connection.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				Board board = new Board();
				
				board.setContent(rs.getString("content"));
				board.setM_id((rs.getString("m_id")));
				board.setNum(rs.getInt("num"));
				board.setReadCount(rs.getInt("readCount"));
				board.setTitle(rs.getString("title"));
				board.setWritedate(rs.getTimestamp("writedate"));
							
				result.add(board);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.close(connection);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(rs);
		}
		return result;
	}
	
}
