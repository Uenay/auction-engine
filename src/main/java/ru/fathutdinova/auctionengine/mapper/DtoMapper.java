package ru.fathutdinova.auctionengine.mapper;

import ru.fathutdinova.auctionengine.api.request.CreateAuctionRequest;
import ru.fathutdinova.auctionengine.api.request.CreateUserRequest;
import ru.fathutdinova.auctionengine.api.request.CreateAuctionLotRequest;
import ru.fathutdinova.auctionengine.api.request.UpdateAuctionLotRequest;
import ru.fathutdinova.auctionengine.api.response.CreateAuctionLotResponse;
import ru.fathutdinova.auctionengine.api.response.CreateAuctionResponse;
import ru.fathutdinova.auctionengine.api.response.CreateUserResponse;
import ru.fathutdinova.auctionengine.api.response.GetAuctionLotResponse;
import ru.fathutdinova.auctionengine.api.response.UpdateAuctionLotResponse;
import ru.fathutdinova.auctionengine.dto.AuctionDto;
import ru.fathutdinova.auctionengine.dto.AuctionLotDto;
import ru.fathutdinova.auctionengine.dto.UserDto;
import ru.fathutdinova.auctionengine.entity.Auction;
import ru.fathutdinova.auctionengine.entity.AuctionLot;
import ru.fathutdinova.auctionengine.entity.Role;
import ru.fathutdinova.auctionengine.entity.RoleEntity;
import ru.fathutdinova.auctionengine.entity.User;

import java.util.Set;
import java.util.stream.Collectors;

public class DtoMapper {
    public static UserDto convertToUserDto(CreateUserRequest createUserRequest) {
        return UserDto.builder()
                .login(createUserRequest.getLogin())
                .password(createUserRequest.getPassword())
                .fullName(createUserRequest.getFullName())
                .build();
    }

    public static User convertToUser(UserDto userDto) {
        User user = new User();
        user.setBalance(userDto.getBalance());
        user.setPassword(userDto.getPassword());
        user.setFullName(userDto.getFullName());
        user.setLogin(userDto.getLogin());
        return user;
    }

    private static Set<Role> convertToRole(Set<RoleEntity> roleEntitySet) {
        return roleEntitySet.stream()
                .map(RoleEntity::getName)
                .map(Role::valueOf)
                .collect(Collectors.toSet());
    }

    public static UserDto convertToUserDto(User user) {
        return UserDto.builder()
                .fullName(user.getFullName())
                .roles(convertToRole(user.getRoles()))
                .password(user.getPassword())
                .login(user.getLogin())
                .id(user.getId())
                .balance(user.getBalance())
                .build();
    }

    public static CreateUserResponse convertToCreateUserResponse(UserDto userDto) {
        return CreateUserResponse.builder()
                .login(userDto.getLogin())
                .balance(userDto.getBalance())
                .fullName(userDto.getFullName())
                .id(userDto.getId())
                .roles(userDto.getRoles())
                .build();
    }

    public static AuctionLot convertToAuctionLot(AuctionLotDto auctionLotDto) {
        AuctionLot auctionLot = new AuctionLot();
        auctionLot.setName(auctionLotDto.getName());
        auctionLot.setDescription(auctionLotDto.getDescription());
        auctionLot.setStartBet(auctionLotDto.getStartBet());
        auctionLot.setImage(auctionLot.getImage());
        auctionLot.setFinalBet(auctionLotDto.getFinalBet());
        return auctionLot;
    }

    public static AuctionLotDto convertToAuctionLotDto(AuctionLot auctionLot) {
        return AuctionLotDto.builder()
                .name(auctionLot.getName())
                .description(auctionLot.getDescription())
                .startBet(auctionLot.getStartBet())
                .finalBet(auctionLot.getFinalBet())
                .id(auctionLot.getId())
                .build();
    }

    public static AuctionLotDto convertToAuctionLotDto(CreateAuctionLotRequest createAuctionLotRequest) {
        return AuctionLotDto.builder()
                .name(createAuctionLotRequest.getName())
                .description(createAuctionLotRequest.getDescription())
                .startBet(createAuctionLotRequest.getStartBet())
                .build();
    }

    public static CreateAuctionLotResponse convertToCreateAuctionLotResponse(AuctionLotDto auctionLotDto) {
        return CreateAuctionLotResponse.builder()
                .name(auctionLotDto.getName())
                .description(auctionLotDto.getDescription())
                .startBet(auctionLotDto.getStartBet())
                .id(auctionLotDto.getId())
                .build();
    }
    public static GetAuctionLotResponse convertToGetResponse(AuctionLotDto auctionLotDto) {
        return GetAuctionLotResponse.builder()
                .id(auctionLotDto.getId())
                .name(auctionLotDto.getName())
                .description(auctionLotDto.getDescription())
                .startBet(auctionLotDto.getStartBet())
                .finalBet(auctionLotDto.getFinalBet())
                .creator(auctionLotDto.getCreator())
                .purchaser(auctionLotDto.getPurchaser())
                .auction(auctionLotDto.getAuction())
                .build();
    }
    public static AuctionLotDto convertToAuctionLotDto(UpdateAuctionLotRequest updateAuctionLotRequest) {
        return AuctionLotDto.builder()
                .id(updateAuctionLotRequest.getId())
                .name(updateAuctionLotRequest.getName())
                .description(updateAuctionLotRequest.getDescription())
                .startBet(updateAuctionLotRequest.getStartBet())
                .build();
    }
    public static UpdateAuctionLotResponse convertToUpdateAuctionLotResponse(AuctionLotDto auctionLotDto) {
        return UpdateAuctionLotResponse.builder()
                .name(auctionLotDto.getName())
                .description(auctionLotDto.getDescription())
                .startBet(auctionLotDto.getStartBet())
                .id(auctionLotDto.getId())
                .build();
    }
    public static AuctionDto convertToAuctionDto(Auction auction) {
        return AuctionDto.builder()
                .startTime(auction.getStartTime())
                .endTime(auction.getEndTime())
                .currentBet(auction.getCurrentBet())
                .auctionLot(auction.getAuctionLot())
                .build();
    }
    public static CreateAuctionResponse convertToCreateAuctionResponse(AuctionDto auctionDto) {
        return CreateAuctionResponse.builder()
                .startTime(auctionDto.getStartTime())
                .endTime(auctionDto.getEndTime())
                .auctionLot(auctionDto.getAuctionLot())
                .currentBet(auctionDto.getCurrentBet())
                .currentUser(auctionDto.getCurrentUser())
                .build();
    }
}
