package com.bossien.domain.entities.auditing;

import com.bossien.auditing.ICreationAuditedObject;
import com.bossien.domain.entities.Entity;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public abstract class CreationAuditedEntity extends Entity implements ICreationAuditedObject {
    private Date creationTime;
    private UUID creatorId;
}