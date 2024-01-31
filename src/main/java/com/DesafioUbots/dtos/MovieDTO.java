package com.DesafioUbots.dtos;

import jakarta.validation.constraints.NotBlank;

public record MovieDTO(@NotBlank String title, @NotBlank String description) {
}
