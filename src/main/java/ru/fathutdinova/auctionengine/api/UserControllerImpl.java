package ru.fathutdinova.auctionengine.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.fathutdinova.auctionengine.dto.UserDto;
import ru.fathutdinova.auctionengine.mapper.DtoMapper;
import ru.fathutdinova.auctionengine.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController{
    private final UserService userService;
    @Override
    public CreateUserResponse createUser(CreateUserRequest createUserRequest){
        UserDto userDto = DtoMapper.convertToUserDto(createUserRequest);
        UserDto savedUser = userService.createUser(userDto);
        return DtoMapper.convertToCreateUserResponse(savedUser);
    }
}
