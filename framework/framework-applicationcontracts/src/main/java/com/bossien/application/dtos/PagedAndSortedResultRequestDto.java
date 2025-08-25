package com.bossien.application.dtos;

import lombok.Data;

@Data
public class PagedAndSortedResultRequestDto extends PagedResultRequestDto implements IPagedAndSortedResultRequest {
	private String sorting;
}
