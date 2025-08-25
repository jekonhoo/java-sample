package com.bossien.users;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserCreateUpdateDto {
	@NotBlank
	@Size(max = UserConsts.NAME_MAX_LENGTH)
	private String name;
	@NotBlank
	@Size(max = UserConsts.PHONE_NUMBER_MAX_LENGTH)
	private String phoneNumber;
	@Size(max = UserConsts.EMAIL_MAX_LENGTH)
	private String email;
}
