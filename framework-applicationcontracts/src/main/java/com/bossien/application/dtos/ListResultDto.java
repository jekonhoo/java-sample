package com.bossien.application.dtos;

import lombok.Data;

import java.util.List;

@Data
public class ListResultDto<T> implements IListResult<T> {

	private List<T> items;

	public ListResultDto(
			List<T> items
	) {
		this.items = items;
	}

}
