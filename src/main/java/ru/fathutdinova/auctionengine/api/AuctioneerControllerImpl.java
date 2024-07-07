package ru.fathutdinova.auctionengine.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RestController;
import ru.fathutdinova.auctionengine.api.request.ByIdRequest;
import ru.fathutdinova.auctionengine.api.request.CreateAuctionLotRequest;
import ru.fathutdinova.auctionengine.api.request.CreateAuctionRequest;
import ru.fathutdinova.auctionengine.api.request.UpdateAuctionRequest;
import ru.fathutdinova.auctionengine.api.response.CreateAuctionLotResponse;
import ru.fathutdinova.auctionengine.api.response.CreateAuctionResponse;
import ru.fathutdinova.auctionengine.api.response.UpdateAuctionResponse;

@RestController
@RequiredArgsConstructor
public class AuctioneerControllerImpl implements AuctioneerController {
    @Override
    public CreateAuctionResponse createAuction(CreateAuctionRequest createAuctionRequest) {
        return null;
    }

    @Override
    public CreateAuctionLotResponse createAuctionLot(CreateAuctionLotRequest createAuctionLotRequest) {
        return null;
    }

    @Override
    public UpdateAuctionResponse updateAuction(UpdateAuctionRequest updateAuctionRequest) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteAuction(ByIdRequest byIdRequest) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteAuctionLot(ByIdRequest byIdRequest) {
        return null;
    }
}
