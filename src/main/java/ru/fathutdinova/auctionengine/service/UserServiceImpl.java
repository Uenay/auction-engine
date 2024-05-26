package ru.fathutdinova.auctionengine.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.fathutdinova.auctionengine.dto.UserDto;
import ru.fathutdinova.auctionengine.entity.Role;
import ru.fathutdinova.auctionengine.entity.User;
import ru.fathutdinova.auctionengine.mapper.DtoMapper;
import ru.fathutdinova.auctionengine.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = DtoMapper.convertToUser(userDto);
        user.setBalance(0);
        Set<Role> roles = new HashSet<>();
        roles.add(Role.USER);
        User savedUser = userRepository.createUser(user, roles);
        return DtoMapper.convertToUserDto(savedUser);
    }

//    private User createNewUser(UserDto userDto) {
//        User user = new User();
//        user.setBalance(0);
//        //TODO остальные поля
//        return user;
//    }
}
