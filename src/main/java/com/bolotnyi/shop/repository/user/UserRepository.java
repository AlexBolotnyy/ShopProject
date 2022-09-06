package com.bolotnyi.shop.repository.user;

import com.bolotnyi.shop.model.user.ShopUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<ShopUser, Long> {
    Optional<ShopUser> findByLogin(String login);
}
