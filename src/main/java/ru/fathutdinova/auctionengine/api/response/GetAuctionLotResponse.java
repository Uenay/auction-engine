package ru.fathutdinova.auctionengine.api.response;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import ru.fathutdinova.auctionengine.entity.Auction;
import ru.fathutdinova.auctionengine.entity.User;
@ToString(callSuper = true)
@SuperBuilder
@Data
public class GetAuctionLotResponse extends BaseResponse{
    private int id;
    private String name;
    private String description;
    private int startBet;
    private int finalBet;
    private User creator;
    private User purchaser;
    private Auction auction;
}
