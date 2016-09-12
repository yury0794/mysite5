package kr.ac.sungkyul.mysite.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.sungkyul.mysite.vo.BoardVO;

@Repository
public class BBSDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public void insertBoard(BoardVO boardVo){
		sqlSession.insert("bbs.insertBoard", boardVo);
	}
	
	public List<BoardVO> listBoard(){
		return sqlSession.selectList("bbs.listBoard");
	}
	
	public BoardVO selectBoard(int no){
		return sqlSession.selectOne("bbs.selectBoard", no);
	}
	
	public void updateBoard(BoardVO boardVO){
		sqlSession.update("bbs.updateBoard", boardVO);
	}
	
	public void deleteBoard(int no){
		sqlSession.delete("bbs.deleteBoard", no);
	}
}
