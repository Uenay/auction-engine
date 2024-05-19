package ru.fathutdinova.auctionengine.api;

import lombok.Builder;
import lombok.Data;
import ru.fathutdinova.auctionengine.entity.Role;

import java.util.Set;

@Builder
@Data
public class CreateUserResponse {
    private int id;
    private String login;
    private String fullName;
    private int balance;
    private Set<Role> roles;
}
