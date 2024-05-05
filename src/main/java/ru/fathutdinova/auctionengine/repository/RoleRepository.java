package ru.fathutdinova.auctionengine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.fathutdinova.auctionengine.entity.RoleEntity;
@Repository
public interface RoleRepository extends JpaRepository<RoleRepository, Long> {
    RoleEntity findByName(String name);
}
