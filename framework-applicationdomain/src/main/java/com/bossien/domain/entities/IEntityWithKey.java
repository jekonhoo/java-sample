package com.bossien.domain.entities;

public interface IEntityWithKey<TKey> extends IEntity {
    TKey getId();
}
