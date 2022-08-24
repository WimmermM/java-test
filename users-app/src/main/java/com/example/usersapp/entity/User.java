package com.example.usersapp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_new", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<PhoneNumber> phoneNumbers;
}
