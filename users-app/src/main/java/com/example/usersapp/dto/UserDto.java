package com.example.usersapp.dto;

import com.example.usersapp.entity.PhoneNumber;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class UserDto {

    private Long id;
    private String username;
    private List<PhoneNumber> phoneNumbers;
}

