package ru.fathutdinova.auctionengine.mapper;

import ru.fathutdinova.auctionengine.api.CreateUserRequest;
import ru.fathutdinova.auctionengine.dto.UserDto;
import ru.fathutdinova.auctionengine.entity.User;

public class DtoMapper {
    public static UserDto convertToUserDto(CreateUserRequest createUserRequest) {
        return UserDto.builder()
                .login(createUserRequest.getLogin())
                .password(createUserRequest.getPassword())
                .fullName(createUserRequest.getFullName())
                .build();
    }
    public static User convertToUser(UserDto userDto){
        User user = new User();
        user.setBalance(userDto.getBalance());
        user.setPassword(userDto.getPassword());
        user.setFullName(userDto.getFullName());
        user.setLogin(userDto.getLogin());
        user.setRoles(userDto.getRoles());
        return user;
    }

    public static UserDto convertToUserDto(User user){
        return UserDto.builder()
                .fullName(user.getFullName())
                .roles(user.getRoles())
                .password(user.getPassword())
                .login(user.getLogin())
                .id(user.getId())
                .balance(user.getBalance())
                .build();
    }

//    public static UserDto convertToUserDto(CreateUserRequest createUserRequest) {
//        return UserDto.builder()
//                .login(createUserRequest.getLogin())
//                .password(createUserRequest.getPassword())
//                .fullName(createUserRequest.getFullName())
//                .build();
//    }
}
