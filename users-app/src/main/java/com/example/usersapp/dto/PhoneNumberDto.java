package com.example.usersapp.dto;

import com.example.usersapp.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhoneNumberDto {

    private Long id;
    private User user;
    private String phoneNumber;
}
