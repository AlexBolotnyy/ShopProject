package com.bolotnyi.shop.model.book.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class BookCreateDto {

    private List<Long> genresList;

    @NotNull
    private String title;
    @NotNull
    private Long authorId;
    @NotNull
    private String publishDate;

}
