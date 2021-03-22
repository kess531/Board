package com.spring.board.bulletin.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public @ResponseBody HashMap<String, Object>listView(Model model) throws IOException {
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<bulletinDTO> list = bulletinservice.bulletinList();
		
		map.put("list", list);
		
		model.addAttribute("list",list);
		System.out.println("¼º°ø");
		return map;
	}
	
}
