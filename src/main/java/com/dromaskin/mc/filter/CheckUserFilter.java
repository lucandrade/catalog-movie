package com.dromaskin.mc.filter;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.dromaskin.mc.rest.Response;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@Component
public class CheckUserFilter extends OncePerRequestFilter {
	
	Response response;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		if (request.getSession().getAttribute("user") != null) {
			filterChain.doFilter(request, response);
		} else {
			filterChain.doFilter(request, response);
//			error(response);
		}
	}
	
	protected void error(HttpServletResponse response) throws IOException {
		OutputStream out = response.getOutputStream();
		ObjectMapper mapper = new ObjectMapper();
		
		this.response = new Response();
		this.response.setErrorCode(Response.AUTHERROR);
		this.response.setStatus(false);
		
		out.write(mapper.writeValueAsString(this.response).getBytes());
        response.setContentType("text/json");
        out.close();
	}

}
