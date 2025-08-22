package com.bossien.application.services;

public interface UpdateAppService<TGetOutputDto, TKey, TUpdateDto> {
	TGetOutputDto update(TKey id, TUpdateDto dto);
}
