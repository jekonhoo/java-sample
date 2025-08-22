package com.bossien.users;

import lombok.Data;

import java.util.UUID;

@Data
public class UserDto {
	private UUID id;
	private String name;
	private String phoneNumber;
	private String email;
}
