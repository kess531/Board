package com.spring.board.bulletin.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.board.bulletin.dto.bulletinDTO;
import com.spring.board.bulletin.service.bulletinService;
import com.spring.board.bulletin.utill.Criteria;
import com.spring.board.bulletin.utill.PageMaker;

@Controller
@RequestMapping("bulletin")
public class bulletinController {
	@Autowired
	bulletinService bulletinservice;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goview(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "board/index";
	}

	@RequestMapping(value = "/listView")
	public @ResponseBody HashMap<String, Object> listView(HttpServletRequest request,
			@ModelAttribute("cri") Criteria cri) throws IOException {
		HashMap<String, Object> map = new HashMap<String, Object>();
		PageMaker pagemaker = new PageMaker();
		pagemaker.setCri(cri);
		if (request.getParameter("keyword") == null) {
			List<bulletinDTO> list = bulletinservice.bulletinList(cri);		
			pagemaker.setTotalCount(bulletinservice.listCountCriteria()); // ÃÑ°Ô½Ã±Û °¹¼ö
			map.put("pagemaker", pagemaker);
			map.put("list", list);
		}

		
		 else { 
	     if(request.getParameter("clsfcselect").equals("title")) {
		 List<bulletinDTO> list =bulletinservice.bulletinSearchTitle(cri);
		 pagemaker.setTotalCount(bulletinservice.listTitleCountCriteria(cri)); // ÃÑ°Ô½Ã±Û °¹¼ö
		 map.put("pagemaker", pagemaker);
		 map.put("list", list); 
		 }
		 
		 else if(request.getParameter("clsfcselect").equals("writer")) { 
		 List<bulletinDTO> list = bulletinservice.bulletinSearchMember(cri);
		 pagemaker.setTotalCount(bulletinservice.listMemberCountCriteria(cri)); // ÃÑ°Ô½Ã±Û °¹¼ö
		 map.put("pagemaker", pagemaker);
		 map.put("list", list); 
		 }
		 
		 else if(request.getParameter("clsfcselect").equals("content")) {
		 List<bulletinDTO>
		 list = bulletinservice.bulletinSearchContent(cri);
		 pagemaker.setTotalCount(bulletinservice.listContentCountCriteria(cri)); // ÃÑ°Ô½Ã±Û °¹¼ö
		 map.put("pagemaker", pagemaker);
		 map.put("list", list);  
		 } 
		 
		 else if(request.getParameter("clsfcselect").equals("total")) {
		 List<bulletinDTO>
		 list = bulletinservice.bulletinSearchTotal(cri);
		 pagemaker.setTotalCount(bulletinservice.listTotalCountCriteria(cri)); // ÃÑ°Ô½Ã±Û °¹¼ö
		 map.put("pagemaker", pagemaker);
		 map.put("list", list);  
		 } 
		 
		 else { 
		 System.out.println("°Ë»ö½ÇÆÐ"); } }
		 
		 
		return map;
	}

}
