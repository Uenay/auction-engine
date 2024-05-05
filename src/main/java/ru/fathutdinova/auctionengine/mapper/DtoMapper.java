package ru.fathutdinova.auctionengine.mapper;

import ru.fathutdinova.auctionengine.api.CreateUserRequest;
import ru.fathutdinova.auctionengine.dto.UserDto;

public class DtoMapper {
    public static UserDto convertToUserDto(CreateUserRequest createUserRequest) {
        return UserDto.builder()
                .login(createUserRequest.getLogin())
                .password(createUserRequest.getPassword())
                .fullName(createUserRequest.getFullName())
                .role(createUserRequest.getRole())
                .build();
    }
}
