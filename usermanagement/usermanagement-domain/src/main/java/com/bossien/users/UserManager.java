package com.bossien.users;

import com.bossien.utils.Check;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
@RequiredArgsConstructor
public class UserManager {

	private final UserRepository repository;

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

		return new User(
				name,
				phoneNumber,
				email
		);
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
