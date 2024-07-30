package ru.fathutdinova.auctionengine.service;

import org.springframework.web.multipart.MultipartFile;
import ru.fathutdinova.auctionengine.dto.AuctionLotDto;

public interface AuctionLotService {
    AuctionLotDto createAuctionLot(AuctionLotDto auctionLotDto, MultipartFile lotImage);
    AuctionLotDto updateAuctionLot(AuctionLotDto auctionLotDto, MultipartFile lotImage);
    AuctionLotDto getAuctionLotById(int id);
    void deleteAuctionLot(int id);
}
