package com.bossien.domain.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter(AccessLevel.PRIVATE)
public abstract class BasicAggregateRoot extends Entity implements IAggregateRoot, GenerateDomainEvents {

    private List<DomainEventRecord> events = new ArrayList<>();

    public void clearEvents() {
        this.events.clear();
    }

    protected void addEvent(DomainEventRecord event) {
        this.events.add(event);
    }
}

