package ru.fathutdinova.auctionengine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fathutdinova.auctionengine.entity.AuctionLot;

public interface ImageRepository extends JpaRepository<AuctionLot, Integer> {
}
