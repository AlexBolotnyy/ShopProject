package com.bolotnyi.shop.model.user;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class UserDto {

    @NotNull
    private String name;

    @NotNull
    private String secondName;

    @NotNull
    @Email(message = "некорректный Email")
    private String email;

//    @Min(value = 11, message = "некорректно указан номер телефона")
//    @Max(value = 12, message = "некорректно указан номер телефона")
    @NotNull
    private String phone;
}
