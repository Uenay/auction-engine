package ru.fathutdinova.auctionengine.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
public interface UserController {
    @PostMapping("/create")
    CreateUserResponse createUser(@RequestBody CreateUserRequest createUserRequest);
}
