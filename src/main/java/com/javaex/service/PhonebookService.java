package com.javaex.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PhonebookDao;
import com.javaex.vo.PersonVo;

@Service
public class PhonebookService {
	@Autowired
	private PhonebookDao phonebookDao;
	//등록
	public int exeWrite(PersonVo personVo) {
		System.out.println("PhonebookService.exeWrite");
		
		//System.out.println(personVo);

		int count = phonebookDao.personInsert(personVo);
		
		return 1;
	}
	
	//리스트
	public List<PersonVo> exeList() {
		System.out.println("PhonebookService.exeList");
		//Dao가서 List받기
		List<PersonVo> personList = phonebookDao.personList();
		return personList;
	}
	//수정폼
	public Map<String, Object> exeMform(int no) {
		System.out.println("PhonebookService.exeMform");
		
		//Dao로 personId전달
		Map<String, Object> pMap =phonebookDao.personMform(no);
		
		return pMap;
	}
	
	//수정
	public void exeModify(PersonVo personVo) {
		System.out.println("PhonebookService.exeModify");
		
		//Dao로 전달
		phonebookDao.personModify(personVo);
	}
	
	//삭제
	public void exeDelete(int no) {
		System.out.println("PhonebookService.exeDelete");
		
		//Dao로 전달
		phonebookDao.personDelete(no);
	}
}
