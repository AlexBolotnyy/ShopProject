package com.example.demo.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class User {

    @Column(name = "id", columnDefinition = "ID")
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
