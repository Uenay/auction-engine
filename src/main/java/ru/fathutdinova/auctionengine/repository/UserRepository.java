package ru.fathutdinova.auctionengine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.fathutdinova.auctionengine.entity.Role;
import ru.fathutdinova.auctionengine.entity.User;

import java.beans.Transient;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByLogin(String login);

    @Query(value = "INSERT INTO USERS (login, password, full_name, balance) values (:login, :password, :fullName, :balance)",
            nativeQuery = true)
    @Modifying
    void createUser(String login, String password, String fullName, int balance);

    @Modifying
    @Query(value = "INSERT INTO role_to_user (user_id, role_id) SELECT :userId, r.id FROM role r WHERE r.name IN :roles",
            nativeQuery = true)
    void addRolesToUser(long userId, Set<String> roles);

    @Transactional
    default User createUser(User user, Set<String> roles) {
        createUser(user.getLogin(), user.getPassword(), user.getFullName(), user.getBalance());
        User createdUser = findUserByLogin(user.getLogin());
        addRolesToUser(createdUser.getId(), roles);
        return createdUser;
    }
}
