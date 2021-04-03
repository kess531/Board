package com.spring.board.bulletin.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.board.bulletin.dto.bulletinDTO;
import com.spring.board.bulletin.service.bulletinService;

@Controller
@RequestMapping("bulletin")
public class bulletinController {
	@Autowired
	bulletinService bulletinservice;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String goview(HttpServletRequest request, HttpServletResponse response) throws Exception{		
		return "board/index";
	}
	
	
	@RequestMapping(value="/listView")
	public @ResponseBody HashMap<String, Object>listView(HttpServletRequest request) throws IOException {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		if(request.getParameter("keyword") ==null) {
			List<bulletinDTO> list = bulletinservice.bulletinList();
			map.put("list", list);	
			}
		
		else {
			System.out.println(request.getParameter("clsfcselect"));
			if(request.getParameter("clsfcselect").equals("title"))
			{
				System.out.println("≈∏¿Ã∆≤");
				List<bulletinDTO> list =  bulletinservice.bulletinSearchTitle(request.getParameter("keyword"));
				map.put("list",list);
			}
			else if(request.getParameter("clsfcselect").equals("writer"))
			{
				System.out.println("¿€º∫¿⁄");
				List<bulletinDTO> list =  bulletinservice.bulletinSearchMember(request.getParameter("keyword"));
				map.put("list",list);
			}
			else if(request.getParameter("clsfcselect").equals("content")) 
			{
				System.out.println("ƒ¡≈Ÿ√˜");
				List<bulletinDTO> list =  bulletinservice.bulletinSearchContent(request.getParameter("keyword"));
				map.put("list",list);
			}
			else if(request.getParameter("clsfcselect").equals("total"))
			{
				System.out.println("≈‰≈ª");
				List<bulletinDTO> list =  bulletinservice.bulletinSearchTotal(request.getParameter("keyword"));
				map.put("list",list);
			}
			else {
				System.out.println("Ω«∆–");
			}
		}
		return map;
	}
	
	

}
