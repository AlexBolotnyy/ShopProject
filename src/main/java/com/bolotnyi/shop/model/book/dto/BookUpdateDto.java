package com.bolotnyi.shop.model.book.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class BookUpdateDto {

    @NotNull
    private Long id;
    @NotNull
    private Long amount;

}
