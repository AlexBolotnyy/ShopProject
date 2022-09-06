package com.bolotnyi.shop.service.user;

import com.bolotnyi.shop.model.exception.BusinessException;
import com.bolotnyi.shop.model.user.ShopUser;
import com.bolotnyi.shop.model.user.UserDto;
import com.bolotnyi.shop.repository.user.UserRepository;
import com.bolotnyi.shop.service.auth.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CustomUserDetailsService userDetailsService;

    @Override
    public void createNewUser(UserDto dto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        validLogin(dto.getLogin());
        validPasswords(dto.getPassword(), dto.getConfirmPassword());
        ShopUser user = new ShopUser();
        user.setName(dto.getName());
        user.setSecondName(dto.getSecondName());
        user.setLogin(dto.getLogin());
        user.setPassword(encoder.encode(dto.getPassword()));
        user.setRole("USER");
        user.setPhone(dto.getPhone());
        user.setEmail(dto.getEmail());
        userRepository.save(user);
    }

    private void validLogin(String login) {
        userRepository.findByLogin(login).ifPresent(i -> {
            throw new BusinessException("Пользователь с таким именем уже существует");
        });
    }

    private void validPasswords(String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            throw new BusinessException("Пароли не совпадают");
        }
    }

    @Override
    public String userInfo() {
        return userDetailsService.getCurrentUser().getLogin();
    }
}
