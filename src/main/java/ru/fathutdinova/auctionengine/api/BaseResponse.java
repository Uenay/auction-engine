package ru.fathutdinova.auctionengine.api;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class BaseResponse {
    private String message;
}

