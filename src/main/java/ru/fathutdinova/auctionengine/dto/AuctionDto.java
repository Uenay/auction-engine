package ru.fathutdinova.auctionengine.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.fathutdinova.auctionengine.entity.AuctionLot;
import ru.fathutdinova.auctionengine.entity.User;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuctionDto {
    private int id;
    private Date startTime;
    private Date endTime;
    private int currentBet;
    private int auctionLotId;
    private User currentUser;
}
