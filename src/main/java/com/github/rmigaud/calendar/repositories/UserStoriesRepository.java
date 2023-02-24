package com.github.rmigaud.calendar.repositories;

import com.github.rmigaud.calendar.models.Status;
import com.github.rmigaud.calendar.models.UserStory;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserStoriesRepository {
  private final List<UserStory> userStories = new ArrayList<>();

  @PostConstruct
  public void init() {
    UserStory us = new UserStory(1, "title", "desc", Status.IN_PROGRESS,
        LocalDateTime.now(), "url");
    userStories.add(us);
  }

  public List<UserStory> findAllUserStories() {
    return userStories;
  }

  public Optional<UserStory> findById(Integer id) {
    return userStories.stream().filter(us -> us.id().equals(id)).findFirst();
    // return First User Story with id == param.id
  }

  public void saveUserStory(UserStory us) {
    userStories.add(us);
  }

  public boolean hasId(Integer id) {
    return userStories.stream().filter(us -> us.id().equals(id)).count() == 1;
  }

  public void updateUserStory(UserStory updatedUserStory) {
    userStories.removeIf(userStory -> userStory.id().equals(updatedUserStory.id()));
    userStories.add(updatedUserStory);
  }

  public void deleteUserStory(Integer deleteId) {
    userStories.removeIf(userStory -> userStory.id().equals(deleteId));
  }
}
