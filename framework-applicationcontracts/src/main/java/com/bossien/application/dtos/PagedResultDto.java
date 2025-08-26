package com.bossien.application.dtos;

import lombok.Data;

import java.util.List;

@Data
public class PagedResultDto<T> extends ListResultDto implements IPagedResult {

	private long totalCount;

	public PagedResultDto(
			long totalCount,
			List<T> items
	) {
		super(items);
		this.totalCount = totalCount;
	}
}
