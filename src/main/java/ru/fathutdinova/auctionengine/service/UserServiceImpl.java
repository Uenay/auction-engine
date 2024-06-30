package ru.fathutdinova.auctionengine.service;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.fathutdinova.auctionengine.dto.UserDto;
import ru.fathutdinova.auctionengine.entity.RoleEntity;
import ru.fathutdinova.auctionengine.entity.User;
import ru.fathutdinova.auctionengine.mapper.DtoMapper;
import ru.fathutdinova.auctionengine.repository.RoleRepository;
import ru.fathutdinova.auctionengine.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = DtoMapper.convertToUser(userDto);
        user.setBalance(0);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<String> roles = new HashSet<>() {{
            add("USER");
        }};

        Set<RoleEntity> roleEntitySet = new HashSet<>(roleRepository.findByNameIn(roles));
        User savedUser = userRepository.createUser(user, roleEntitySet);
        return DtoMapper.convertToUserDto(savedUser);
    }

}
