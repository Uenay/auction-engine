package ru.fathutdinova.auctionengine.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.fathutdinova.auctionengine.api.request.ByIdRequest;
import ru.fathutdinova.auctionengine.api.request.UpdateAuctionLotRequest;
import ru.fathutdinova.auctionengine.api.response.BaseResponse;
import ru.fathutdinova.auctionengine.api.response.ConflictResponse;
import ru.fathutdinova.auctionengine.api.response.GetAuctionLotResponse;
import ru.fathutdinova.auctionengine.api.response.GetAuctionResponse;
import ru.fathutdinova.auctionengine.api.response.UpdateAuctionLotResponse;
import ru.fathutdinova.auctionengine.dto.UserDto;
import ru.fathutdinova.auctionengine.exception.DuplicatedUserLoginException;
import ru.fathutdinova.auctionengine.mapper.DtoMapper;
import ru.fathutdinova.auctionengine.service.UserService;

@RestController
@RequiredArgsConstructor
@Slf4j
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
            log.error("Error while user creating", exception);
            baseResponse = ConflictResponse.builder()
                    .message("User with login = " + createUserRequest.getLogin() + " already exists")
                    .build();
            httpStatus = HttpStatus.CONFLICT;
        }

        return new ResponseEntity<>(baseResponse, httpStatus);
    }

    @Override
    public ResponseEntity<GetAuctionResponse> getAuctionById(ByIdRequest byIdRequest) {
        return null;
    }

    @Override
    public ResponseEntity<UpdateAuctionLotResponse> updateAuctionLot(UpdateAuctionLotRequest updateAuctionLotRequest) {
        return null;
    }

    @Override
    public ResponseEntity<GetAuctionLotResponse> getAuctionLotById(ByIdRequest byIdRequest) {
        return null;
    }
}
