package com.bossien.application.dtos;

public interface IPagedResultRequest extends ILimitedResultRequest {
	int getSkipCount();
}
