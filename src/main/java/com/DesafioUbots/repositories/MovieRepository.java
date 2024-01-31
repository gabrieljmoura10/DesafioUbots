package com.DesafioUbots.repositories;

import com.DesafioUbots.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface MovieRepository extends JpaRepository<Movie, UUID> {

    @Query("SELECT m FROM Movie m WHERE NOT EXISTS (SELECT 1 FROM Review r WHERE r.movie = m) ORDER BY RANDOM() LIMIT 1")
    Optional<Movie> findUnreviewedMovie();
}
