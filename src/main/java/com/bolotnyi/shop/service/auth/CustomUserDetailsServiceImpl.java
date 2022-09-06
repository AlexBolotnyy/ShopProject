package com.bolotnyi.shop.service.auth;

import com.bolotnyi.shop.model.user.ShopUser;
import com.bolotnyi.shop.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {

    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return repository.findByLogin(userName)
                .map(shopUser -> User.builder()
                        .username(shopUser.getLogin())
                        .password(shopUser.getPassword())
                        .roles(shopUser.getRole())
                        .build())
                .orElseThrow(() -> new UsernameNotFoundException("Unknown user: " + userName));
    }

    @Override
    public ShopUser getCurrentUser() {
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        return repository.findByLogin(login).orElseThrow(() -> new UsernameNotFoundException(""));
    }
}
