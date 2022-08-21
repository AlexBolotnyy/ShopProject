package com.bolotnyi.shop.model.user;

import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    UserDto to(User user);
}
