package ru.fathutdinova.auctionengine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.fathutdinova.auctionengine.entity.Auction;

@Repository
public interface AuctionRepository extends JpaRepository<Auction, Integer> {
}
