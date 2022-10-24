package com.devandre.supportportalbackend.repository;

import com.devandre.supportportalbackend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repo for user
 *
 * @author Andre Gallegos
 * @create 2022-09-28 12:13
 **/
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUsername(String username);
    User findUserByEmail(String email);

}
