package com.bolotnyi.shop.model.user.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserDto {

    @NotNull
    private String name;

    @NotNull
    private String secondName;

    @NotNull
    private String login;

    @NotNull
    private String password;

    @NotNull
    private String confirmPassword;

    @NotNull
    private String email;

    @NotNull
    private String phone;
}
