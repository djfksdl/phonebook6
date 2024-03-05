package com.javaex.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
		
		return "redirect:/list"; //리다이렉트
	}
	
	//리스트
	@RequestMapping(value="/list", method = {RequestMethod.GET , RequestMethod.POST})
	public String list(Model model) {
		System.out.println("PhonebookController.list");
		
		//서비스로 보내고 List받기
		List<PersonVo> personList= phonebookService.exeList();
		
		//리스트 model에 넣어주기
		model.addAttribute("pList", personList);
		
		return "list"; //포워드
		
	}
	//수정폼
	@RequestMapping(value="/mform", method = {RequestMethod.GET,RequestMethod.POST})
	public String mform(@RequestParam(value="no") int no, Model model) {//파라미터로 no받아오기
		System.out.println("PhonebookController.mform");
		
		//서비스로 no전달하고 map으로 받아오기
		Map<String, Object> pMap =phonebookService.exeMform(no);
		
		//model에 넣어주기
		model.addAttribute("pMap" ,pMap);
		
		return"modifyForm";//포워드
	}
	//수정
	@RequestMapping(value="/modify" ,method= {RequestMethod.GET, RequestMethod.POST})
	public String modify(@ModelAttribute PersonVo personVo) {//no,name,hp,company를 vo로 받아준다.
		System.out.println("PhonebookController.modify");
		//묶은값을 서비스로 전달
		phonebookService.exeModify(personVo);
		
		//리스트로 리다이렉트
		return "redirect:/list";
	}
	//삭제
	@RequestMapping(value="/delete", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@RequestParam(value="no") int no) {//no를 받아온다.
		System.out.println("PhonebookController.delete");
		
		//서비스로 no전달
		phonebookService.exeDelete(no);
		
		return "redirect:/list";//리스트로 리다이렉트
	}
}
