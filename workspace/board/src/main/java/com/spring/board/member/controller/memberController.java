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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.board.member.dto.memberDTO;
import com.spring.board.member.service.memberService;

@Controller
@RequestMapping("member")
public class memberController {
	
	@Autowired
	memberService memberService;
	
	
//	테스트용 지울것!
	@RequestMapping("/list.do")
	public String view(Model model) {
		List<memberDTO> list = memberService.memberList();
		
		model.addAttribute("list",list);
		
		return "member/list";
	}
	
//	
	@RequestMapping(value="/join.do")
	public String gojoin(memberDTO dto) {
		
	
		
		return "member/join";
				
	}
	
	@RequestMapping(value="/memberjoin", method = RequestMethod.POST)
	public String memberReg(@Valid memberDTO dto , BindingResult result) {
		
		if( result.hasErrors() ) {

			// 에러를 List로 저장
			List<ObjectError> list = result.getAllErrors();
			for( ObjectError error : list ) {
				System.out.println(error + "ㅋㅋ");
			}
			return "/member/join";
		}
		
		
		memberService.memberInsert(dto);
		
		return "redirect:/";
				
	}
	
	@RequestMapping(value="/login.do")
	public String gologin(memberDTO dto) {
		
	
		
		return "member/login";
				
	}
	
	@RequestMapping(value="/memberlogin" , method = RequestMethod.POST)
	public String login(memberDTO dto, HttpServletRequest request, RedirectAttributes rttr) throws Exception{
		
		HttpSession session = request.getSession();
		String loginCheck = memberService.login(dto);
		  if(loginCheck== null) {
			  System.out.println("로그인실패");
		  session.setAttribute("member", null); 
		  rttr.addFlashAttribute("msg",false);
		  
		  } else {
			  System.out.println("로그인 성공"); 
			  session.setAttribute("member", loginCheck);	  
		  }
		  System.out.println(session);
		 
		
		return "board/index";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception{
		
		session.invalidate();
		
		return "redirect:/";
	}
}
