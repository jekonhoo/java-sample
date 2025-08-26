package com.bossien.core;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
public class BusinessException extends RuntimeException {

	private String code;

	public BusinessException(
			String code,
			String message
	) {
		super(message);
		setCode(code);
	}
}
