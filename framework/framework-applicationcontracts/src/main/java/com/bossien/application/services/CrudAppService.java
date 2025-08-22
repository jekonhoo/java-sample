package com.bossien.application.services;

public interface CrudAppService<TGetOutputDto, TKey, TCreateUpdateDto, TGetListDto>
		extends ReadOnlyAppService<TGetOutputDto, TKey, TGetListDto>,
				        CreateUpdateAppService<TGetOutputDto, TKey, TCreateUpdateDto>,
				        DeleteAppService<TKey> {
}
