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

    public User updateUser(User newUser) {
        var testUserOpt = userRepo.findById(newUser.getId());

        if (testUserOpt.isPresent()) {
            var testUser = testUserOpt.get();
            testUser.setUsername(newUser.getUsername());
            testUser.setPhoneNumbers(newUser.getPhoneNumbers());
            return userRepo.save(testUser);
        }

        throw new IllegalArgumentException("No user found");
    }

    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }
}
