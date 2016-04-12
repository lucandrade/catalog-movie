package com.dromaskin.mc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/session")
	public String session(HttpServletRequest request, @RequestParam(value="name", defaultValue="") String name) {
		System.out.println("sessao com usuario " + name);
		if (!name.isEmpty()) {
			request.getSession().setAttribute("user", name);
		}
		return "index.jsp";
	}
}
