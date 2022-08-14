package com.example.demo.model.user;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "shop_user")
public class User {

    @Column(name = "id", columnDefinition = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", columnDefinition = "имя")
    private String name;

    @Column(name = "second_name", columnDefinition = "фамилия")
    private String secondName;

    @Column(name = "email", columnDefinition = "email")
    private String email;

    @Column(name = "phone", columnDefinition = "номер телефона")
    private String phone;
}
