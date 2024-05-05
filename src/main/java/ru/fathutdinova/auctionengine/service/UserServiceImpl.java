package ru.fathutdinova.auctionengine.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.fathutdinova.auctionengine.dto.UserDto;
import ru.fathutdinova.auctionengine.entity.RoleEntity;
import ru.fathutdinova.auctionengine.entity.User;
import ru.fathutdinova.auctionengine.repository.RoleRepository;
import ru.fathutdinova.auctionengine.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = DtoMapper.convertToPlayer(userDto);
        RoleEntity roleEntity = roleRepository.findByName(userDto.getRole().name());
        user.setRole(roleEntity);
        User savedUser = userRepository.save(user);
        return DtoMapper.convertToPlayerDto(savedUser);
    }
}
