package com.bolotnyi.shop.controller.user;

import com.bolotnyi.shop.model.common.EnumDto;
import com.bolotnyi.shop.service.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/info")
    @Operation(description = "получение списка пользователей")
    public EnumDto info() {
        return userService.userInfo();
    }

}
