package ru.fathutdinova.auctionengine.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.fathutdinova.auctionengine.dto.UserDto;
import ru.fathutdinova.auctionengine.exception.DuplicatedUserLoginException;
import ru.fathutdinova.auctionengine.mapper.DtoMapper;
import ru.fathutdinova.auctionengine.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {
    private final UserService userService;

    @Override
    public ResponseEntity<BaseResponse> createUser(CreateUserRequest createUserRequest) {
        BaseResponse baseResponse;
        HttpStatus httpStatus;
        try {
            UserDto userDto = DtoMapper.convertToUserDto(createUserRequest);
            UserDto savedUser = userService.createUser(userDto);
            baseResponse = DtoMapper.convertToCreateUserResponse(savedUser);
            httpStatus = HttpStatus.OK;
        } catch (DuplicatedUserLoginException exception) {
            baseResponse = ConflictResponse.builder()
                    .message("User with login = " + createUserRequest.getLogin() + " already exists")
                    .build();
            httpStatus = HttpStatus.CONFLICT;
        }

        return new ResponseEntity<>(baseResponse, httpStatus);


    }
}
