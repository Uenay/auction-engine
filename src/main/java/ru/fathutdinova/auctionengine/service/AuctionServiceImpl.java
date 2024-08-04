package ru.fathutdinova.auctionengine.service;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Supplier;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.fathutdinova.auctionengine.dto.AuctionDto;
import ru.fathutdinova.auctionengine.dto.AuctionLotDto;
import ru.fathutdinova.auctionengine.entity.Auction;
import ru.fathutdinova.auctionengine.entity.AuctionLot;
import ru.fathutdinova.auctionengine.exception.AuctionLotNotFoundException;
import ru.fathutdinova.auctionengine.mapper.DtoMapper;
import ru.fathutdinova.auctionengine.repository.AuctionLotRepository;
import ru.fathutdinova.auctionengine.repository.AuctionRepository;

import java.util.List;


@Component
@RequiredArgsConstructor
public class AuctionServiceImpl implements AuctionService{
    private final AuctionRepository auctionRepository;
    private final AuctionLotRepository auctionLotRepository;

    @Override
    public AuctionDto createAuction(AuctionDto auctionDto) {
//        AuctionLotDto auctionLotDto = DtoMapper.convertToAuctionLotDto(auctionDto.getAuctionLot());
//        AuctionLot auctionLot = auctionLotRepository.findById(auctionDto.getAuctionLotId()).orElseThrow(new SupplierServiceImpl(auctionDto.getAuctionLotId()));
        AuctionLot auctionLot = auctionLotRepository.findById(auctionDto.getAuctionLotId()).orElseThrow(() -> new AuctionLotNotFoundException("AuctionLot with id" + auctionDto.getAuctionLotId() + "is not found"));

        Auction auction = convertToAuction(auctionDto, auctionLot);
        Auction savedAuction = auctionRepository.save(auction);
        return DtoMapper.convertToAuctionDto(savedAuction);
    }
    private Auction convertToAuction(AuctionDto auctionDto, AuctionLot auctionLot) {
        Auction auction = new Auction();
        auction.setStartTime(auctionDto.getStartTime());
        auction.setAuctionLot(auctionLot);
        return auction;
    }

}
