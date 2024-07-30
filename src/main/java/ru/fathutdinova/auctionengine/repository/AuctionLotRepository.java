package ru.fathutdinova.auctionengine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.fathutdinova.auctionengine.entity.AuctionLot;

@Repository
public interface AuctionLotRepository extends JpaRepository<AuctionLot, Integer> {
}
