package com.bossien.users;

import com.bossien.application.services.CrudAppService;

public interface UserService extends CrudAppService<UserDto, String, UserCreateUpdateDto, UserGetListDto> {
	UserDto create(
			UserCreateUpdateDto dto
	);
}
