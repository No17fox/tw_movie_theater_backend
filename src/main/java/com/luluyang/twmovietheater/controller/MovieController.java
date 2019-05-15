package com.luluyang.twmovietheater.controller;

import com.luluyang.twmovietheater.dao.MovieRepository;
import com.luluyang.twmovietheater.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/movies")
    public Iterable<Movie> getAllMovies(
            @RequestParam("title") String title,
            @RequestParam("genres") String genres
    ) {
        if (title == null && genres == null) {
            return movieRepository.findAll();
        }
        List<Movie> movies = movieRepository.findByTitleLike("%" + title + "%");
        movies.addAll(movieRepository.findByGenresLike("%" + genres + "%"));
        movies.addAll(movieRepository.findByOriginalTitleLike("%" + title + "%"));
        return movies;
    }

    @GetMapping("/movies/{id}")
    public Iterable<Movie> getMovieById(
            @PathVariable("id") Integer id
    ) {
        List<Movie> movies = new ArrayList<>();
        movies.add(movieRepository.findById(id).get());
        return movies;
    }

    @GetMapping("/movies/genres")
    public Iterable<String> getGenres() {
        List<String> genreStringList = movieRepository.findGenres();
        List<String> allGenres = new ArrayList<>();
        genreStringList.forEach(genres -> allGenres.addAll(Arrays.asList(genres.split(","))));
        return allGenres.stream().distinct().collect(Collectors.toList());
    }
}
