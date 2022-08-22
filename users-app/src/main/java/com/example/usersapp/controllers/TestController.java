package com.example.usersapp.controllers;

import com.example.usersapp.dto.UserDto;
import com.example.usersapp.entity.User;
import com.example.usersapp.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequiredArgsConstructor
public class TestController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @GetMapping(value = "/test")
    public String testEndpoint() {
        String message = "test endpoint was called";
        log.info(message);
        return message;
    }

    @GetMapping(value = "/user")
    public List<UserDto> getAllUsers() {
        List<User> userList = userService.getAllUsers();
        return userList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public UserDto createUser(@RequestBody UserDto userDto) {
        User user = convertToEntity(userDto);
        User userCreated = userService.createUser(user);
        return convertToDto(userCreated);
    }

    @PutMapping(value = "/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateUser(@PathVariable("id") Long id, @RequestBody UserDto userDto) {
        if (!Objects.equals(id, userDto.getId())) {
            throw new IllegalArgumentException("IDs don't match");
        }
        User user = convertToEntity(userDto);
        userService.updateUser(id, user);
    }


    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    private UserDto convertToDto(User user) {
        UserDto userDto = modelMapper.map(user, UserDto.class);
        return userDto;
    }

    private User convertToEntity(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        return user;
    }
}
