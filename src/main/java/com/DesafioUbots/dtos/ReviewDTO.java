package com.DesafioUbots.dtos;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ReviewDTO(@NotNull int rating, @NotNull UUID movieId) {

}
