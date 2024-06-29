package ru.fathutdinova.auctionengine.repository;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.fathutdinova.auctionengine.entity.RoleEntity;
import ru.fathutdinova.auctionengine.entity.User;
import ru.fathutdinova.auctionengine.exception.DuplicatedUserLoginException;

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
    default User createUser(User user, Set<RoleEntity> roleEntities) {
        try {
            createUser(user.getLogin(), user.getPassword(), user.getFullName(), user.getBalance());
        } catch (DataIntegrityViolationException ex) {
            throw new DuplicatedUserLoginException("Логин пользьзователя уже используется", ex.getCause());
        }

        User createdUser = findUserByLogin(user.getLogin());
        createdUser.setRoles(roleEntities);
        return createdUser;
    }
}
