package com.api.laps.repos;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.api.laps.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
    @Query("SELECT * FROM users WHERE email = :nickname AND password = :password")
    Boolean findByNicknameAndPassword(@Param("nickname") String nickname, @Param("password") String password);

    @Query("SELECT * FROM users WHERE nickname = :nickname AND password = :password")
    User searchByNicknameAndPassword(@Param("nickname") String nickname, @Param("password") String password);

    @Query("SELECT * FROM users WHERE nickname = :nickname")
    User searchByNickname(@Param("nickname") String nickname);

    @Query("SELECT * FROM users WHERE nickname = :nickname")
    <Optional> User findByNickname(@Param("nickname") String nickname);

    @Query("SELECT * FROM users WHERE email = :email")
    User findByEmail(@Param("email") String email);
}