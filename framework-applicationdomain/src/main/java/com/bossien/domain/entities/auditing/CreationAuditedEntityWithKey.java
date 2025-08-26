package com.bossien.domain.entities.auditing;

import com.bossien.auditing.ICreationAuditedObject;
import com.bossien.domain.entities.EntityWithKey;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@MappedSuperclass
public abstract class CreationAuditedEntityWithKey<TKey> extends EntityWithKey<TKey> implements ICreationAuditedObject {

    @Column
    private Date creationTime;
    @Column
    private UUID creatorId;

    protected CreationAuditedEntityWithKey() {

    }

    protected CreationAuditedEntityWithKey(
            TKey id) {
        super(id);
    }
}
