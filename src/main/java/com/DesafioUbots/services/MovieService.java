package com.DesafioUbots.services;

import com.DesafioUbots.dtos.MovieDTO;
import com.DesafioUbots.models.Movie;
import com.DesafioUbots.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie createMovie(MovieDTO movieDTO) {
        Movie movie = new Movie();
        movie.setTitle(movieDTO.title());
        movie.setDescription(movieDTO.description());
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getUnreviewedMovie() {
        return movieRepository.findUnreviewedMovie();
    }

    public Optional<Movie> updateMovie(UUID id, MovieDTO movieDTO) {
        Optional<Movie> movieOptional = movieRepository.findById(id);
        if (movieOptional.isPresent()) {
            Movie existingMovie = movieOptional.get();
            existingMovie.setTitle(movieDTO.title());
            existingMovie.setDescription(movieDTO.description());
            return Optional.of(movieRepository.save(existingMovie));
        } else {
            return Optional.empty();
        }
    }

    public void deleteMovie(UUID id) {
        movieRepository.findById(id).ifPresent(movieRepository::delete);
    }
}
