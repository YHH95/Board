package com.example.community.entity;


import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class Board extends BaseEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bno;

    @Column(length = 150 , nullable = false)
    private String title;

    @Column(length = 2100 , nullable = false)
    private String content;

    @Column(length = 60 , nullable = false)
    private String writer;

}
