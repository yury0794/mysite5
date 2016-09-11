package kr.ac.sungkyul.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.sungkyul.mysite.dao.BoardDao;
import kr.ac.sungkyul.mysite.vo.BoardVo;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
	//게시물등록
	public void register(BoardVo boardVo){
		boardDao.insertBoard(boardVo);
	}
	
	//글리스트가져오기
	public List<BoardVo> listBoard(){
		return boardDao.listBoard();
	}
	
	//글한개가져오기
	public BoardVo selectBoard(int no){
		return boardDao.selectBoard(no);
	}
	
	//글수정하기
	public void updateBoard(BoardVo boardVo){
		boardDao.updateBoard(boardVo);
	}
}
