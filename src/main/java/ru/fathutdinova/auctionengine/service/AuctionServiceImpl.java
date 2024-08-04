package ru.fathutdinova.auctionengine.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.fathutdinova.auctionengine.dto.AuctionDto;
import ru.fathutdinova.auctionengine.entity.Auction;
import ru.fathutdinova.auctionengine.entity.AuctionLot;
import ru.fathutdinova.auctionengine.mapper.DtoMapper;
import ru.fathutdinova.auctionengine.repository.AuctionLotRepository;
import ru.fathutdinova.auctionengine.repository.AuctionRepository;


@Component
@RequiredArgsConstructor
public class AuctionServiceImpl implements AuctionService{
    private final AuctionRepository auctionRepository;
    private final AuctionLotRepository auctionLotRepository;
    @Override
    public AuctionDto createAuction(AuctionDto auctionDto) {
        Auction auction = convertToAuction(auctionDto);
        Auction savedAuction = auctionRepository.save(auction);
        return DtoMapper.convertToAuctionDto(savedAuction);
    }
    private Auction convertToAuction(AuctionDto auctionDto) {
        Auction auction = new Auction();
        auction.setStartTime(auctionDto.getStartTime());
//        AuctionLot auctionLot = new AuctionLot();
//        auctionLot = auctionLotRepository.findById(auctionDto.getAuctionLot().getId()).orElseThrow();
//        auction.setAuctionLot(auctionLot);
        auction.setAuctionLot(auctionDto.getAuctionLot());
        return auction;
    }
}
