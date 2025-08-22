package com.bossien.application.dtos;

import lombok.Data;

@Data
public class LimitedResultRequestDto implements ILimitedResultRequest {

	private int maxResultCount;

}
