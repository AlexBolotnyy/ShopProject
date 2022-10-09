package com.bolotnyi.shop.model.author.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class AuthorCreateDto {

    @NotNull
    private String name;
    @NotNull
    private String secondName;
    private String patronymic;
}
