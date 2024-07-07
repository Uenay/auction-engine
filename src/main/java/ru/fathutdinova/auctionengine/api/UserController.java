package ru.fathutdinova.auctionengine.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.fathutdinova.auctionengine.api.request.ByIdRequest;
import ru.fathutdinova.auctionengine.api.request.UpdateAuctionLotRequest;
import ru.fathutdinova.auctionengine.api.response.BaseResponse;
import ru.fathutdinova.auctionengine.api.response.GetAuctionLotResponse;
import ru.fathutdinova.auctionengine.api.response.GetAuctionResponse;
import ru.fathutdinova.auctionengine.api.response.UpdateAuctionLotResponse;

public interface UserController {
    @PostMapping("/user/create")
    ResponseEntity<BaseResponse> createUser(@RequestBody CreateUserRequest createUserRequest);

    @GetMapping("/auction/get")
    ResponseEntity<GetAuctionResponse> getAuctionById(@RequestBody ByIdRequest byIdRequest);

    @PostMapping("/auctionLot/update")
    ResponseEntity<UpdateAuctionLotResponse> updateAuctionLot(@RequestBody UpdateAuctionLotRequest updateAuctionLotRequest);

    @GetMapping("/auctionLot/get")
    ResponseEntity<GetAuctionLotResponse> getAuctionLotById(@RequestBody ByIdRequest byIdRequest);
}
