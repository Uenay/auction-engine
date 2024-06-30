package ru.fathutdinova.auctionengine.api;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@NoArgsConstructor
public class CreateUserRequest {
    private String login;
    private String password;
    private String fullName;
}
