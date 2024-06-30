package ru.fathutdinova.auctionengine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.fathutdinova.auctionengine.entity.RoleEntity;

import java.util.List;
import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
    List<RoleEntity> findByNameIn(Set<String> roleNames);
}
