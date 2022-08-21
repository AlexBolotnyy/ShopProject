package com.bolotnyi.shop.service.user;

import com.bolotnyi.shop.model.user.User;
import com.bolotnyi.shop.model.user.UserDto;
import com.bolotnyi.shop.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void addNewUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setSecondName(userDto.getSecondName());
        userRepository.save(user);
    }
}
