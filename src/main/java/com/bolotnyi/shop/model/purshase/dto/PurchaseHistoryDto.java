package com.bolotnyi.shop.model.purshase.dto;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Schema(description = "История покупки")
public class PurchaseHistoryDto {

    @Parameter(description = "общая стоимость")
    private BigDecimal totalPrice;

    @Parameter(description = "Книги")
    private List<BookFromPurchaseHistoryDto> books;

}
