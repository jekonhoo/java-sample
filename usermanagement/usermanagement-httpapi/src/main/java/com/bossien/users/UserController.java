package com.bossien.users;

import com.bossien.application.dtos.PagedResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("users")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("")
    public PagedResultDto<UserDto> getList(
            UserGetListDto dto
    ) {
        return userService.getList(dto);
    }

    @GetMapping("{id}")
    public UserDto get(
            @PathVariable("id") UUID id
    ) {
        return userService.get(id);
    }

    @PostMapping("")
    public UserDto create(
            @RequestBody @Validated UserCreateUpdateDto dto
    ) {
        return userService.create(dto);
    }

    @PutMapping("{id}")
    public UserDto update(
            @PathVariable("id") UUID id,
            @RequestBody @Validated UserCreateUpdateDto dto
    ) {
        return userService.update(
                id,
                dto
        );
    }

    @DeleteMapping("{id}")
    public void delete(
            @PathVariable("id") UUID id
    ) {
        userService.delete(id);
    }

    

}
