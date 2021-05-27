package com.spring.board.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.board.member.dto.memberDTO;
import com.spring.board.member.service.memberService;

@Controller
@RequestMapping("member")
public class memberController {
	
	@Autowired
	memberService memberService;
	
	

//
	@RequestMapping(value="/join.do")
	public String gojoin(memberDTO dto) {
		
	
		
		return "member/join";
				
	}
	
	@RequestMapping(value="/memberJoin", method = RequestMethod.POST)
	public String memberReg(@ModelAttribute @Valid memberDTO dto , BindingResult result)  throws Exception {
		
		//에러가 있는지 검사
		if( result.hasErrors() ) {

			// 에러를 List로 저장
			List<ObjectError> list = result.getAllErrors();
			for( ObjectError error : list ) {
				System.out.println("에러 목록 : "  + error);
			}
			return "member/join";
		}
		
		
		memberService.memberInsert(dto);
		
		return "redirect:/";
				
	}
	
	@RequestMapping(value="/login.do")
	public String gologin(memberDTO dto) {
		
	
		
		return "member/login";
				
	}
	
	@RequestMapping(value="/memberLogin" , method = RequestMethod.POST)
	public String login(@ModelAttribute @Valid memberDTO dto, BindingResult result, HttpServletRequest request, RedirectAttributes rttr) throws Exception{
		
		int memberIdCheck = memberService.memberLoginCheck(dto.getMemberId());
		HttpSession session = request.getSession();
		if(memberIdCheck == 0) {
			  session.setAttribute("member", null);
			  rttr.addFlashAttribute("msg",false);
			  return "redirect:/member/login.do";
		}
		
		String loginCheck = memberService.login(dto);
		String memberName = memberService.memberLoginName(dto);
		  if(loginCheck== null) {
			  System.out.println("로그인실패");
		  session.setAttribute("member", null);
		  rttr.addFlashAttribute("msg",false);
		  return "redirect:/member/login.do";
		  
		  } else {
			  System.out.println("로그인 성공"); 
			  session.setAttribute("member", memberName);
			  return "redirect:/";
		  }
		
		
		
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception{
		
		session.invalidate();
		
		return "redirect:/";
	}
}
