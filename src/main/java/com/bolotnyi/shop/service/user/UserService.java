package com.bolotnyi.shop.service.user;

import com.bolotnyi.shop.model.user.UserDto;

public interface UserService {

    void createNewUser(UserDto str);

    String userInfo();
}
