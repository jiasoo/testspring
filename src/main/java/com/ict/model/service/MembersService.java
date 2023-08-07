package com.ict.model.service;

import java.util.List;

import com.ict.model.vo.MembersVO;

public interface MembersService {
	// 전체 보기 
	List<MembersVO> membersList();
	
	// 삽입
	int memberAdd(MembersVO mvo);
}
