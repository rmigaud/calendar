package com.github.rmigaud.calendar.controllers;

import com.github.rmigaud.calendar.models.UserStory;
import com.github.rmigaud.calendar.repositories.UserStoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/api/user-story")
public class UserStoryController {
  private final UserStoriesRepository userStoriesRepo;

  @Autowired
  public UserStoryController(UserStoriesRepository userStoriesRepo) {
    this.userStoriesRepo = userStoriesRepo;
  }

  @GetMapping("")
  public List<UserStory> findAllUserStories() {
    return userStoriesRepo.findAllUserStories();
  }

  @GetMapping("/{id}")
  public UserStory findById(@PathVariable Integer id) {
    return userStoriesRepo.findById(id).orElseThrow(
        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User Story " +
            "not found!"));
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping("")
  public void createUserStory(@RequestBody UserStory us) {
    userStoriesRepo.saveUserStory(us);
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @PutMapping("/{id}")
  public void updateUserStory(@RequestBody UserStory us,
                              @PathVariable Integer id) {
    if (userStoriesRepo.hasId(id)) {
      userStoriesRepo.updateUserStory(us);
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found");
    }
  }

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping("/{id}")
  public void deleteUserStory(@PathVariable Integer id) {
    if (userStoriesRepo.hasId(id)) {
      userStoriesRepo.deleteUserStory(id);
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found");
    }
  }


}
