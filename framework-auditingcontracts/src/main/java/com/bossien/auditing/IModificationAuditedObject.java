package com.bossien.auditing;

import java.util.UUID;

public interface IModificationAuditedObject extends IHasModificationTime {
    UUID getLastModifierId();
}
