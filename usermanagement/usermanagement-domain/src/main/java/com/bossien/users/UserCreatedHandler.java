package com.bossien.users;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserCreatedHandler implements ApplicationListener<UserCreatedEvent> {
	@Override
	public void onApplicationEvent(UserCreatedEvent event) {
		log.info("user created: " + event.getName());
	}
}
