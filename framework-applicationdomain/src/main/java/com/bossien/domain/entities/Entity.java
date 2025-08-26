package com.bossien.domain.entities;

public abstract class Entity implements IEntity {
    @Override
    public abstract Object getKeys();

    @Override
    public String toString() {
        return "[ENTITY: " + this.getClass().getSimpleName() + "] Keys = " + String.join(", " + getKeys());
    }
}
