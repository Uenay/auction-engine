package ru.fathutdinova.auctionengine.api.response;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public class CreateAuctionLotResponse {
    private int id;
    private String name;
    private String description;
    private int startBet;
}
