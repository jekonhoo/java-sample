package com.bossien.application.dtos;

import lombok.Data;

@Data
public class PagedResultRequestDto extends LimitedResultRequestDto implements IPagedResultRequest {
	private int skipCount;

}
