package kr.ac.sungkyul.mysite.controller;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.sungkyul.mysite.service.BBSService;
import kr.ac.sungkyul.mysite.vo.AttachFileVo;
import kr.ac.sungkyul.mysite.vo.BoardVo;

@Controller
@RequestMapping("bbs")
public class BBSController {

	@Autowired
	private BBSService bbsService;

	// 쓰기폼
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write() {
		return "board/write";
	}

	// 글등록
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerBoard(BoardVo boardVo, MultipartFile file) throws Exception{
		bbsService.insertBoard(boardVo, file);
		return "redirect:/bbs/list";
	}

	// 리스트
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listBoard(Model model) {
		List<BoardVo> listBoard = bbsService.listBoard();
		model.addAttribute("listBoard", listBoard);
		return "board/list";
	}

	// 상세
	@RequestMapping(value = "/view/{no}", method = RequestMethod.GET)
	public String readBoard(@PathVariable("no") int no, Model model) {
		BoardVo vo = bbsService.readBoard(no);
		AttachFileVo fileVo = bbsService.selectAttachFile(no);
		model.addAttribute("vo", vo);
		model.addAttribute("fileVo", fileVo);
		return "board/view";
	}

	// 글수정 페이지
	@RequestMapping(value = "/modify/{no}", method = RequestMethod.GET)
	public String modifyBoard(@PathVariable("no") int no, Model model) {
		BoardVo vo = bbsService.readBoard(no);
		model.addAttribute("vo", vo);
		return "board/modify";
	}

	// 글수정
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(BoardVo vo) {
		bbsService.update(vo);
		return "redirect:/bbs/list";
	}
	
	// 파일 다운로드
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public void downloadFile(int fNo, HttpServletResponse res) throws Exception {
		System.out.println(fNo);
		AttachFileVo attachFileVO = bbsService.selectAttachFileByFNO(fNo);
		String saveName = attachFileVO.getSaveName();
		String orgName = attachFileVO.getOrgName();		    
		    
		res.setContentType("application/download");
		res.setHeader("Content-disposition", "attachment; filename=\"" + URLEncoder.encode(orgName,"UTF-8") +"\"");
		OutputStream resOut = res.getOutputStream();
		
		FileInputStream fin = new FileInputStream("C:\\upload\\"+saveName);
		FileCopyUtils.copy(fin, resOut);
		
		fin.close();		    
	}
}