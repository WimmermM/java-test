package com.example.usersapp.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "phone_new", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString(of = {"id", "phoneNumber"})
public class PhoneNumber {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "phone_number")
    private String phoneNumber;
}
