package ru.fathutdinova.auctionengine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.fathutdinova.auctionengine.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
