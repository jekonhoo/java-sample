package com.bossien.application.dtos;

import com.bossien.auditing.IAuditedObject;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public abstract class AuditedEntityWithKeyDto<TKey> extends CreationAuditedEntityWithKeyDto<TKey> implements IAuditedObject {
    private Date lastModificationTime;
    private UUID lastModifierId;
}
