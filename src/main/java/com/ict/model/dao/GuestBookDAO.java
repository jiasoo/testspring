package com.ict.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.model.vo.GuestBookVO;

@Repository // DAO(Data Access Object, 데이터에 접근하는 객체)에 사용하는 컴포넌트
public class GuestBookDAO {
	@Autowired// root-context에서 설정한 bean 객체를 매핑시켜주기 위함
	private SqlSessionTemplate sqlSessionTemplate;
	// 리스트
	public List<GuestBookVO> GuestBookList(){// 반환 값이 List<GuestbookVO>메서드
		return sqlSessionTemplate.selectList("guestbook.list");     // 즐인것임
		
		// List<GuestbookVO> list = sqlSessionTemplate.selectList("guestbook.list);
		// return list;
	}
	// 글쓰기 
	public int GuestBookInsert(GuestBookVO gvo) {
		int result = sqlSessionTemplate.insert("guestbook.insert", gvo);
		return result;
	}
	// 상세보기
	public GuestBookVO GuestBookOneList(String idx) {
		return sqlSessionTemplate.selectOne("guestbook.onelist", idx);
	}
}
