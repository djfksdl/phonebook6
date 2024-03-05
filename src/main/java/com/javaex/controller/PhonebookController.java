package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.PhonebookService;
import com.javaex.vo.PersonVo;

//어느패키지에 있는지 spring-servlet에 해줬어야했는데 여긴 안해도됨-주소매핑하기 위한 3가지 중 1
@Controller
public class PhonebookController {
	//필드
	@Autowired
	private PhonebookService phonebookService;
	
	//등록폼
	@RequestMapping(value="/writeform", method= {RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		System.out.println("PhonebookController.writeForm()");

		
		return "writeForm";
	}
	
	//등록
	@RequestMapping(value="/write", method= {RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute PersonVo personVo) {
		System.out.println("PhonebookController.write()");
		//System.out.println(personVo);
		
		phonebookService.exeWrite(personVo);
		
		return ""; //리다이렉트
	}
	
	//
}
