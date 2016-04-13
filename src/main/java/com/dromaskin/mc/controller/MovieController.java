package com.dromaskin.mc.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.dromaskin.mc.entity.Movie;
import com.dromaskin.mc.rest.Response;
import com.dromaskin.mc.service.MovieService;

@Controller
@RequestMapping(value="/rest/movie", produces = "application/json")
@EnableWebMvc
public class MovieController {

	@ModelAttribute("movie")
	public Movie movieConstruct() {
		return new Movie();
	}
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	Response response;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Response index() {
		response.setData(movieService.all());
		return response;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Response add(@Valid @ModelAttribute("movie") Movie movie,
			BindingResult result,
			HttpServletRequest request) {
		if (result.hasErrors()) {
			Map<String, String> errors = new HashMap<String, String>();
			for (FieldError error : result.getFieldErrors()) {
				errors.put(error.getField(), error.getDefaultMessage());
			}
			response.setData(errors);
			response.setStatus(false);
		} else {
			movieService.save(movie);
			movieService.bindGenres(request.getParameterValues("genres_id"), movie);
			response.setStatus(true);
			response.setData(movie);
		}
		return response;
	}
}
