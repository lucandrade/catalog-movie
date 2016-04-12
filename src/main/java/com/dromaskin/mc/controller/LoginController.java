package com.dromaskin.mc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.dromaskin.mc.entity.User;
import com.dromaskin.mc.rest.Response;
import com.dromaskin.mc.service.UserService;

@Controller
@EnableWebMvc
public class LoginController {
	
	@Autowired
	Response response;
	
	@Autowired
	UserService userService;

	@RequestMapping(value="/login", method = RequestMethod.POST)
	public @ResponseBody Response login(HttpServletRequest request, @RequestParam(name="username", defaultValue = "") String userName) {
		response.setData(userName);
		if (!userName.isEmpty()) {
			User user = userService.save(userName);
			request.getSession().setAttribute("user", userName);
			response.setData(user);
			response.setErrorCode(0);
			response.setStatus(true);
		} else {
			response.setStatus(false);
			response.setErrorCode(Response.AUTHERROR);
		}
		return response;
	}
}
