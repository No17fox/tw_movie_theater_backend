package com.luluyang.twmovietheater.dao;

import com.luluyang.twmovietheater.model.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, Integer> {

    List<Movie> findByGenresLike(String genres);

    List<Movie> findByTitleLike(String title);
}
