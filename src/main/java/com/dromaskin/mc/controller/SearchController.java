package com.dromaskin.mc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.dromaskin.mc.rest.Response;
import com.dromaskin.mc.service.RestService;
import com.dromaskin.mc.tmdbentity.MovieSearch;

@RequestMapping(value = "/rest/search", produces = "application/json")
@Controller
@EnableWebMvc
public class SearchController {

	@Autowired
	private RestService restService;
	
	@Autowired
	Response response;
	
	@RequestMapping(value = "/movie", method = RequestMethod.GET)
	public @ResponseBody Response index(@RequestParam(name="query", defaultValue="Runner") String query) {
		List<MovieSearch> movies = restService.searchMovie(query);
		response.setData(movies);
		return response;
	}
}
