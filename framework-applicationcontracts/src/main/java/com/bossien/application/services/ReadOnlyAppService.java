package com.bossien.application.services;

import com.bossien.application.dtos.PagedResultDto;

public interface ReadOnlyAppService<TGetOutputDto, TKey, TGetListDto> {

	PagedResultDto<TGetOutputDto> getList(TGetListDto dto);

	TGetOutputDto get(TKey id);
}
