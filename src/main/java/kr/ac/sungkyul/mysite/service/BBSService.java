package kr.ac.sungkyul.mysite.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.sungkyul.mysite.dao.BBSDAO;
import kr.ac.sungkyul.mysite.vo.AttachFileVO;
import kr.ac.sungkyul.mysite.vo.BoardVO;

@Service
public class BBSService {

	@Autowired
	private BBSDAO bbsDAO;
	
	@Transactional
	public void insertBoard(BoardVO boardVo, MultipartFile file) throws Exception {
		
		//2.no-->게시글저장할때
		int no = bbsDAO.insertBoard(boardVo);
		
		//1.fno-->저장할때

		//3.orgName
		String orgName =file.getOriginalFilename();
		
		//4.fileSize
		long fileSize =file.getSize();
		
		//5.saveName
		String saveName = UUID.randomUUID().toString()+ "_" + orgName;
		
		//6.path
		String path ="c:\\upload";
		
		AttachFileVO attachFileVO = new AttachFileVO();
		attachFileVO.setNo(no);
		attachFileVO.setPath(path);
		attachFileVO.setOrgName(orgName);
		attachFileVO.setSaveName(saveName);
		attachFileVO.setFileSize(fileSize);

		System.out.println(attachFileVO.toString());
		
		bbsDAO.insertAttachFile(attachFileVO);
		
		
		File target = new File(path, saveName);
		FileCopyUtils.copy(file.getBytes(),target);
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

	public AttachFileVO selectAttachFileByNO(int no){
		return bbsDAO.selectAttachFileByNO(no);
	}
	
	
	public AttachFileVO selectAttachFileByFNO(int fNO){
		return bbsDAO.selectAttachFileByFNO(fNO);
	}
}
