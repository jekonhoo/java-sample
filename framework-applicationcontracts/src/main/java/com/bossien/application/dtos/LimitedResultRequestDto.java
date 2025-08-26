package com.bossien.application.dtos;

import lombok.Data;

@Data
public class LimitedResultRequestDto implements ILimitedResultRequest {

	public static int DEFAULT_MAX_RESULT_COUNT = 10;

	public static int MAX_MAX_RESULT_COUNT = 1000;

	private int maxResultCount = 10;

}
