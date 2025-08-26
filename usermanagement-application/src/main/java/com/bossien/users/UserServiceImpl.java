package com.bossien.users;

import com.bossien.application.services.CrudAppServiceImpl;
import com.bossien.core.BusinessException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceImpl extends CrudAppServiceImpl<User, UUID, UserDto, UserCreateUpdateDto, UserGetListDto> implements UserService {


    private final UserManager manager;

    public UserServiceImpl(
            UserRepository repository,
            UserManager manager) {
        super(repository);
        this.manager = manager;
    }

    @Override
    public UserDto create(
            UserCreateUpdateDto dto
    ) throws BusinessException {
        User entity = manager.create(
                dto.getName(),
                dto.getPhoneNumber(),
                dto.getEmail()
        );
        entity.setCreationTime(new Date());
        repository.save(entity);
        return mapToDto(entity);
    }

    @Override
    public UserDto update(
            UUID id,
            UserCreateUpdateDto dto
    ) throws BusinessException {
        User entity = repository.findById(id).orElse(null);
        if (ObjectUtils.isEmpty(entity)) {
            return null;
        }

        manager.changeName(entity, dto.getName());
        manager.changePhoneNumber(entity, dto.getPhoneNumber());
        manager.changeEmail(entity, dto.getEmail());
        repository.save(entity);

        return mapToDto(entity);
    }

    @Override
    protected User mapToEntity(UserCreateUpdateDto dto) {
        return null;
    }

    @Override
    protected UserDto mapToDto(User user) {
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(user, dto);
        return dto;
    }
}
