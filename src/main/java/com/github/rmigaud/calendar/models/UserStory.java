package com.github.rmigaud.calendar.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;

@SuppressWarnings("unused")
public record UserStory(@PositiveOrZero @NotNull Integer id,
                        @NotBlank
                        String title,
                        @NotBlank
                        String description,
                        @NotNull
                        Status status,
                        LocalDateTime lastUpdated,
                        String url) {
}
