package ru.fathutdinova.auctionengine.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RestController;
import ru.fathutdinova.auctionengine.api.request.UpdateUserRequest;
import ru.fathutdinova.auctionengine.api.response.UpdateUserResponse;


@RestController
@RequiredArgsConstructor
public class AdminControllerImpl implements AdminController {
    @Override
    public ResponseEntity<Void> deleteUser(int id) {
        return null;
    }

    @Override
    public UpdateUserResponse updateUser(UpdateUserRequest updateUserRequest) {
        return null;
    }
}
