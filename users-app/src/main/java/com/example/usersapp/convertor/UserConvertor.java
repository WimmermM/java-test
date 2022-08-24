package com.example.usersapp.convertor;

import com.example.usersapp.dto.UserDto;
import com.example.usersapp.entity.PhoneNumber;
import com.example.usersapp.entity.User;
import org.springframework.util.StringUtils;

import java.util.ArrayList;

public class UserConvertor {

    public static User toEntity(UserDto userDto) {
        var user = User.builder()
                .id(userDto.getId())
                .username(userDto.getUsername())
                .phoneNumbers(new ArrayList<>())
                .build();

        var phoneNumbers = userDto.getPhoneNumbers().stream()
                .map(s -> PhoneNumber.builder()
                        .user(user)
                        .phoneNumber(s)
                        .build())
                .toList();

        user.getPhoneNumbers().addAll(phoneNumbers);
        return user;
    }


    public static UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .phoneNumbers(user.getPhoneNumbers().stream()
                        .map(PhoneNumber::getPhoneNumber)
                        .toList())
                .build();
    }
}
