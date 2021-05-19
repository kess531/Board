package com.spring.board.bulletin.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.board.bulletin.dto.bulletinDTO;
import com.spring.board.bulletin.dto.commentDTO;
import com.spring.board.bulletin.service.bulletinService;
import com.spring.board.bulletin.utill.Criteria;
import com.spring.board.bulletin.utill.CriteriaCmt;
import com.spring.board.bulletin.utill.PageMaker;
import com.spring.board.bulletin.utill.PageMakerCmt;

@Controller
@RequestMapping("bulletin")
public class bulletinController {
	@Autowired
	bulletinService bulletinservice;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String goview(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "redirect:/";
	}

	@RequestMapping(value = "/listView")
	public @ResponseBody HashMap<String, Object> listView(HttpServletRequest request,
		@ModelAttribute("cri") Criteria cri) throws IOException {
		HashMap<String, Object> map = new HashMap<String, Object>();
		PageMaker pagemaker = new PageMaker();
		pagemaker.setCri(cri);
		if (request.getParameter("keyword") == null) {
			List<bulletinDTO> list = bulletinservice.bulletinList(cri);		
			pagemaker.setTotalCount(bulletinservice.listCountCriteria()); // 총게시글 갯수
			System.out.println("펄페이지" + cri.getPerPageNum());
			map.put("pagemaker", pagemaker);
			map.put("list", list);
		}

		
		 else { 
	     if(request.getParameter("clsfcselect").equals("title")) {
		 List<bulletinDTO> list =bulletinservice.bulletinSearchTitle(cri);
		 pagemaker.setTotalCount(bulletinservice.listTitleCountCriteria(cri)); // 총게시글 갯수
		 map.put("pagemaker", pagemaker);
		 map.put("list", list); 
		 }
		 
		 else if(request.getParameter("clsfcselect").equals("writer")) { 
		 List<bulletinDTO> list = bulletinservice.bulletinSearchMember(cri);
		 pagemaker.setTotalCount(bulletinservice.listMemberCountCriteria(cri)); // 총게시글 갯수
		 map.put("pagemaker", pagemaker);
		 map.put("list", list); 
		 }
		 
		 else if(request.getParameter("clsfcselect").equals("content")) {
		 List<bulletinDTO> list = bulletinservice.bulletinSearchContent(cri);
		 pagemaker.setTotalCount(bulletinservice.listContentCountCriteria(cri)); // 총게시글 갯수
		 map.put("pagemaker", pagemaker);
		 map.put("list", list);  
		 } 
		 
		 else if(request.getParameter("clsfcselect").equals("total")) {
		 List<bulletinDTO> list = bulletinservice.bulletinSearchTotal(cri);
		 pagemaker.setTotalCount(bulletinservice.listTotalCountCriteria(cri)); // 총게시글 갯수
		 map.put("pagemaker", pagemaker);
		 map.put("list", list);  
		 } 
		 
		 else { 
		 System.out.println("검색실패"); } }
		 
		 
		return map;
	}
	
	@RequestMapping(value="/write.do")
	public String goWrite() {
		
		return "bulletin/write";
	}
	
	@RequestMapping(value="/contentWrite")
	public String contentWrite(bulletinDTO dto) throws Exception  {
		
		bulletinservice.bulletinWrite(dto);
		
		return "redirect:/";
		
	}
	@RequestMapping(value="/update.do")
	public String goUpdate(Model model, int bltNo) {
		List<bulletinDTO> contentView = bulletinservice.bulletinContentView(bltNo);
		model.addAttribute("contentView",contentView);
		return "bulletin/update";
	}
	@RequestMapping(value="/contentUpdate")
	public String contentUpdate(bulletinDTO dto) throws Exception  {
		
		bulletinservice.bulletinUpdate(dto);
		
		return "redirect:/";
		
	}
	@RequestMapping(value="/contentDelete")
	public String contentDelete(int bltNo) throws Exception  {
		System.out.println("글삭제" + bltNo);
		bulletinservice.bulletinDelete(bltNo);
		
		return "redirect:/";
		
	}
	
	@RequestMapping(value="/contentView")
	public String contentView
	(@RequestParam(value="bltNo", required = false) int bltNo,HttpServletRequest request, HttpServletResponse response, RedirectAttributes rttr,
		Model model, @ModelAttribute("cmt") CriteriaCmt cmt) throws Exception{
		System.out.println(bltNo);
		List<bulletinDTO> contentView = bulletinservice.bulletinContentView(bltNo);
		model.addAttribute("contentView",contentView);
		HttpSession session = request.getSession();
		
		String userName = (String)session.getAttribute("member");
		
		int cmtCount = bulletinservice.commentListCount(cmt.getBltNo()); // 총게시글 갯수
		model.addAttribute("cmtCount", cmtCount);
		if(userName==null) {
			 rttr.addFlashAttribute("msg",false);
			//model.addAttribute("msg", "11");
			return "redirect:/";
		}
		
		model.addAttribute("userName",userName);
		
		
		boolean isGet = false;
		Cookie[] cookies = request.getCookies();
		
		if(cookies!= null) {
			for (int i = 0; i < cookies.length; i++) {
				if(cookies[i].getName().equals("bltCnt"+bltNo))
				{
					System.out.println("처음 쿠키가 생성한 뒤 들어옴");
					isGet=true;
				}
			}
		}
		
		
		if(!isGet) {
		bulletinservice.bulletinViewCnt(bltNo);
		Cookie c1 = new Cookie("bltCnt"+bltNo, "bltCnt" + bltNo);
		c1.setMaxAge(1*24*60*60);
		response.addCookie(c1);
		}
		
		return "bulletin/contentView";
	}
	
	@RequestMapping(value="/commentList")
	public @ResponseBody HashMap<String, Object> commentList(@RequestParam(value="bltNo", required = false) int bltNo,HttpServletRequest request, HttpServletResponse response,
	Model model, @ModelAttribute("cmt") CriteriaCmt cmt) throws Exception{
		//댓글
				HashMap<String, Object> map = new HashMap<String, Object>();
				PageMakerCmt pagemaker = new PageMakerCmt();
				pagemaker.setCmt(cmt);
				
					cmt.setBltNo(bltNo);
					List<commentDTO> list = bulletinservice.commentList(cmt);		
					pagemaker.setTotalCount(bulletinservice.commentListCount(cmt.getBltNo())); // 총게시글 갯수
					map.put("pagemaker", pagemaker);
					map.put("list", list);
					System.out.println("댓글" + map);
		return map;
	}
	
	
	@RequestMapping(value="/contentLike")
	public String contentLike(int bltNo, HttpServletRequest request, HttpServletResponse response,RedirectAttributes redirectAttributes) throws Exception {
	
		
		boolean isGet = false;
		Cookie[] cookies = request.getCookies();
		
		if(cookies!= null) {
			for (int i = 0; i < cookies.length; i++) {
				if(cookies[i].getName().equals("blt"+bltNo))
				{
					System.out.println("처음 쿠키가 생성한 뒤 들어옴");
					isGet=true;
				
				}
			}
		}
		
		
		if(!isGet) {
		bulletinservice.bulletinLikeCnt(bltNo);
		Cookie c1 = new Cookie("blt"+bltNo, "blt" + bltNo);
		c1.setMaxAge(1*24*60*60);
		response.addCookie(c1);
		}
		redirectAttributes.addFlashAttribute("bltNo",bltNo);
		String referer =request.getHeader("Referer");
		return "redirect:" + referer;
	}
	
	@RequestMapping(value="/commnetWrite")
	public String commnetWrite(commentDTO dto,HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
		bulletinservice.commentWrite(dto);
		
		redirectAttributes.addFlashAttribute("bltNo",dto.getBltNo());
		String referer =request.getHeader("Referer");
		return "redirect:" + referer;
		
	}
	
	@RequestMapping(value="/commentDelete")
	public String commentDelte(int cmtNo,Model model,HttpServletRequest request, RedirectAttributes redirectAttributes) {

		


		bulletinservice.commentDelete(cmtNo);
		String referer =request.getHeader("Referer");
		return "redirect:" + referer;
	}

	@RequestMapping(value="/commentPwdSelect")
	public @ResponseBody HashMap<String, Object> commentPwdSelect(int cmtNo,HttpServletRequest request, Model model) throws Exception{
		
				HashMap<String, Object> map = new HashMap<String, Object>();
				
					String cmtPwd = bulletinservice.commentPwdSelect(cmtNo);	
					
					map.put("cmtPwd", cmtPwd);
					
		return map;
	}
	

}
