package ru.fathutdinova.auctionengine.exception;

import org.springframework.dao.DataIntegrityViolationException;

public class DuplicatedUserLoginException extends DataIntegrityViolationException {
    public DuplicatedUserLoginException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
