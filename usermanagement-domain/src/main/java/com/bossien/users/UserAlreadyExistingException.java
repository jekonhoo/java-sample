package com.bossien.users;


import com.bossien.core.BusinessException;

public class UserAlreadyExistingException extends BusinessException {
	public UserAlreadyExistingException(String name) {
		super(name + "已存在", null);
	}
}
