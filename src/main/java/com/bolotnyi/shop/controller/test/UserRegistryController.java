package com.bolotnyi.shop.controller.test;

import com.bolotnyi.shop.model.user.UserDto;
import com.bolotnyi.shop.service.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registry")
@RequiredArgsConstructor
public class UserRegistryController {

    private final UserService userService;

    @PostMapping("/createNewUser")
    @Operation(description = "Добавление нового пользователя")
    public void createNewUser(@ParameterObject UserDto userDto) {
        userService.createNewUser(userDto);
    }
}
