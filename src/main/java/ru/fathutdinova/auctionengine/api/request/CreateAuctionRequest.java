package ru.fathutdinova.auctionengine.api.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import ru.fathutdinova.auctionengine.entity.AuctionLot;
import ru.fathutdinova.auctionengine.entity.User;

import java.util.Date;

@SuperBuilder
@Data
@NoArgsConstructor
public class CreateAuctionRequest {
    private Date startTime;
    private int auctionLotId;
}
