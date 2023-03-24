package com.github.rmigaud.calendar;

import com.github.rmigaud.calendar.controllers.UserStoryController;
import static com.github.rmigaud.calendar.models.Status.*;
import com.github.rmigaud.calendar.models.UserStory;
import com.github.rmigaud.calendar.repositories.UserStoriesRepository;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class CalendarApplicationTests {
  @Autowired
  UserStoriesRepository userStoriesRepo;

  @Autowired
  UserStoryController userStoryController;

  @Test
  void contextLoads() {
    assertFalse(userStoriesRepo.hasId(0));
  }

  @Test
  void addUserStory_isSuccessful() {
    UserStory us = new UserStory(0, "title", "description", BACK_LOG,
        LocalDateTime.of(LocalDate.now(), LocalTime.now()), "url");
    userStoryController.createUserStory(us);
    assertTrue(userStoriesRepo.hasId(0));
  }
}
