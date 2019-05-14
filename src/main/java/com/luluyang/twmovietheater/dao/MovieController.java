package com.luluyang.twmovietheater.dao;

import com.luluyang.twmovietheater.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/movies")
    public Iterable<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @GetMapping("/movies/{id}")
    public Movie getMovieById(
            @PathVariable("id") Integer id
    ) {
        return movieRepository.findById(id).get();
    }
}
