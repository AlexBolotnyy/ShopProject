package com.bolotnyi.shop.service.purchase;

import com.bolotnyi.shop.model.purshase.dto.PurchaseHistoryDto;

import java.util.List;

public interface PurchaseService {

    void createNewPurchase();

    List<PurchaseHistoryDto> getPurchaseHistory();

}
