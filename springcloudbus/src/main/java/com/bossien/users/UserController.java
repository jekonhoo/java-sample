package com.bossien.users;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("")
    public String get(){
        return "ok";
    }

    @PostMapping("")
    public String create(UserCreateUpdateDto dto){
        return "Ok";
    }
}
