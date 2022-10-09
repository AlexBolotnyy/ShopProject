package com.bolotnyi.shop.repository;

import com.bolotnyi.shop.model.basket.Basket;
import com.bolotnyi.shop.model.user.ShopUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BasketRepository extends JpaRepository<Basket, Long> {
}
