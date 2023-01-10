package platform.codingnomads.co.springtest.lab.service;

import platform.codingnomads.co.springtest.lab.entity.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<Movie> getAllMovies();
    Optional<List<Movie>> getMoviesByRating(Double rating);
}
