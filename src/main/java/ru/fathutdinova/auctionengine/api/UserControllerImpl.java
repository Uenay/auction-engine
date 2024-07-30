package ru.fathutdinova.auctionengine.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.fathutdinova.auctionengine.api.request.ByIdRequest;
import ru.fathutdinova.auctionengine.api.request.CreateAuctionLotRequest;
import ru.fathutdinova.auctionengine.api.request.CreateUserRequest;
import ru.fathutdinova.auctionengine.api.request.GetFilteredAuctionRequest;
import ru.fathutdinova.auctionengine.api.request.UpdateAuctionLotRequest;
import ru.fathutdinova.auctionengine.api.response.BaseResponse;
import ru.fathutdinova.auctionengine.api.response.ConflictResponse;
import ru.fathutdinova.auctionengine.api.response.CreateAuctionLotResponse;
import ru.fathutdinova.auctionengine.api.response.GetFilteredAuctionResponse;
import ru.fathutdinova.auctionengine.api.response.NotFoundResponse;
import ru.fathutdinova.auctionengine.dto.AuctionLotDto;
import ru.fathutdinova.auctionengine.dto.UserDto;
import ru.fathutdinova.auctionengine.exception.DuplicatedUserLoginException;
import ru.fathutdinova.auctionengine.mapper.DtoMapper;
import ru.fathutdinova.auctionengine.service.AuctionLotService;
import ru.fathutdinova.auctionengine.service.UserService;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserControllerImpl implements UserController {
    private final UserService userService;
    private final AuctionLotService auctionLotService;

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
    public ResponseEntity<BaseResponse> getAuctionById(ByIdRequest byIdRequest) {
        return null;
    }

    @Override
    public ResponseEntity<BaseResponse> updateAuctionLot(MultipartFile lotImage, UpdateAuctionLotRequest updateAuctionLotRequest) throws IOException{
        BaseResponse baseResponse;
        HttpStatus httpStatus;
        if (auctionLotService.getAuctionLotById(updateAuctionLotRequest.getId()) == null) {
            baseResponse = NotFoundResponse.builder()
                    .message("Auction Lot with id = " + updateAuctionLotRequest.getId() + " was not found")
                    .build();
            httpStatus = HttpStatus.NOT_FOUND;
            new ResponseEntity<>(baseResponse, httpStatus);
        }

        AuctionLotDto auctionLotDto = DtoMapper.convertToAuctionLotDto(updateAuctionLotRequest);
        AuctionLotDto updatedAuctionLot = auctionLotService.updateAuctionLot(auctionLotDto, lotImage);
        baseResponse = DtoMapper.convertToUpdateAuctionLotResponse(updatedAuctionLot);
        httpStatus = HttpStatus.OK;

        return new ResponseEntity<>(baseResponse, httpStatus);
    }


    @Override
    public ResponseEntity<BaseResponse> getAuctionLotById(ByIdRequest byIdRequest) {
        AuctionLotDto auctionLotDto = auctionLotService.getAuctionLotById(byIdRequest.getId());
        BaseResponse baseResponse;
        HttpStatus httpStatus;
        if (auctionLotDto == null) {
            baseResponse = NotFoundResponse.builder()
                    .message("AuctionLot with id = " + byIdRequest.getId() + " was not found")
                    .build();
            httpStatus = HttpStatus.NOT_FOUND;
        } else {
            baseResponse = DtoMapper.convertToGetResponse(auctionLotDto);
            httpStatus = HttpStatus.OK;
        }

        return new ResponseEntity<>(baseResponse, httpStatus);
    }

    @Override
    public  ResponseEntity<GetFilteredAuctionResponse> getFilteredAuction(GetFilteredAuctionRequest getFilteredAuctionRequest){
        return null;
    }

    @Override
    public CreateAuctionLotResponse createAuctionLot(MultipartFile lotImage, CreateAuctionLotRequest createAuctionLotRequest) throws IOException {
        AuctionLotDto auctionLotDto = DtoMapper.convertToAuctionLotDto(createAuctionLotRequest);
        AuctionLotDto savedAuctionLot = auctionLotService.createAuctionLot(auctionLotDto, lotImage);
        return DtoMapper.convertToCreateAuctionLotResponse(savedAuctionLot);
    }

}
