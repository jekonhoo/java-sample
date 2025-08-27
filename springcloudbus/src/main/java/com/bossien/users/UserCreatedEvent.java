package com.bossien.users;

import lombok.Data;
import org.springframework.cloud.bus.event.RemoteApplicationEvent;

@Data
public class UserCreatedEvent extends RemoteApplicationEvent {
    private String name;

    public UserCreatedEvent(Object source, String name) {
        setName(name);
    }
}
