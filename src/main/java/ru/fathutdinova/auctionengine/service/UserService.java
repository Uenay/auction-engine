package ru.fathutdinova.auctionengine.service;

import ru.fathutdinova.auctionengine.dto.AuctionLotDto;
import ru.fathutdinova.auctionengine.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);

}
