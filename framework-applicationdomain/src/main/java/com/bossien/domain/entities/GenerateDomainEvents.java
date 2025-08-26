package com.bossien.domain.entities;

import java.util.List;

public interface GenerateDomainEvents {
    List<DomainEventRecord> getEvents();
}
