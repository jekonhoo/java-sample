package com.bossien.domain.entities.auditing;

import com.bossien.auditing.IAuditedObject;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@MappedSuperclass
public abstract class AuditedEntityWithKey<TKey> extends CreationAuditedEntityWithKey<TKey> implements IAuditedObject {
    @Column
    private Date lastModificationTime;
    @Column
    private UUID lastModifierId;
}
