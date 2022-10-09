package com.bolotnyi.shop.service.user;

import com.bolotnyi.shop.model.common.EnumDto;
import com.bolotnyi.shop.model.user.dto.UserDto;

public interface UserService {

    void createNewUser(UserDto str);

    EnumDto userInfo();
}
