package com.bossien.domain.entities.auditing;

import com.bossien.auditing.IAuditedObject;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public abstract class AuditedEntity extends CreationAuditedEntity implements IAuditedObject {
    private Date lastModificationTime;
    private UUID lastModifierId;
}
