package ru.fathutdinova.auctionengine.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.fathutdinova.auctionengine.api.request.UpdateUserRequest;

import ru.fathutdinova.auctionengine.api.response.GetAuctionLotResponse;
import ru.fathutdinova.auctionengine.api.response.UpdateUserResponse;
import ru.fathutdinova.auctionengine.api.response.UserResponse;

public interface AdminController {
    @DeleteMapping("/user/delete/{id}")
    ResponseEntity<UserResponse> deleteUser(@PathVariable("id") int id);

    @PostMapping("/user/update")
    UserResponse updateUser(@RequestBody UpdateUserRequest updateUserRequest);
    @DeleteMapping("/auctionLot/delete/{id}")
    ResponseEntity<GetAuctionLotResponse> deleteAuctionLot (@PathVariable("id") int id);
}
