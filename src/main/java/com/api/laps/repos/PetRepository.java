package com.api.laps.repos;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.api.laps.models.Pet;
import com.api.laps.models.User;

public interface PetRepository extends CrudRepository<Pet, Long>{
    @Query("SELECT * FROM pets WHERE name = :name")
    User searchByName(@Param("name") String name);
}
