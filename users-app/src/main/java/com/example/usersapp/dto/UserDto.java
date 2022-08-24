package com.example.usersapp.dto;

import com.example.usersapp.entity.PhoneNumber;
import lombok.*;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserDto {

    private Long id;
    private String username;
    private List<String> phoneNumbers;
}

