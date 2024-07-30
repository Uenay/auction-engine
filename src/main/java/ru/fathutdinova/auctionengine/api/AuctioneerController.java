package ru.fathutdinova.auctionengine.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.fathutdinova.auctionengine.api.request.ByIdRequest;
import ru.fathutdinova.auctionengine.api.request.CreateAuctionRequest;
import ru.fathutdinova.auctionengine.api.request.UpdateAuctionRequest;
import ru.fathutdinova.auctionengine.api.response.CreateAuctionResponse;
import ru.fathutdinova.auctionengine.api.response.UpdateAuctionResponse;

public interface AuctioneerController {
    @PostMapping("/auction/create")
    CreateAuctionResponse createAuction(@RequestBody CreateAuctionRequest createAuctionRequest);


    @PostMapping("/auction/update")
    UpdateAuctionResponse updateAuction(@RequestBody UpdateAuctionRequest updateAuctionRequest);

    @DeleteMapping("/auction/delete")
    ResponseEntity<Void> deleteAuction(@RequestBody ByIdRequest byIdRequest);

}
