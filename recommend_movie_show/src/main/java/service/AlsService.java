package service;

import po.Movie;

import java.util.List;


public interface AlsService {
    List<Movie> selectAlsMoviesByUserId(Integer userid);
}
