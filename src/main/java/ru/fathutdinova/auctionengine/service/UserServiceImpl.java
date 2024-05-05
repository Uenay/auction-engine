package ru.fathutdinova.auctionengine.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.fathutdinova.auctionengine.dto.UserDto;
import ru.fathutdinova.auctionengine.entity.User;
import ru.fathutdinova.auctionengine.mapper.DtoMapper;
import ru.fathutdinova.auctionengine.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto userDto) {

        return null;
//        User user = DtoMapper.convertToUserDto(userDto);
//        User savedUser = userRepository.save(user);
//        return DtoMapper.convertToUserDto(savedUser);
    }

    private User createNewUser(UserDto userDto) {
        User user = new User();
        user.setBalance(0);
        //TODO остальные поля
        return user;
    }
}
