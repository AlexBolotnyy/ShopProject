package com.bolotnyi.shop.repository.purchase;

import com.bolotnyi.shop.model.purshase.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
