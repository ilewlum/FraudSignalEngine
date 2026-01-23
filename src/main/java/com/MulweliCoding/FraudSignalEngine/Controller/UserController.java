package com.MulweliCoding.FraudSignalEngine.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.MulweliCoding.FraudSignalEngine.Model.User;
import com.MulweliCoding.FraudSignalEngine.Repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/")
    public User addUser(@RequestBody UserDTO user) {
        User newUser = new User(user.getUserId(), user.getName(), user.getEmail(), user.getPhoneNumber(), user.getRegion());
        return userRepository.save(newUser);
    }   
}
