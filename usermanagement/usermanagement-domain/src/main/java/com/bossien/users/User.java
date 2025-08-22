package com.bossien.users;

import com.bossien.utils.Check;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

import java.util.UUID;

@Getter
@Entity
@Table(name = "users")
public class User {

	@Id
	private UUID id;
	@Column(length = UserConsts.NAME_MAX_LENGTH)
	private String name;
	@Column(length = UserConsts.PHONE_NUMBER_MAX_LENGTH)
	private String phoneNumber;
	@Column(length = UserConsts.EMAIL_MAX_LENGTH)
	private String email;

	protected User() {

	}

	protected User(
            UUID id,
			String name,
			String phoneNumber,
			String email
	) {
        setId(id);
		setName(name);
		setPhoneNumber(phoneNumber);
		setEmail(email);
	}

    private void setId(
            UUID id
    ){
        this.id = id;
    }

	protected void setName(
			String name
	) {
		this.name = Check.notNull(
				name,
				"name",
				UserConsts.NAME_MAX_LENGTH
		);
	}

	protected void setPhoneNumber(
			String phoneNumber
	) {
		this.phoneNumber = Check.notNull(
				phoneNumber,
				"phoneNumber",
				UserConsts.PHONE_NUMBER_MAX_LENGTH
		);
	}

	protected void setEmail(
			String email
	) {
		this.email = Check.notNull(
				email,
				"email",
				UserConsts.EMAIL_MAX_LENGTH
		);
	}

}
