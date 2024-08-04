package ru.fathutdinova.auctionengine.api.response;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import ru.fathutdinova.auctionengine.entity.AuctionLot;
import ru.fathutdinova.auctionengine.entity.User;


import java.util.Date;

@ToString(callSuper = true)
@SuperBuilder
@Data
public class CreateAuctionResponse extends BaseResponse{
    private int id;
    private Date startTime;
    private Date endTime;
    private int currentBet;
    private AuctionLot auctionLot;
    private User currentUser;
}
