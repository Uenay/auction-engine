package ru.fathutdinova.auctionengine.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.fathutdinova.auctionengine.api.request.UpdateUserRequest;

import ru.fathutdinova.auctionengine.api.response.UpdateUserResponse;

public interface AdminController {
    @DeleteMapping("/user/delete/{id}")
    ResponseEntity<Void> deleteUser(@PathVariable("id") int id);

    @PostMapping("/user/update/")
    UpdateUserResponse updateUser(@RequestBody UpdateUserRequest updateUserRequest);
}
