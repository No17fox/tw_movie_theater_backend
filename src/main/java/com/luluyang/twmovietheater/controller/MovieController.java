package com.luluyang.twmovietheater.controller;

import com.luluyang.twmovietheater.dao.MovieRepository;
import com.luluyang.twmovietheater.model.Movie;
import com.luluyang.twmovietheater.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    private MovieService movieService;

    @GetMapping("/movies")
    public Iterable<Movie> getMovies(
            @RequestParam("title") String title,
            @RequestParam("genres") String genres
    ) {
        this.movieService = new MovieService(this.movieRepository);
        return this.movieService.getMovies(title, genres);
    }

    @GetMapping("/movies/{id}")
    public Iterable<Movie> getMovieById(
            @PathVariable("id") Integer id
    ) {
        this.movieService = new MovieService(this.movieRepository);
        return this.movieService.getMovieById(id);
    }

    @GetMapping("/movies/genres")
    public Iterable<String> getMovieGenres() {
        this.movieService = new MovieService(this.movieRepository);
        return this.movieService.getMovieGenres();
    }
}
