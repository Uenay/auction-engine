package ru.fathutdinova.auctionengine.api;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ru.fathutdinova.auctionengine.entity.Role;

@SuperBuilder
@Data
@NoArgsConstructor
public class CreateUserRequest {
    private String login;
    private String password;
    private String fullName;
}
