package com.bolotnyi.shop.model.user;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "shop_user")
public class ShopUser {

    @Column(name = "id", columnDefinition = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login", columnDefinition = "логин")
    private String login;

    @Column(name = "password", columnDefinition = "пароль")
    private String password;

    @Column(name = "role", columnDefinition = "роль")
    private String role;

    @Column(name = "name", columnDefinition = "имя")
    private String name;

    @Column(name = "second_name", columnDefinition = "фамилия")
    private String secondName;

    @Column(name = "email", columnDefinition = "email")
    private String email;

    @Column(name = "phone", columnDefinition = "номер телефона")
    private String phone;
}
