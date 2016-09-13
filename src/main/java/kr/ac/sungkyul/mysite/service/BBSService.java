package kr.ac.sungkyul.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.sungkyul.mysite.dao.BBSDAO;
import kr.ac.sungkyul.mysite.vo.BoardVO;

@Service
public class BBSService {

	@Autowired
	private BBSDAO bbsDAO;
	
	@Transactional
	public void insertBoard(BoardVO boardVo) throws Exception {
		bbsDAO.insertBoard(boardVo);
	}
	
	public List<BoardVO> listBoard(){
	
		return bbsDAO.listBoard();
	}
	
	public BoardVO selectBoard(int no){
		return bbsDAO.selectBoard(no);
	}
	
	public void updateBoard(BoardVO boardVO){
		bbsDAO.updateBoard(boardVO);
	}

	public void deleteBoard(int no){
		bbsDAO.deleteBoard(no);
	}

}
