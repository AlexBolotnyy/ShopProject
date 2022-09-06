package com.bolotnyi.shop.service.auth;

import com.bolotnyi.shop.model.user.ShopUser;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface CustomUserDetailsService extends UserDetailsService {

    ShopUser getCurrentUser();
}
