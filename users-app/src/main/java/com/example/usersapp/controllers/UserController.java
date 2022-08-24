package com.example.usersapp.controllers;

import com.example.usersapp.convertor.UserConvertor;
import com.example.usersapp.dto.UserDto;
import com.example.usersapp.entity.User;
import com.example.usersapp.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.example.usersapp.convertor.UserConvertor.toDto;
import static com.example.usersapp.convertor.UserConvertor.toEntity;

@RestController
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/user")
    public List<UserDto> getAllUsers() {
        List<User> userList = userService.getAllUsers();
        return userList.stream()
                .map(UserConvertor::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public UserDto createUser(@RequestBody UserDto userDto) {
        if (userDto.getId() != null) {
            throw new IllegalArgumentException("User id must be null");
        }
        User user = toEntity(userDto);
        User userCreated = userService.createUser(user);
        return toDto(userCreated);
    }

    @PutMapping(value = "/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateUser(@PathVariable("id") Long id, @RequestBody UserDto userDto) {
        if (!Objects.equals(id, userDto.getId())) {
            throw new IllegalArgumentException("IDs don't match");
        }
        User user = toEntity(userDto);
        userService.updateUser(user);
    }


    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
