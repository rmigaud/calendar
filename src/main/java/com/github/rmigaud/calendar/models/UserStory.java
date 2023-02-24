package com.github.rmigaud.calendar.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

@SuppressWarnings("unused")
public record UserStory(@PositiveOrZero @NotNull Integer id,
                        @Size(min = 1)
                        String title,
                        @Size(min = 1)
                        String description,
                        @NotNull
                        Status status,

                        LocalDateTime lastUpdated,
                        String url) {
}
