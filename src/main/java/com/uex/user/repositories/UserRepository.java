package com.uex.user.repositories;

import com.uex.user.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {

//    <UserModel> void findByJwtToken(String loggedToken) {
//    }

    Optional<UserModel> findByUsername(String username);
}
