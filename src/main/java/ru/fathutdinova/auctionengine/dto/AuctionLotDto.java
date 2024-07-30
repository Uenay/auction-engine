package ru.fathutdinova.auctionengine.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.fathutdinova.auctionengine.entity.Auction;
import ru.fathutdinova.auctionengine.entity.Image;
import ru.fathutdinova.auctionengine.entity.User;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuctionLotDto {
    private int id;
    private String name;
    private String description;
    private int startBet;
    private int finalBet;
    private User creator;
    private User purchaser;
    private Auction auction;
    private Image image;
}
