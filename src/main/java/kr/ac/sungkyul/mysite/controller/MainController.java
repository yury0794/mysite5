package kr.ac.sungkyul.mysite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping( "/main" )
	public String index() {
		return "main/index";
	}
	
	@RequestMapping( "/main2" )
	public String index2() {
		return "main/index2";
	}
}
