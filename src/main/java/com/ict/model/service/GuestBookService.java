package com.ict.model.service;

import java.util.List;

import com.ict.model.vo.GuestBookVO;

public interface GuestBookService {
	// 전체보기
	List<GuestBookVO> GuestBookList();
	// 삽입
	int GuestBookInsert(GuestBookVO gvo);
	// 상세보기
	GuestBookVO GuestBookOneList(String idx);
	// 수정
	int GuestBookUpdate(GuestBookVO gvo);
	// 삭제
	int GuestBookDelete(String idx);
}
