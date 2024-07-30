package ru.fathutdinova.auctionengine.api.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class NotFoundResponse extends BaseResponse{
}
