package ru.fathutdinova.auctionengine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.fathutdinova.auctionengine.entity.Role;
import ru.fathutdinova.auctionengine.entity.RoleEntity;
import ru.fathutdinova.auctionengine.entity.User;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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
    default User createUser(User user, Set<Role> roles) {
        createUser(user.getLogin(), user.getPassword(), user.getFullName(), user.getBalance());
        User createdUser = findUserByLogin(user.getLogin());
        Set<String> roleSet = roles.stream()
                .map(Role::name)
                .collect(Collectors.toSet());
        addRolesToUser(createdUser.getId(), roleSet);
        Set<RoleEntity> roleEntitySet = new HashSet<>();
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setName();
        roleEntitySet.add()
        createdUser.setRoles();
        return createdUser;
    }
}
