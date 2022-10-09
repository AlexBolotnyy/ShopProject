package com.bolotnyi.shop.model.purshase.dto;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Книга")
public class BookFromPurchaseHistoryDto {

    @Parameter(description = "ID книги")
    private Long bookId;

    @Parameter(description = "Количество")
    private Long amount;
}
