package com.bossien.users;

import com.bossien.utils.Check;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserManager {

	private final UserRepository repository;
	private final ApplicationEventPublisher eventPublisher;

	public User create(
			String name,
			String phoneNumber,
			String email
	) throws UserAlreadyExistingException {

		User existing = repository.findByName(name);
		if (!ObjectUtils.isEmpty(existing)) {
			throw new UserAlreadyExistingException(
					name
			);
		}

		User entity = new User(
				UUID.randomUUID(),
				name,
				phoneNumber,
				email
		);

		eventPublisher.publishEvent(
				new UserCreatedEvent(
						this,
						entity.getId(),
						entity.getName()
				)
		);

		return entity;
	}

	public User changeName(
			User entity,
			String name
	) throws UserAlreadyExistingException {

		User existing = repository.findByName(name);
		if (!ObjectUtils.isEmpty(existing) && !existing.getId().equals(entity.getId())) {
			throw new UserAlreadyExistingException(
					name
			);
		}

		Check.notNull(entity, "entity");

		entity.setName(name);

		return entity;
	}

	public User changePhoneNumber(
			User entity,
			String phoneNumber
	) {
		Check.notNull(entity);
		entity.setPhoneNumber(phoneNumber);

		return entity;
	}

	public User changeEmail(
			User entity,
			String email
	) {
		Check.notNull(entity);
		entity.setEmail(email);

		return entity;
	}
}
