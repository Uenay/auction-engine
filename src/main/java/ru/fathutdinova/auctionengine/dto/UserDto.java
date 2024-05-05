package ru.fathutdinova.auctionengine.dto;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.fathutdinova.auctionengine.entity.Role;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private int id;

    private String login;

    private String password;

    private String fullName;

    private int balance;

    private Role role;
}
