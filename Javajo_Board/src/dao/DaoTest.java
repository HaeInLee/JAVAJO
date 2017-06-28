package dao;

import java.util.List;

import model.Board;

public class DaoTest {
	public static void main(String[] args) {
		BoardDao dao = BoardDao.getInstance();
		List<Board> list = dao.selectAllBoard();
		
		for(Board b : list){
			System.out.println(b);
		}
	}
}
