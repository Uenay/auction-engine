package ru.fathutdinova.auctionengine.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

public interface AuctionController {
    @PostMapping("/auction/create")
    CreateAuctionResponse createAuction(@RequestBody CreateAuctionRequest createAuctionRequest);

    @PostMapping("/auctionLot/create")
    CreateAuctionLotResponse createAuctionLot(@RequestBody CreateAuctionLotRequest createAuctionLotRequest);

    @GetMapping("/auction/get")
    ResponseEntity<GetAuctionResponse> getAuctionResponseById(@RequestBody ByIdRequest byIdRequest);

    @GetMapping("/auctionLot/get")
    ResponseEntity<GetAuctionLotResponse> getAuctionLotById(@RequestBody ByIdRequest byIdRequest);

    @PostMapping("/auction/update")
    ResponseEntity<UpdateAuctionResponse> updateAuction(@RequestBody UpdateAuctionRequest updateAuctionRequest);

    @PostMapping("/auctionLot/update")
    ResponseEntity<UpdateAuctionLotResponse> updateAuctionLot(@RequestBody UpdateAuctionLotRequest updateAuctionLotRequest);

    @DeleteMapping("/auction/delete")
    ResponseEntity<Void> deleteAuction(@RequestBody ByIdRequest byIdRequest);

    @DeleteMapping("/auctionLot/delete")
    ResponseEntity<Void> deleteAuctionLot(@RequestBody ByIdRequest byIdRequest);
}
