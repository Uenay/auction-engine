package ru.fathutdinova.auctionengine.service;

import ru.fathutdinova.auctionengine.dto.AuctionDto;


public interface AuctionService {
    AuctionDto createAuction(AuctionDto auctionDto);
}
