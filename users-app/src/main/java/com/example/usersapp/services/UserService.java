package com.example.usersapp.services;

import com.example.usersapp.dto.UserDto;
import com.example.usersapp.entity.User;
import com.example.usersapp.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public List<User> getAllUsers() {
         return userRepo.findAll();
    }

    public User createUser(User user) {
        return userRepo.save(user);
    }

    public User updateUser(Long id, User newUser) {
        return userRepo.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setPhoneNumbers(newUser.getPhoneNumbers());
                    return userRepo.save(newUser);
                }).orElseGet(() -> {
                    newUser.setId(id);
                    return userRepo.save(newUser);
                });
    }

    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }
}
