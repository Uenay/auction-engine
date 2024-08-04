package ru.fathutdinova.auctionengine.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.fathutdinova.auctionengine.api.response.NotFoundResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({AuctionLotNotFoundException.class})
    public NotFoundResponse handleValidationException(AuctionLotNotFoundException exception) {
        return NotFoundResponse.builder()
                .message(exception.getMessage())
                .build();

    }
}
