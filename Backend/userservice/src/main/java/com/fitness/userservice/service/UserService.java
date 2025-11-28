package com.fitness.userservice.service;

import com.fitness.userservice.dto.RegisterRequest;
import com.fitness.userservice.dto.UserResponse;
import com.fitness.userservice.model.User;
import com.fitness.userservice.repository.UserRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse createUser(RegisterRequest registerRequest) {

        if(userRepository.existsByEmail(registerRequest.getEmail())) throw new RuntimeException("Email already exists");

        User user = new User();
        user.setEmail(registerRequest.getEmail());
        user.setPassword(registerRequest.getPassword());
        user.setFirstName(registerRequest.getFirsName());
        user.setLastName(registerRequest.getLastName());

        User savedUser = userRepository.save(user);
        return new UserResponse(
                savedUser.getId(),
                savedUser.getEmail(),
                savedUser.getPassword(),
                savedUser.getFirstName(),
                savedUser.getLastName(),
                savedUser.getCreatedAt(),
                savedUser.getUpdatedAt()
        );
    }

    public UserResponse getUserProfile(String userId) {
        
        User foundUser = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("user not found"));

        return new UserResponse(
                foundUser.getId(),
                foundUser.getEmail(),
                foundUser.getPassword(),
                foundUser.getFirstName(),
                foundUser.getLastName(),
                foundUser.getCreatedAt(),
                foundUser.getUpdatedAt()

        );
        
    }
}
