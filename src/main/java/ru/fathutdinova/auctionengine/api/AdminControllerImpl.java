package ru.fathutdinova.auctionengine.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RestController;
import ru.fathutdinova.auctionengine.api.request.UpdateUserRequest;
import ru.fathutdinova.auctionengine.api.response.GetAuctionLotResponse;
import ru.fathutdinova.auctionengine.api.response.UserResponse;
import ru.fathutdinova.auctionengine.dto.AuctionLotDto;
import ru.fathutdinova.auctionengine.entity.AuctionLot;
import ru.fathutdinova.auctionengine.mapper.DtoMapper;
import ru.fathutdinova.auctionengine.service.AuctionLotService;


@RestController
@RequiredArgsConstructor
public class AdminControllerImpl implements AdminController {
    private final AuctionLotService auctionLotService;
    @Override
    public ResponseEntity<UserResponse> deleteUser(int id) {
        return null;
    }

    @Override
    public UserResponse updateUser(UpdateUserRequest updateUserRequest) {
        return null;
    }

    @Override
    public ResponseEntity<GetAuctionLotResponse> deleteAuctionLot(int id) {
        GetAuctionLotResponse response;
        HttpStatus httpStatus;
        AuctionLotDto auctionLot = auctionLotService.getAuctionLotById(id);
        if (auctionLot == null) {
            httpStatus = HttpStatus.NOT_FOUND;
            response = null;
        } else {
            response = DtoMapper.convertToGetResponse(auctionLot);
            auctionLotService.deleteAuctionLot(id);
            httpStatus = HttpStatus.OK;
        }

        return new ResponseEntity<>(response, httpStatus);
    }
}
