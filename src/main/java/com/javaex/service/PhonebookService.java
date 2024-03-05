package com.javaex.service;

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
}
