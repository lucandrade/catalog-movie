package com.dromaskin.mc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.dromaskin.mc.entity.Genre;
import com.dromaskin.mc.tmdbentity.CrewSearch;
import com.dromaskin.mc.tmdbentity.CrewSearchList;
import com.dromaskin.mc.tmdbentity.Configuration;
import com.dromaskin.mc.tmdbentity.GenreSearch;
import com.dromaskin.mc.tmdbentity.GenreSearchList;
import com.dromaskin.mc.tmdbentity.MoviePoster;
import com.dromaskin.mc.tmdbentity.MoviePosterList;
import com.dromaskin.mc.tmdbentity.MovieSearch;
import com.dromaskin.mc.tmdbentity.MovieSearchList;
import com.dromaskin.mc.rest.RestConfiguration;

@Service
public class RestService {
	
	@Autowired
	private RestTemplate rest;
	
	@Autowired
	private GenreService genreService;
	
	@Autowired
	private RestConfiguration restConfiguration;
	
	private Configuration tmdbConfiguration;
	
	private String urlImage;
	
	public String getUrlImage() {
		return urlImage;
	}
	
	public void setConfiguration() {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(restConfiguration.getUrl() + "configuration")
				.queryParam("api_key", restConfiguration.getApiKey());
		String url = uriBuilder.build().encode().toString();
		tmdbConfiguration = rest.getForObject(url, Configuration.class);
		urlImage = tmdbConfiguration.getImage().getBaseUrl();
	}

	public void init() {
		setConfiguration();
	}

	public List<GenreSearch> genres() {
		String url = restConfiguration.getUrl() +
				"genre/movie/list?api_key=" +
				restConfiguration.getApiKey();
		return rest.getForObject(url, GenreSearchList.class).getGenres();
	}
	
	public List<String> searchDirector(int movieId) {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(restConfiguration.getUrl() + "movie/" + movieId + "/credits")
				.queryParam("api_key", restConfiguration.getApiKey());
		String url = uriBuilder.build().encode().toString();
		List<CrewSearch> crewList = rest.getForObject(url, CrewSearchList.class).getCrew();
		List<String> directors = new ArrayList<String>();
		for (CrewSearch cast : crewList) {
			if (cast.getJob() != null && cast.getJob().equals("Director")) {
				directors.add(cast.getName());
			}
		}
		return directors;
	}
	
	public MovieSearch searchMovie(int movieId) {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(restConfiguration.getUrl() + "movie/" + movieId)
				.queryParam("api_key", restConfiguration.getApiKey());
		String url = uriBuilder.build().encode().toString();
		MovieSearch movie = rest.getForObject(url, MovieSearch.class);
		loadMovie(movie);
		return movie;
	}
	
	public List<MovieSearch> searchMovie(String searchString) {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(restConfiguration.getUrl() + "search/movie")
				.queryParam("api_key", restConfiguration.getApiKey())
				.queryParam("include_adult", "false")
				.queryParam("query", searchString);
		String url = uriBuilder.build().encode().toString();
		List<MovieSearch> movieList = rest.getForObject(url, MovieSearchList.class).getMovies();
		for (MovieSearch movie : movieList) {
			loadMovie(movie);
		}
		return movieList;
	}
	
	public void loadMovie(MovieSearch movie) {
		movie.setReleasedDate(movie.getReleaseDate());
		movie.setPosterUrl(searchPoster(movie));
		movie.setTmdbId(movie.getId());
		movie.setId(0);
		getGenresForMovie(movie);
	}
	
	public String searchPoster(MovieSearch movie) {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(restConfiguration.getUrl()
				+ "movie/" + movie.getId() + "/images")
				.queryParam("api_key", restConfiguration.getApiKey())
				.queryParam("include_adult", "false");
		MoviePoster smallerPost = rest.getForObject(uriBuilder.build().encode().toString(), MoviePosterList.class).getSmaller();
		
		if (smallerPost == null) {
			smallerPost = new MoviePoster();
		}
		return smallerPost.makeUrl(urlImage);
	}
	
	public void getGenresForMovie(MovieSearch movie) {
		List<GenreSearch> search = movie.getGenres();
		for (GenreSearch genreSearch : search) {
			Genre genre = genreService.findByTmdbId(genreSearch.getId());
			if (genre != null) {
				genreSearch.setName(genre.getName());
			}
		}
	}
}
