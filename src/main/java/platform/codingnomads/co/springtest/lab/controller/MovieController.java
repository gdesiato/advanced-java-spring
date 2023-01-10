package platform.codingnomads.co.springtest.lab.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import platform.codingnomads.co.springtest.lab.entity.Movie;
import platform.codingnomads.co.springtest.lab.service.MovieService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class MovieController {

    private MovieService movieService;

    @GetMapping("/all")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/all/rating/{rating}")
    public ResponseEntity<List<Movie>> getMoviesByRating(@PathVariable double rating) {
        Optional<List<Movie>> moviesByRating = movieService.getMoviesByRating(rating);
        if (moviesByRating.isPresent()){
            return ResponseEntity.ok(moviesByRating.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
