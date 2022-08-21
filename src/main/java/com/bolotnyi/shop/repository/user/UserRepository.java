package com.bolotnyi.shop.repository.user;

import com.bolotnyi.shop.model.user.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
