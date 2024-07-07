package ru.fathutdinova.auctionengine.api.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@NoArgsConstructor
public class GetFilteredAuctionRequest {
    private String name;
}
