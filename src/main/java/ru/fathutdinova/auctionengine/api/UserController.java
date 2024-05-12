package ru.fathutdinova.auctionengine.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.fathutdinova.auctionengine.api.request.CreateUserRequest;
import ru.fathutdinova.auctionengine.api.request.ByIdRequest;
import ru.fathutdinova.auctionengine.api.request.UpdateUserRequest;
import ru.fathutdinova.auctionengine.api.response.CreateUserResponse;
import ru.fathutdinova.auctionengine.api.response.GetUserResponse;
import ru.fathutdinova.auctionengine.api.response.UpdateUserResponse;

@RequestMapping("/user")
public interface UserController {
    @PostMapping("/create")
    CreateUserResponse createUser(@RequestBody CreateUserRequest createUserRequest);

    @GetMapping("/get")
    ResponseEntity<GetUserResponse> getUserById(@RequestBody ByIdRequest byIdRequest); //TODO use RequestBody


    @DeleteMapping("/delete")
    ResponseEntity<Void> deleteUser(@RequestBody ByIdRequest byIdRequest); //TODO use RequestBody


    @PostMapping("/update")
    ResponseEntity<UpdateUserResponse> updateUser(@RequestBody UpdateUserRequest updateUserRequest); //TODO use RequestBody only
}
