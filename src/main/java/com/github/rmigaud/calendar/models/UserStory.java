package com.github.rmigaud.calendar.models;

import java.time.LocalDateTime;

@SuppressWarnings("unused")
public record UserStory(Integer id, String title, String description,
                        Status status, LocalDateTime lastUpdated,
                        String url) {
}
