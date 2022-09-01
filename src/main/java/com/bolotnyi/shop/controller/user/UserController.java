package com.bolotnyi.shop.controller.user;

import com.bolotnyi.shop.model.user.UserDto;
import com.bolotnyi.shop.service.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-controller")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/createNewUser")
    @Operation(description = "Добавление нового пользователя")
    public void save(@ParameterObject @RequestBody UserDto userDto) {
        userService.addNewUser(userDto);
    }

    @GetMapping("/user-info")
    @Operation(description = "получение списка пользователей")
    public List<UserDto> info(UserDto filter) {
        return null;
    }
}
