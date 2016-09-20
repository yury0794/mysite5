package kr.ac.sungkyul.mysite.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.sungkyul.mysite.vo.AttachFileVo;
import kr.ac.sungkyul.mysite.vo.BoardVo;

@Repository
public class BBSDao {

	@Autowired
	private SqlSession sqlSession;

	public int insertBoard(BoardVo boardVo) {
		sqlSession.insert("bbs.insertBoard", boardVo);
		return boardVo.getNo();
	}

	public List<BoardVo> listBoard() {
		List<BoardVo> listBoard = sqlSession.selectList("bbs.listBoard");
		return listBoard;
	}

	public BoardVo readBoard(int no) {
		BoardVo boardVo = sqlSession.selectOne("bbs.readBoard", no);
		return boardVo;
	}

	public BoardVo modifyBoard(int no) {
		BoardVo boardVo = sqlSession.selectOne("bbs.readBoard", no);
		return boardVo;
	}

	public void update(BoardVo vo) {
		sqlSession.update("bbs.update", vo);
	}

	public void insertAttachFile(AttachFileVo attachFileVo) {
		sqlSession.insert("bbs.insertAttachFile", attachFileVo);
	}

	public AttachFileVo selectAttachFile(int no) {
		AttachFileVo attachFileVo = sqlSession.selectOne("bbs.selectAttachFileByNo", no);
		return attachFileVo;
	}
	
	public AttachFileVo selectAttachFileByFNO(int fNo) {
		AttachFileVo attachFileVo = sqlSession.selectOne("bbs.selectAttachFileByFNO", fNo);
		return attachFileVo;
	}
}