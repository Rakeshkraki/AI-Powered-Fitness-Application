package com.fitness.userservice.controller;

import com.fitness.userservice.dto.RegisterRequest;
import com.fitness.userservice.dto.UserResponse;
import com.fitness.userservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userServices;

    public UserController(UserService userServices) {
        this.userServices = userServices;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable String id){
        return ResponseEntity.ok(userServices.getUserProfile(id));
    }

    @PostMapping
    public ResponseEntity<UserResponse> regiserUser(@Valid @RequestBody RegisterRequest userRequest) {
        return ResponseEntity.ok(userServices.createUser(userRequest));
    }


}
