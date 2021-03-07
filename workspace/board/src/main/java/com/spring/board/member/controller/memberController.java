package com.spring.board.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.board.member.dto.memberDTO;
import com.spring.board.member.service.memberService;

@Controller
@RequestMapping("member")
public class memberController {
	
	@Autowired
	memberService memberService;
	
	@RequestMapping("/list.do")
	public String view(Model model) {
		List<memberDTO> list = memberService.memberList();
		
		model.addAttribute("list",list);
		
		return "member/list";
	}
	
	@RequestMapping(value="/join.do")
	public String join(memberDTO dto) {
		
	
		
		return "member/join";
				
	}
	
	@RequestMapping(value="/memberjoin", method = RequestMethod.POST)
	public String memberReg(memberDTO dto) {
		
		memberService.memberInsert(dto);
		
		return "redirect:/list";
				
	}
}
