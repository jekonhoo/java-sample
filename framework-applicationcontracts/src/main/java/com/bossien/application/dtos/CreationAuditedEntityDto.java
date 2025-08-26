package com.bossien.application.dtos;

import com.bossien.auditing.ICreationAuditedObject;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public abstract class CreationAuditedEntityDto extends EntityDto implements ICreationAuditedObject {
    private Date creationTime;
    private UUID creatorId;
}
