package kr.ac.sungkyul.mysite.controller;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.sungkyul.mysite.service.BBSService;
import kr.ac.sungkyul.mysite.vo.BoardVO;

@Controller
@RequestMapping("/bbs")
public class BBSController {

	@Autowired
	private BBSService bbsService;

	// 쓰기폼
	@RequestMapping(value = "write", method = RequestMethod.GET)
	public String write() {

		return "board/write";
	}

	// 글등록
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String registerBoard(BoardVO boardVo) throws Exception {
		bbsService.insertBoard(boardVo);

		return "redirect:list";
	}

	// 리스트
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String listBoard(Model model) {
		List<BoardVO> listBoard = bbsService.listBoard();
		System.out.println(listBoard.toString());

		model.addAttribute("listBoard", listBoard);
		return "board/list";
	}

	// 상세
	@RequestMapping(value = "view", method = RequestMethod.GET)
	public String readBoard(int no, Model model) {
		BoardVO boardVO = bbsService.selectBoard(no);
		model.addAttribute("BoardVO", boardVO);
		
		return "board/view";
	}

	
	// 수정폼
	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public String modifyBoard(int no, Model model) {
		BoardVO boardVO = bbsService.selectBoard(no);
		model.addAttribute("BoardVO", boardVO);
		return "board/modify";
	}

	// 수정
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String modifyBoard(BoardVO boardVO) {
		bbsService.updateBoard(boardVO);
		return "redirect:list";
	}

	// 삭제
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String modifyBoard(int no) {
		System.out.println(no);
		bbsService.deleteBoard(no);
		return "redirect:list";
	}

	
	
	
}
