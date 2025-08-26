package com.bossien.application.services;


import com.bossien.application.dtos.IPagedResultRequest;
import com.bossien.application.dtos.ISortedResultRequest;
import com.bossien.application.dtos.LimitedResultRequestDto;
import com.bossien.application.dtos.PagedResultDto;
import com.bossien.core.EntityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
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

		Pageable pageable = toPageable(dto);
		pageable = applySorting(pageable, dto);

		Page<TEntity> pageOfEntities = repository.findAll(pageable);

		List<TGetOutputDto> dtos = mapToDtos(pageOfEntities.getContent());

		return new PagedResultDto<>(
				pageOfEntities.getTotalElements(),
				dtos
		);
	}

	@Override
	public TGetOutputDto get(
			TKey id
	) {
		TEntity entity = repository.findById(id).orElse(null);
		if (ObjectUtils.isEmpty(entity)) {
//			throw new EntityNotFoundException(id);
			return null;
		}

		return mapToDto(entity);
	}

	@Override
	public TGetOutputDto create(
			TCreateUpdateDto dto
	) {
		TEntity entity = mapToEntity(dto);
		EntityUtils.setValue(entity, "setCreationTime", new Date());
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

	protected Pageable toPageable(
			TGetListDto dto
	) {
		PageRequest pageable;

		if (dto instanceof IPagedResultRequest pagingDto) {
			pageable = PageRequest.of(
					pagingDto.getSkipCount() / pagingDto.getMaxResultCount(),
					pagingDto.getMaxResultCount()
			);
		} else {
			pageable = PageRequest.of(
					1,
					LimitedResultRequestDto.DEFAULT_MAX_RESULT_COUNT
			);
		}

		return pageable;
	}

	protected Pageable applySorting(
			Pageable pageable,
			TGetListDto dto
	) {

		if (dto instanceof ISortedResultRequest sortingDto) {
			if (StringUtils.hasText(sortingDto.getSorting())) {
				pageable = ((PageRequest) pageable).withSort(
						Sort.by(sortingDto.getSorting())
				);
			} else {
				pageable = ((PageRequest) pageable).withSort(
						Sort.by("id")
				);
			}
		}

		return pageable;
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
