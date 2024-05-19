package ru.fathutdinova.auctionengine.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.fathutdinova.auctionengine.api.request.ByIdRequest;
import ru.fathutdinova.auctionengine.api.request.CreateAuctionLotRequest;
import ru.fathutdinova.auctionengine.api.request.CreateAuctionRequest;
import ru.fathutdinova.auctionengine.api.request.UpdateAuctionLotRequest;
import ru.fathutdinova.auctionengine.api.request.UpdateAuctionRequest;
import ru.fathutdinova.auctionengine.api.response.CreateAuctionLotResponse;
import ru.fathutdinova.auctionengine.api.response.CreateAuctionResponse;
import ru.fathutdinova.auctionengine.api.response.GetAuctionLotResponse;
import ru.fathutdinova.auctionengine.api.response.GetAuctionResponse;
import ru.fathutdinova.auctionengine.api.response.UpdateAuctionLotResponse;
import ru.fathutdinova.auctionengine.api.response.UpdateAuctionResponse;

@RestController
@RequiredArgsConstructor
public class AuctionControllerImpl implements AuctionController {
    @Override
    public CreateAuctionResponse createAuction(@RequestBody CreateAuctionRequest createAuctionRequest) {
        return null;
    }

    @Override
    public CreateAuctionLotResponse createAuctionLot(@RequestBody CreateAuctionLotRequest createAuctionLotRequest) {
        return null;
    }

    @Override
    public ResponseEntity<GetAuctionResponse> getAuctionResponseById(@RequestBody ByIdRequest byIdRequest) {
        return null;
    }

    @Override
    public ResponseEntity<GetAuctionLotResponse> getAuctionLotById(@RequestBody ByIdRequest byIdRequest) {
        return null;
    }

    @Override
    public ResponseEntity<UpdateAuctionResponse> updateAuction(@RequestBody UpdateAuctionRequest updateAuctionRequest) {
        return null;
    }

    @Override
    public ResponseEntity<UpdateAuctionLotResponse> updateAuctionLot(@RequestBody UpdateAuctionLotRequest updateAuctionLotRequest) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteAuction(@RequestBody ByIdRequest byIdRequest) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteAuctionLot(@RequestBody ByIdRequest byIdRequest) {
        return null;
    }
}
