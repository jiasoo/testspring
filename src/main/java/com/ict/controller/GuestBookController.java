package com.ict.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ict.model.service.GuestBookService;
import com.ict.model.vo.GuestBookVO;


// mvc에서 DB를 쓸 때 최종 목적은 정보를 검색해서 가져오기 위함
// 이과정은  Jsp=> controller=>Service =>DAO=>mapper=>DB
// 컨트롤러에서 modelandview 객체를ㄹ 만들어서
// 검색한 정보를 jsp에서 최종 출력함 

// controller 어노테이션 설정
// 스프링 컨테이너에서 자바 클래스들을 bean 객체로 등록해 활용하기 위함임 

@Controller
public class GuestBookController {
	//@Autowired : GuestbookService 클래스를 스프링 프레임 워크에서 사용하기 위해서 쓴다.
	//                              이 때 변수명은 GuestbookServiced 맨 앞글자를 소문자로 설정하면
	//                              GuestbookService 모든 메서드를 다 쓸 수 잇음
	
	// 원래 자바 코드로 GuestbookService의 메서드를 스려면
	// GuestbookService guestbookService = new GuestbookService()
	// 이렇게 객체 생성해야 쓸 수 있음
	
	@Autowired
	private GuestBookService guestBookService;
	
	@GetMapping("/guestbook_list.do")
	public ModelAndView getGuestBookList() {// 객체 생성 후 갈곳 저장 
		ModelAndView mv = new ModelAndView("guestbook/list");
		List<GuestBookVO> glist = guestBookService.GuestBookList();
		// 전체보기를 위한 guestbookService 클래스의 guestbookList() 메서드 호출
		// Controller=>Service=>DAO=>mapper=>DB에서 가져온 정보를 list 변수에 저장함
		// 자바에서 = 은 같ㅇ다가 아니다 저장한다는 뜻
		mv.addObject("glist",glist);// glist를 jsp에서 쓰기위해 "glist"라는 이름으로 저장
		return mv;// 갈곳과 데이터를 저장해서 mv를 반환한다.(list.jsp로 가서 list라는 객체 데이터 전달)
	}
	// 그냥 단순 jsp로가는거라서 파라미터값 없음
	@GetMapping("/guestbookAddForm.do")
	public ModelAndView getguestbookAddForm() {
		return new ModelAndView("guestbook/write");
	}
	// write.jsp에서 받은 파라미터를 토대로 실질적 일처리
	@PostMapping("/guestbook_writeOK.do")
	public ModelAndView getguestbookInsertOK(GuestBookVO gvo) {
		// 인자값으로 GuestbookVO를 받아서 안에 잇는 getter/setter메서드를 활용할 수 있다.
		// ***** 스프링에서는 인자값으로 vo를 받으면 jsp에서 보낸 파라미터를 자동 매핑 시켜준다.******
		// 쉽게 말해서 파라미터는 그냥 vo스면 된다.
		ModelAndView mv = new ModelAndView("redirect:/guestbook_list.do");
										//리다이렉츠 : 기존의 request(파라미터)를 끊고 새로운 request을 보냄
										//           쉽게 말하면 글 다 썻으면 전체 목록을 보여주기 위함
		int result = guestBookService.GuestBookInsert(gvo);
		mv.addObject("result",result);
		return mv;
	}
	@GetMapping("/guestbook_onelist.do")
	public ModelAndView getGuestBookOneList(GuestBookVO gvo) {
		// 인자 값으로 GuestBookOneList를 받아 안에 잇는 getter/setter메서드를 활용할 수있다.
		// ***** 스프링에서는 인자값으로 vo를 받으면 jsp에서 보낸 파ㅠㅏ미터를 자동 매핑 시켜준다.*****
		
		ModelAndView mv = new ModelAndView("guestbook/onelist"); // mv 객체 생성 후 갈 곳 저장
		GuestBookVO vo = guestBookService.GuestBookOneList(gvo.getIdx());
		// DB로 가서 한줄 검색 후 가져옴
		mv.addObject("vo",vo);
		return mv;
	}
	@PostMapping("/guestbook_edit.Form.do")
	public ModelAndView getUpdate(GuestBookVO gvo) {
		ModelAndView mv = new ModelAndView();
		GuestBookVO vo = guestBookService.GuestBookOneList(gvo.getIdx());
		// 업데이트 페이지를 가기 위해서는 onelist.jsp의 파라미터를 가지고 가야하는데
		// 이 정보를 가져가기 위해서는 onelist 메서드 실행 
		mv.addObject("gvo",gvo);
		return mv;
	}
	@PostMapping("/guestbook_updateok.do")
	public ModelAndView getGuestBookUpdateOK(GuestBookVO gvo) {
		guestBookService.GuestBookUpdate(gvo);
		return new ModelAndView();
		
	}
	@PostMapping("/guestbook_delete.Form.do")
	public ModelAndView getDelete(@ModelAttribute("idx")String idx) {
		ModelAndView mv = new ModelAndView("guestbook/delete");
		GuestBookVO vo = guestBookService.GuestBookOneList(idx);
		mv.addObject("vo",vo);
		return mv;
	}
	
	
		

	
}
