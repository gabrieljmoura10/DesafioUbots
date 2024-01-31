package com.DesafioUbots.controllers;

import com.DesafioUbots.dtos.MovieDTO;
import com.DesafioUbots.models.Movie;
import com.DesafioUbots.services.MovieService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<Movie> createMovie(@Valid @RequestBody MovieDTO movieDTO) {
        Movie createdMovie = movieService.createMovie(movieDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMovie);
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();
        return ResponseEntity.status(HttpStatus.OK).body(movies);
    }

    @GetMapping("/recommendations")
    public ResponseEntity<Movie> getRecommendation() {
        Optional<Movie> unreviewedMovie = movieService.getUnreviewedMovie();
        return unreviewedMovie.map(movie -> ResponseEntity.ok().body(movie))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateMovie(@PathVariable(value = "id") UUID id, @RequestBody @Valid MovieDTO movieDTO) {
        Optional<Movie> updatedMovie = movieService.updateMovie(id, movieDTO);

        if (updatedMovie.isPresent()) {
            Movie movie = updatedMovie.get();
            return ResponseEntity.status(HttpStatus.OK).body(movie);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie not found");
        }
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteMovie(@PathVariable(value = "id") UUID id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }
}
