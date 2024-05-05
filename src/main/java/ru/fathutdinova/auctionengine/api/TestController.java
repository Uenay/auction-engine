package ru.fathutdinova.auctionengine.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.fathutdinova.auctionengine.entity.Role;
import ru.fathutdinova.auctionengine.entity.User;
import ru.fathutdinova.auctionengine.repository.UserRepository;

import java.util.Set;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final UserRepository userRepository;

    @PostMapping("/test")
    public User createUser() {
        User user = new User();
        user.setBalance(0);
        user.setLogin("userLogin2");
        user.setFullName("user full name");
        user.setPassword("userPassword");
        return userRepository.createUser(user, Set.of("USER", "AUCTIONEER"));
    }

    @GetMapping("/get")
    public User find() {
        User user = userRepository.findUserByLogin("userLogin2");
        return user;
    }
}
