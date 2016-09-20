package kr.ac.sungkyul.mysite.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.sungkyul.mysite.dao.BBSDao;
import kr.ac.sungkyul.mysite.vo.AttachFileVo;
import kr.ac.sungkyul.mysite.vo.BoardVo;

@Service
public class BBSService {

	@Autowired
	private BBSDao bbsDao;

	@Transactional
	public void insertBoard(BoardVo boardVo, MultipartFile file) throws Exception {
		// 파일 정보 vo 만들기
		// 1. fno -> 저장할때
		
		// 2. no -> 게시글 저장할 때
		int no = bbsDao.insertBoard(boardVo); // Dao에서 no를 받아온다
		
		// 3. orgName
		String orgName = file.getOriginalFilename();
		
		// 4. fileSize
		long fileSize = file.getSize();
		
		// 5. saveName
		String saveName = UUID.randomUUID().toString() + "_" + orgName;
		
		// 6. path
		String path = "c:\\upload";
		
		AttachFileVo attachFileVo = new AttachFileVo();
		attachFileVo.setNo(no);
		attachFileVo.setPath(path);
		attachFileVo.setOrgName(orgName);
		attachFileVo.setSaveName(saveName);
		attachFileVo.setFileSize(fileSize);
		
		bbsDao.insertAttachFile(attachFileVo);
		
		File target = new File(path, saveName);
		FileCopyUtils.copy(file.getBytes(), target);
	}

	public List<BoardVo> listBoard() {
		List<BoardVo> listBoard = bbsDao.listBoard();
		return listBoard;
	}

	public BoardVo readBoard(int no) {
		BoardVo boardVo = bbsDao.readBoard(no);
		return boardVo;
	}

	public BoardVo modifyBoard(int no) {
		BoardVo boardVo = bbsDao.readBoard(no);
		return boardVo;
	}

	public void update(BoardVo vo) {
		bbsDao.update(vo);
	}
	
	public AttachFileVo selectAttachFile(int no) {
		AttachFileVo attachFileVo = bbsDao.selectAttachFile(no);
		return attachFileVo;
	}
	
	public AttachFileVo selectAttachFileByFNO(int fNo) {
		AttachFileVo attachFileVo = bbsDao.selectAttachFileByFNO(fNo);
		return attachFileVo;
	}
}