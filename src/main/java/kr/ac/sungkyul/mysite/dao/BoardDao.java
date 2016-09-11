package kr.ac.sungkyul.mysite.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.sungkyul.mysite.vo.BoardVo;

@Repository
public class BoardDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//글추가
	public void insertBoard(BoardVo boardVo){
		sqlSession.insert("board.insertBoard", boardVo);
	}
	
	//글리스트
	public List<BoardVo> listBoard(){
		return sqlSession.selectList("board.listBoard");
	}
	
	//글상세
	public BoardVo selectBoard(int no){
		return sqlSession.selectOne("board.selectBoard", no);
	}
	
	
	//글수정
	public void updateBoard(BoardVo boardVo){
		System.out.println(boardVo.toString());
		sqlSession.update("board.updateBoard", boardVo);
	}
	
}
