package ru.fathutdinova.auctionengine.api;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BadResponse {
    private String message;
}

