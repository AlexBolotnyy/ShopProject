package com.bolotnyi.shop.model.basket.dto;

import com.bolotnyi.shop.model.book.dto.BookShowDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BasketPositionShowDto {

    private Long amount;
    private BookShowDto showDto;
}
