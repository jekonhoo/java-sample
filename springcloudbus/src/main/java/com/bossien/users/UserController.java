package com.bossien.users;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final ApplicationEventPublisher publisher;

    @GetMapping("")
    public String get(){
        return "ok";
    }

    @PostMapping("")
    public String create(UserCreateUpdateDto dto){

        publisher.publishEvent(
                new UserCreatedEvent(
                        dto.getName()
                )
        );
        return "Ok";
    }
}
