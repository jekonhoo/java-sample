package com.bossien.application.dtos;

public abstract class EntityDto implements IEntityDto {
    @Override
    public String toString() {
        return "[DTO: {" + this.getClass().getSimpleName() + "}]";
    }
}
