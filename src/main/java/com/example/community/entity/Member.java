package com.example.community.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long mno;

    @Column(length = 40, nullable = false, unique = true)
    private String id;

    @Column(length = 80, nullable = false)
    private String pw;

    @Column(length = 30, nullable = false)
    private String name;

    @Column(length = 60, nullable = false)
    private String address;

    @Column(length = 80, nullable = false)
    private String birthdate;

}
