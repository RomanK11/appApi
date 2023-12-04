package com.api.laps.repos;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.api.laps.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
    @Query("SELECT * FROM users WHERE email = :email AND password = :password")
    Boolean findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    @Query("SELECT * FROM users WHERE email = :email AND password = :password")
    User searchByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}
