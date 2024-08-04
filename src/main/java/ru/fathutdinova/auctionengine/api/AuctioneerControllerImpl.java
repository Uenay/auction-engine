package ru.fathutdinova.auctionengine.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RestController;
import ru.fathutdinova.auctionengine.api.request.ByIdRequest;
import ru.fathutdinova.auctionengine.api.request.CreateAuctionRequest;
import ru.fathutdinova.auctionengine.api.request.UpdateAuctionRequest;
import ru.fathutdinova.auctionengine.api.response.CreateAuctionResponse;
import ru.fathutdinova.auctionengine.api.response.UpdateAuctionResponse;
import ru.fathutdinova.auctionengine.dto.AuctionDto;
import ru.fathutdinova.auctionengine.dto.AuctionLotDto;
import ru.fathutdinova.auctionengine.entity.AuctionLot;
import ru.fathutdinova.auctionengine.mapper.DtoMapper;
import ru.fathutdinova.auctionengine.service.AuctionLotService;
import ru.fathutdinova.auctionengine.service.AuctionService;

@RestController
@RequiredArgsConstructor
public class AuctioneerControllerImpl implements AuctioneerController {
    private final AuctionService auctionService;
    private final AuctionLotService auctionLotService;
    @Override
    public CreateAuctionResponse createAuction(CreateAuctionRequest createAuctionRequest) {
        AuctionLotDto auctionLotDto = auctionLotService.getAuctionLotById(createAuctionRequest.getAuctionLotId());
        AuctionLot auctionLot = DtoMapper.convertToAuctionLot(auctionLotDto);
        AuctionDto auctionDto = AuctionDto.builder()
                .startTime(createAuctionRequest.getStartTime())
                .auctionLot(auctionLot)
                .build();
        AuctionDto savedAuction = auctionService.createAuction(auctionDto);
        return DtoMapper.convertToCreateAuctionResponse(savedAuction);
    }


    @Override
    public UpdateAuctionResponse updateAuction(UpdateAuctionRequest updateAuctionRequest) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteAuction(ByIdRequest byIdRequest) {
        return null;
    }

}
