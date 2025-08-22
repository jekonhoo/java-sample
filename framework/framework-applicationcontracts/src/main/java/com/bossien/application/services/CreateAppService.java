package com.bossien.application.services;

public interface CreateAppService<TGetOutputDto, TCreateDto> {
	TGetOutputDto create(TCreateDto dto);
}
