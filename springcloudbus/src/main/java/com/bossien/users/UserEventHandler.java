package com.bossien.users;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserEventHandler {

    @EventListener
    public void userCreatedEvent(UserCreatedEvent userCreatedEvent) {
        log.info("UserCreatedEvent received {}", userCreatedEvent);
    }
}
