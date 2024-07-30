package ru.fathutdinova.auctionengine.api.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ru.fathutdinova.auctionengine.entity.Auction;
import ru.fathutdinova.auctionengine.entity.Image;

@SuperBuilder
@Data
@NoArgsConstructor
public class UpdateAuctionLotRequest extends ByIdRequest{
    private String name;
    private String description;
    private int startBet;
}
