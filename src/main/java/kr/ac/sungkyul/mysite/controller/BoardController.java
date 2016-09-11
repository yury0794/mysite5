package kr.ac.sungkyul.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.sungkyul.mysite.service.BoardService;
import kr.ac.sungkyul.mysite.vo.BoardVo;


@Controller
@RequestMapping( "/board" )
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="write", method=RequestMethod.GET)
	public String write(){
		return "board/write";
	}
	
	@RequestMapping(value="register", method=RequestMethod.POST)
	public String register(BoardVo boardVo, MultipartFile file, MultipartFile file1){
		//boardService.register(boardVo);
		System.out.println(boardVo.toString());
		System.out.println(file.getOriginalFilename());
		System.out.println(file1.getOriginalFilename());
		return "redirect:list";
	}
	
	@RequestMapping( value="/list",  method=RequestMethod.GET)
	public String list(Model model){
		List<BoardVo> boardList = boardService.listBoard();
		model.addAttribute("boardList", boardList );	
		return "board/list";
	}
	
	@RequestMapping( value="/view",  method=RequestMethod.GET)
	public String view(int no, Model model){
		BoardVo boardVo = boardService.selectBoard(no);
		model.addAttribute("boardVo", boardVo);
		return "board/view";
	}
	
	@RequestMapping( value="/modify",  method=RequestMethod.GET)
	public String modify(int no, Model model){
		BoardVo boardVo = boardService.selectBoard(no);
		model.addAttribute("boardVo", boardVo);
		return "board/modify";
	}	
	

	@RequestMapping( value="/update",  method=RequestMethod.POST)
	public String update(BoardVo boardVo){
		System.out.println(boardVo.toString());
		boardService.updateBoard(boardVo);
		return "redirect:list";
	}	
	
	
}
