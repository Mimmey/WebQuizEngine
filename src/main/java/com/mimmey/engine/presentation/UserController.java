package com.mimmey.engine.presentation;

import com.mimmey.engine.business.entities.User;
import com.mimmey.engine.business.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/api/register")
    public void register(@Valid @RequestBody User user) {
        if (userService.findAll().stream()
                .anyMatch(e -> e.getEmail().equals(user.getEmail()))) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userService.save(user);
    }
}
