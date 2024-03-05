package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhonebookDao {
	
	@Autowired
	private SqlSession sqlSession;
	//등록
	public int personInsert(PersonVo personVo) {
		System.out.println("PhonebookDao.personInsert");
		System.out.println(personVo);
		
		int count = sqlSession.insert("phonebook.insert",personVo);
		System.out.println(count);
			
		return count;
	}
}
