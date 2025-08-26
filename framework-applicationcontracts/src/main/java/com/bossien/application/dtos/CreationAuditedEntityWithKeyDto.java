package com.bossien.application.dtos;

import com.bossien.auditing.ICreationAuditedObject;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class CreationAuditedEntityWithKeyDto<TKey> extends EntityWithKeyDto<TKey> implements ICreationAuditedObject {
    private Date creationTime;
    private UUID creatorId;
}
