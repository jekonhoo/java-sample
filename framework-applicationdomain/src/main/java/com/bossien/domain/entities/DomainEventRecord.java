package com.bossien.domain.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
public class DomainEventRecord {
    private Object eventData;
    private long EventOrder;

    public DomainEventRecord(
            Object eventData,
            long eventOrder) {
        setEventData(eventData);
        setEventOrder(eventOrder);
    }
}
