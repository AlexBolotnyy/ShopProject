package com.bolotnyi.shop.model.basket.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BasketShowDto {

    private BigDecimal totalPrice;
    private List<BasketPositionShowDto> showDto;
}
