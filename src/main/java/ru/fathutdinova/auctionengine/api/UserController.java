package ru.fathutdinova.auctionengine.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.fathutdinova.auctionengine.api.request.ByIdRequest;
import ru.fathutdinova.auctionengine.api.request.CreateAuctionLotRequest;
import ru.fathutdinova.auctionengine.api.request.CreateUserRequest;
import ru.fathutdinova.auctionengine.api.request.GetFilteredAuctionRequest;
import ru.fathutdinova.auctionengine.api.request.UpdateAuctionLotRequest;
import ru.fathutdinova.auctionengine.api.response.BaseResponse;
import ru.fathutdinova.auctionengine.api.response.CreateAuctionLotResponse;
import ru.fathutdinova.auctionengine.api.response.GetFilteredAuctionResponse;

import java.io.IOException;

public interface UserController {
    @PostMapping("/user/create")
    ResponseEntity<BaseResponse> createUser(@RequestBody CreateUserRequest createUserRequest);

    @GetMapping("/auction/get")
    ResponseEntity<BaseResponse> getAuctionById(@RequestBody ByIdRequest byIdRequest);

    @PostMapping(value = "/auctionLot/update", consumes = "multipart/form-data")
    ResponseEntity<BaseResponse> updateAuctionLot(@RequestParam(name ="lotImage", required = false) MultipartFile logImage, UpdateAuctionLotRequest updateAuctionLotRequest) throws IOException;

    @GetMapping("/auctionLot/get")
    ResponseEntity<BaseResponse> getAuctionLotById(@RequestBody ByIdRequest byIdRequest);

    @GetMapping("/auction/getFiltered")
    ResponseEntity<GetFilteredAuctionResponse> getFilteredAuction(@RequestBody GetFilteredAuctionRequest getFilteredAuctionRequest);
    @PostMapping(value = "/auctionLot/create", consumes = "multipart/form-data")
    CreateAuctionLotResponse createAuctionLot(@RequestParam("lotImage") MultipartFile logImage, CreateAuctionLotRequest createAuctionLotRequest) throws IOException;

}
