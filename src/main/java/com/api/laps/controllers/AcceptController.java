package com.api.laps.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.api.laps.repos.UserRepository;



@CrossOrigin(origins = "*")
@Controller
@RequestMapping(path = "api/users", produces = "application/json")
public class AcceptController {
    private UserRepository userRepository;

//     @GetMapping("/accept/{email}")
//     public String getMethodName() {
//         return "accept";
//     }
    
//     @PostMapping("/accept/{email}")
// public String addValueToColumn(@PathVariable String email, @RequestBody String value) {
//     User user = userRepository.findByEmail(email); // Предположим, у вас есть метод findByEmail в UserRepository для поиска пользователя по email
//     if (user != null) {
//         user.setAcceptType(value);
//         userRepository.save(user);
//         return "true";
//     } else {
//         return "false";
//     }

}
