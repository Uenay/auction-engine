package ru.fathutdinova.auctionengine.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.fathutdinova.auctionengine.api.request.ByIdRequest;
import ru.fathutdinova.auctionengine.api.request.CreateUserRequest;
import ru.fathutdinova.auctionengine.api.request.UpdateUserRequest;
import ru.fathutdinova.auctionengine.api.response.CreateUserResponse;
import ru.fathutdinova.auctionengine.api.response.GetUserResponse;
import ru.fathutdinova.auctionengine.api.response.UpdateUserResponse;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    @Override
    public CreateUserResponse createUser(CreateUserRequest createUserRequest) {
        return null;
    }

    @Override
    public ResponseEntity<GetUserResponse> getUserById(ByIdRequest byIdRequest) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteUser(ByIdRequest byIdRequest) {
        return null;
    }

    @Override
    public ResponseEntity<UpdateUserResponse> updateUser(UpdateUserRequest updateUserRequest) {
        return null;
    }
}
