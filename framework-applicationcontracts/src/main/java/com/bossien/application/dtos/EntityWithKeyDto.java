package com.bossien.application.dtos;

import lombok.Data;

@Data
public abstract class EntityWithKeyDto<TKey> extends EntityDto implements IEntityWithKeyDto<TKey> {

    private TKey id;

    @Override
    public String toString() {
        return "[DTO :" + this.getClass().getSimpleName() + "] Id = " + this.getId();
    }
}
