package com.example.usersapp.dto;

import com.example.usersapp.entity.User;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString(of = "phoneNumber")
public class PhoneNumberDto {

    private Long userID;
    private String phoneNumber;
}
