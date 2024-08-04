package ru.fathutdinova.auctionengine.api;

import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RestController;
import ru.fathutdinova.auctionengine.api.request.ByIdRequest;
import ru.fathutdinova.auctionengine.api.request.CreateAuctionRequest;
import ru.fathutdinova.auctionengine.api.request.UpdateAuctionRequest;
import ru.fathutdinova.auctionengine.api.response.BaseResponse;
import ru.fathutdinova.auctionengine.api.response.CreateAuctionResponse;
import ru.fathutdinova.auctionengine.api.response.NotFoundResponse;
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
    public ResponseEntity<BaseResponse> createAuction(CreateAuctionRequest createAuctionRequest){
        BaseResponse baseResponse;
        AuctionDto auctionDto = AuctionDto.builder()
                .startTime(createAuctionRequest.getStartTime())
                .auctionLotId(createAuctionRequest.getAuctionLotId())
                .build();
        AuctionDto savedAuction = auctionService.createAuction(auctionDto);
        baseResponse = DtoMapper.convertToCreateAuctionResponse(savedAuction);


        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
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
