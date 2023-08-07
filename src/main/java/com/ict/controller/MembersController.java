package com.ict.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ict.model.service.MembersServiceImpl;
import com.ict.model.vo.MembersVO;

@Controller
public class MembersController {
	@Autowired
	private MembersServiceImpl membersService;
	@GetMapping("/members_list.do")
	public ModelAndView getModelAndView() {
		ModelAndView mv = new ModelAndView("members/list");
		List<MembersVO> list = membersService.membersList();
		mv.addObject("list",list);
		return mv;
	}
	@GetMapping("/members_addForm.do")
	public ModelAndView getMemdelAddForm() {
		return new ModelAndView("members/addForm");
	}
	@PostMapping("/members_addMembers.do")
	public ModelAndView getMemberAdd(MembersVO mvo) {
		ModelAndView mv = new ModelAndView("redirect:/members_list.do");
		int result = membersService.memberAdd(mvo);
		return mv;
	}
	
}
