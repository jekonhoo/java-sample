package com.bossien.application.dtos;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class PagedResultRequestDto extends LimitedResultRequestDto implements IPagedResultRequest {

	@Min(0)
	private int skipCount;

}
