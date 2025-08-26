package com.bossien.users;

import com.bossien.application.dtos.AuditedEntityWithKeyDto;
import lombok.Data;

import java.util.UUID;

@Data
public class UserDto extends AuditedEntityWithKeyDto<UUID> {
    private String name;
    private String phoneNumber;
    private String email;
}
