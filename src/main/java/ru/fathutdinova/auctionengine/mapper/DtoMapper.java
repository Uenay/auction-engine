package ru.fathutdinova.auctionengine.mapper;

import ru.fathutdinova.auctionengine.api.CreateUserRequest;
import ru.fathutdinova.auctionengine.api.response.CreateUserResponse;
import ru.fathutdinova.auctionengine.dto.UserDto;
import ru.fathutdinova.auctionengine.entity.Role;
import ru.fathutdinova.auctionengine.entity.RoleEntity;
import ru.fathutdinova.auctionengine.entity.User;

import java.util.Set;
import java.util.stream.Collectors;

public class DtoMapper {
    public static UserDto convertToUserDto(CreateUserRequest createUserRequest) {
        return UserDto.builder()
                .login(createUserRequest.getLogin())
                .password(createUserRequest.getPassword())
                .fullName(createUserRequest.getFullName())
                .build();
    }

    public static User convertToUser(UserDto userDto) {
        User user = new User();
        user.setBalance(userDto.getBalance());
        user.setPassword(userDto.getPassword());
        user.setFullName(userDto.getFullName());
        user.setLogin(userDto.getLogin());
        return user;
    }

    private static Set<Role> convertToRole(Set<RoleEntity> roleEntitySet){
        return roleEntitySet.stream()
                .map(RoleEntity::getName)
                .map(Role::valueOf)
                .collect(Collectors.toSet());
    }
    public static UserDto convertToUserDto(User user) {
        return UserDto.builder()
                .fullName(user.getFullName())
                .roles(convertToRole(user.getRoles()))
                .password(user.getPassword())
                .login(user.getLogin())
                .id(user.getId())
                .balance(user.getBalance())
                .build();
    }

    public static CreateUserResponse convertToCreateUserResponse(UserDto userDto) {
        return CreateUserResponse.builder()
                .login(userDto.getLogin())
                .balance(userDto.getBalance())
                .fullName(userDto.getFullName())
                .id(userDto.getId())
                .roles(userDto.getRoles())
                .build();
    }

}
