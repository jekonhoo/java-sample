package com.bossien.domain.entities;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PROTECTED)
@MappedSuperclass
public abstract class EntityWithKey<TKey> extends Entity implements IEntityWithKey {

    @Id
    private TKey id;

    protected EntityWithKey() {

    }

    protected EntityWithKey(
            TKey id
    ) {
        setId(id);
    }

    @Override
    public Object getKeys() {
        return new Object[]{getId()};
    }

    @Override
    public String toString() {
        return "[ENTITY: " + this.getClass().getSimpleName() + "] Id = " + this.getId();
    }
}
