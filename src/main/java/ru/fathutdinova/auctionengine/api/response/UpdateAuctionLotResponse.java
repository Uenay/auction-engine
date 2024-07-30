package ru.fathutdinova.auctionengine.api.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import ru.fathutdinova.auctionengine.entity.Image;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Data
public class UpdateAuctionLotResponse extends BaseResponse{
    private int id;
    private String name;
    private String description;
    private int startBet;
    private Image image;
}
