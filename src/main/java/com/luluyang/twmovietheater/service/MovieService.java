package com.luluyang.twmovietheater.service;

import com.luluyang.twmovietheater.dao.MovieRepository;
import com.luluyang.twmovietheater.model.Movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Iterable<Movie> getMovies(String title, String genres) {
        if ((title + genres).equals("")) {
            return this.getAllMovies();
        }
        if ((title + genres).equals(title)) {
            return this.getMoviesByTitle(title);
        }
        if ((title + genres).equals(genres)) {
            return this.getMoviesByGenres(genres);
        }
        return this.getMoviesByTitleOrGenres(title, genres);
    }

    private Iterable<Movie> getAllMovies() {
        return this.movieRepository.findAll();
    }

    private List<Movie> getMoviesByTitle(String title) {
        List<Movie> movies = this.movieRepository.findByTitleLike("%" + title + "%");
        if (movies.size() == 0) {
            movies.addAll(this.movieRepository.findByOriginalTitleLike("%" + title + "%"));
        }
        return movies;
    }

    private List<Movie> getMoviesByGenres(String genres) {
        return this.movieRepository.findByGenresLike("%" + genres + "%");
    }

    private Iterable<Movie> getMoviesByTitleOrGenres(String title, String genres) {
        List<Movie> movies = this.getMoviesByTitle(title);
        movies.addAll(this.getMoviesByGenres(genres));
        return movies;
    }

    public List<Movie> getMovieById(Integer id) {
        List<Movie> movies = new ArrayList<>();
        movies.add(this.movieRepository.findById(id).get());
        return movies;
    }

    public Iterable<String> getMovieGenres() {
        List<String> genreStringList = movieRepository.findGenres();
        List<String> allGenres = new ArrayList<>();
        genreStringList.forEach(genres -> allGenres.addAll(Arrays.asList(genres.split(","))));
        return allGenres.stream().distinct().collect(Collectors.toList());
    }
}
