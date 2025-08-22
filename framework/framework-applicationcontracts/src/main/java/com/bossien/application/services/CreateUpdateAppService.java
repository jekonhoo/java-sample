package com.bossien.application.services;

public interface CreateUpdateAppService<TGetOutputDto, TKey, TCreateUpdateDto>
		extends CreateAppService<TGetOutputDto, TCreateUpdateDto>, UpdateAppService<TGetOutputDto, TKey, TCreateUpdateDto> {
}
