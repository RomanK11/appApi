package com.api.laps.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.laps.email.EmailSender;
import com.api.laps.models.User;
import com.api.laps.repos.UserRepository;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "api/users", produces = "application/json")
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    EmailSender emailSender = new EmailSender();

    public boolean existsByField(String fieldValue1, String fieldValue2) {
        return userRepository.findByNicknameAndPassword(fieldValue1, fieldValue2) != null;
    }

    @PostMapping(path = "/registr")
    public User create(@RequestBody User user) {
        
        return userRepository.save(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return userRepository.searchByNicknameAndPassword(user.getNickname(), user.getPassword());
    }

    //Добавление email пользователю
    @PostMapping("/add-email/{nickname}")
    public ResponseEntity<String> addEmail(@PathVariable String nickname, @RequestBody String value) {
        User user = userRepository.searchByNickname(nickname);
        if (user != null) {
            user.setEmail(value);
            emailSender.sendEmail(user.getEmail(), "Subject");
            userRepository.save(user);
            return ResponseEntity.ok("Значение успешно добавлено в колонку пользователя с email: " + nickname);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/accept/{email}")
    public String getMethodName(@PathVariable String email) {
        User user = userRepository.findByEmail(email); // Предположим, у вас есть метод findByEmail в UserRepository для поиска пользователя по email
        user.setAcceptType(null);
        user.setAcceptType("1");
        userRepository.save(user);
        return "true";
    }
    
    @DeleteMapping(path = "/delete-user/{nickname}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("nickname") String nickname) {
        userRepository.delete(userRepository.searchByNickname(nickname));
    }

}
