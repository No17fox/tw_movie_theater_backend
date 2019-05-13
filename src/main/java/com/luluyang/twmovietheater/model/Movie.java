package com.luluyang.twmovietheater.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "movie")
public class Movie {
    @Id
    private Integer id;
    private String alt;
    private int year;
    private String title;
    private double rating;
    private String original_title;
    private List<String> directors;
    private List<String> casts;
    private List<String> genres;
    private String image;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAlt() {
        return this.alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRating() {
        return this.rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getOriginal_title() {
        return this.original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public List<String> getDirectors() {
        return this.directors;
    }

    public void setDirectors(List<String> directors) {
        this.directors = directors;
    }

    public List<String> getCasts() {
        return this.casts;
    }

    public void setCasts(List<String> casts) {
        this.casts = casts;
    }

    public List<String> getGenres() {
        return this.genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
