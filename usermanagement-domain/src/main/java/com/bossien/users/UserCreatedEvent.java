package com.bossien.users;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

import java.util.UUID;

@Getter
@Setter(AccessLevel.PRIVATE)
public class UserCreatedEvent extends ApplicationEvent {
	private UUID id;
	private String name;

	public UserCreatedEvent(
			Object source,
			UUID id,
			String name
	) {
		super(source);
		setId(id);
		setName(name);
	}
}
