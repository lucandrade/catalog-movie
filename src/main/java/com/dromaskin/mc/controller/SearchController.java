package com.dromaskin.mc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
@CrossOrigin(origins = "http://localhost")
public class SearchController {

	@Autowired
	private RestService restService;
	
	@Autowired
	Response response;
	
	@RequestMapping(value = "/movie", method = RequestMethod.GET)
	public @ResponseBody Response index(@RequestParam(name="query", defaultValue="") String query) {
		List<MovieSearch> movies = restService.searchMovie(query);
		response.setStatus(true);
		response.setData(movies);
		return response;
	}
	
	@RequestMapping(value = "/movie/{id}", method = RequestMethod.GET)
	public @ResponseBody Response movie(@PathVariable("id") int movieId) {
		MovieSearch movie = restService.searchMovie(movieId);
		response.setStatus(true);
		response.setData(movie);
		return response;
	}
	
	@RequestMapping(value = "/movie/{id}/director", method = RequestMethod.GET)
	public @ResponseBody Response director(@PathVariable("id") int movieId) {
		List<String> directors = restService.searchDirector(movieId);
		response.setStatus(true);
		response.setData(directors);
		return response;
	}
}
