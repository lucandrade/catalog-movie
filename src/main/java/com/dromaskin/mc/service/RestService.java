package com.dromaskin.mc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dromaskin.mc.entity.Genre;
import com.dromaskin.mc.rest.GenreList;
import com.dromaskin.mc.rest.RestConfiguration;

@Service
public class RestService {
	
	@Autowired
	private RestTemplate rest;
	
	@Autowired
	private RestConfiguration restConfiguration;
	
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Genre> genres() {
		String url = restConfiguration.getUrl() +
				"genre/movie/list?api_key=" +
				restConfiguration.getApiKey();
		return rest.getForObject(url, GenreList.class).genres;
	}
}
