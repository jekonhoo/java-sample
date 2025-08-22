package com.bossien.users;

import com.bossien.application.services.CrudAppService;

import java.util.UUID;

public interface UserService extends CrudAppService<UserDto, UUID, UserCreateUpdateDto, UserGetListDto> {
	UserDto create(
			UserCreateUpdateDto dto
	);
}
