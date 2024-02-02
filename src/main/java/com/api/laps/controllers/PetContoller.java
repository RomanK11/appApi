package com.api.laps.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.laps.models.Pet;
import com.api.laps.models.User;
import com.api.laps.repos.PetRepository;
import com.api.laps.repos.UserRepository;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "api/pets", produces = "application/json")
public class PetContoller {
    private PetRepository petRepository;
    private UserRepository userRepository;

    public PetContoller(PetRepository petRepository, UserRepository userRepository) {
        this.petRepository = petRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/addPet/{username}")
    public Pet createPet(@RequestBody Pet pet, @PathVariable String username) {
        User user = userRepository.findByNickname(username);
        pet.setUser_id(null);
        pet.setUser_id(user.getId());
        return petRepository.save(pet);
    }
    
    @GetMapping("/getPet/{username}")
    public Pet getPetByUsername(@PathVariable String username) {
        User user = userRepository.findByNickname(username);
        return petRepository.searchByUser_id(user.getId());
    }
    
}
