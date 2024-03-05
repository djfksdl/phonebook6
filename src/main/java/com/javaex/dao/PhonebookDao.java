package com.javaex.dao;

import java.util.List;
import java.util.Map;

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
	
	//리스트
	public List<PersonVo> personList() {
		System.out.println("PhonebookDao.personList");
		
		//selectList로 리스트 받아오기
		List<PersonVo> personList = sqlSession.selectList("phonebook.selectList");
		
		return personList;
	}
	
	//수정폼
	public Map<String, Object> personMform(int no) {
		System.out.println("PhonebookDao.personMform");
		
		//selectOne으로 vo받아오기
		Map<String, Object> pMap = sqlSession.selectOne("phonebook.selectOne", no);
		//꺼내쓸때 키값(이름)을 보통 name,authUser같이 String으로 쓰기 때문에 앞에 써주고(꺼내주는거), Object는 데이터들(뭔지는 모르니까 오브젝트로 받기)(받는거)
		
		return pMap;
	}
	
	//수정
	public void personModify(PersonVo personVo) {
		System.out.println("PhonebookService.personModify");
		
		//update로 수정하기
		sqlSession.update("phonebook.update", personVo);
	}
	
	//삭제
	public void personDelete(int no) {
		System.out.println("PhonebookService.personDelete");
		
		//delete로 삭제하기
		sqlSession.delete("phonebook.delete", no);
	}
}
