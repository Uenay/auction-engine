package ru.fathutdinova.auctionengine.api.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import ru.fathutdinova.auctionengine.api.response.BaseResponse;
import ru.fathutdinova.auctionengine.entity.Role;

import java.util.Set;
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Data
public class CreateUserResponse extends BaseResponse {
    private int id;
    private String login;
    private String fullName;
    private int balance;
    private Set<Role> roles;
}
