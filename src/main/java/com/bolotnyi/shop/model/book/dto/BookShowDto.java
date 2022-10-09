package com.bolotnyi.shop.model.book.dto;

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
public class BookShowDto {

    private Long id;
    private String title;
    private String authorName;
    private List<String> genresList;
    private Long amount;
    private BigDecimal price;
}
