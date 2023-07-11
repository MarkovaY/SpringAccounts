package com.example.springaccounts.services;

import com.example.springaccounts.models.User;
import com.example.springaccounts.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(User user) {
        Optional<User> findByName = userRepository.findByName(user.getName());

        if(findByName.isPresent()){
            throw new IllegalArgumentException("User already exists");
        }

        userRepository.save(user);
    }
}
