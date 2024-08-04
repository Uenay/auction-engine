package ru.fathutdinova.auctionengine.service;


import ru.fathutdinova.auctionengine.exception.AuctionLotNotFoundException;

import java.util.function.Supplier;

public class SupplierServiceImpl implements Supplier<AuctionLotNotFoundException> {
    private int id;

    public SupplierServiceImpl(int id) {
        this.id = id;
    }

    @Override
    public AuctionLotNotFoundException get() {
        AuctionLotNotFoundException auctionLotNotFoundException = new AuctionLotNotFoundException("AuctionLot with id" + id + "is not found");
        return auctionLotNotFoundException;
    }
}
