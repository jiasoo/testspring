package com.ict.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.model.dao.GuestBookDAO;
import com.ict.model.vo.GuestBookVO;

@Service
public class GuestBookServiceImpl implements GuestBookService{
	//@Autowired :guestbookDAO 클래스를 스프링 프레임 워크에서 사용하기 위해서 쓴다.
	//                         이때 변수명은 GuestbookDAO 맨 앞글자를 소문자로 설정하면 (guestbookDAO)
	//                         GuestbookDAO 모든 메서드를 다 쓸 수 있음
	
	// 원래 자바 코드로 GuestbookDAO의 메서드를 쓰려면
	// GuestbookDAO guestbookDAO = new GuestbookDAO(
	// 이렁게 객체 생성해야 쓸 수 잇음
	
	@Autowired
	private GuestBookDAO guestBookDAO;
	
	@Override // GuestbookServiceImpl은 GuestboookService를 상속받는 클래스 이므로 
							// GuestbookService 모든 메서드를 써야한다.
							// http://www.tcpschool.com/java/java_inheritance_overriding 내용참고
	public List<GuestBookVO> GuestBookList() {	
		// List<GuestbookVO> list = guestbookDAO.guestbooklist();
		// return list;
		return guestBookDAO.GuestBookList();
	}
	@Override
	public int GuestBookUpdate(GuestBookVO gvo) {
		
		return guestBookDAO.GuestBookUpdate(gvo);
	}

	@Override
	public int GuestBookDelete(String idx) {
		return guestBookDAO.GuestBookDelete(idx);
	}


	@Override
	public int GuestBookInsert(GuestBookVO gvo) {
		int result = guestBookDAO.GuestBookInsert(gvo);
		return result;
		
	}

	@Override
	public GuestBookVO GuestBookOneList(String idx) {		
		return guestBookDAO.GuestBookOneList(idx);
	}

}
