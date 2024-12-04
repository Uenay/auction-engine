package ru.fathutdinova.auctionengine.exception;

import org.springframework.dao.DataIntegrityViolationException;

public class AuctionLotNotFoundException extends DataIntegrityViolationException {
    public AuctionLotNotFoundException(String msg) {
        super(msg);
    }
}
