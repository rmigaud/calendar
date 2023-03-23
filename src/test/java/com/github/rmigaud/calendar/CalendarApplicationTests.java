package com.github.rmigaud.calendar;

import com.github.rmigaud.calendar.repositories.UserStoriesRepository;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CalendarApplicationTests {
	@Autowired
	UserStoriesRepository userStoriesRepo;


	@Test
	void contextLoads() {
		assertFalse(userStoriesRepo.hasId(0));
	}

}
