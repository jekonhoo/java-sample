package com.bossien.application.services;


import com.bossien.application.dtos.PagedResultDto;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;


public abstract class CrudAppServiceImpl<TEntity, TKey, TGetOutputDto, TCreateUpdateDto, TGetListDto>
		implements CreateUpdateAppService<TGetOutputDto, TKey, TCreateUpdateDto>,
				           ReadOnlyAppService<TGetOutputDto, TKey, TGetListDto>,
				           DeleteAppService<TKey> {

	protected JpaRepository<TEntity, TKey> repository;

	public CrudAppServiceImpl(
			JpaRepository<TEntity, TKey> repository
	) {
		this.repository = repository;
	}

	@Override
	public PagedResultDto<TGetOutputDto> getList(
			TGetListDto dto
	) {
		long totalCount = repository.count();
		List<TGetOutputDto> dtos = new ArrayList<>();
		if (totalCount > 0) {
			List<TEntity> entities = repository.findAll();
			dtos = mapToDtos(entities);
		}

		return new PagedResultDto<>(
				totalCount,
				dtos
		);
	}

	@Override
	public TGetOutputDto get(
			TKey id
	) {
		TEntity entity = repository.findById(id).orElse(null);
		return mapToDto(entity);
	}

	@Override
	public TGetOutputDto create(
			TCreateUpdateDto dto
	) {
		TEntity entity = mapToEntity(dto);
		repository.save(entity);
		return mapToDto(entity);
	}

	@Override
	public TGetOutputDto update(
			TKey id,
			TCreateUpdateDto dto
	) {
		TEntity entity = getEntityById(id);
		mapToEntity(dto, entity);
		repository.save(entity);
		return mapToDto(entity);
	}

	@Override
	public void delete(
			TKey id
	) {
		repository.deleteById(id);
	}

	protected TEntity getEntityById(
			TKey id
	) {
		return repository.findById(id).orElse(null);
	}

	protected abstract TEntity mapToEntity(
			TCreateUpdateDto dto
	);

	protected void mapToEntity(
			TCreateUpdateDto dto,
			TEntity entity
	) {
		BeanUtils.copyProperties(dto, entity);
	}

	protected abstract TGetOutputDto mapToDto(
			TEntity entity
	);

	protected List<TGetOutputDto> mapToDtos(
			List<TEntity> entities
	) {
		List<TGetOutputDto> dtos = new ArrayList<>();
		for (TEntity entity : entities) {
			dtos.add(
					mapToDto(entity)
			);
		}
		return dtos;
	}
}
