package com.bolotnyi.shop.model.book.dto;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Schema(description = "Данные для создания новой книги")
public class BookCreateDto {

    private List<Long> genresList;

    @NotNull
    @Parameter(description = "Наименование книги")
    private String title;
    @NotNull
    @Parameter(description = "ID автора")
    private Long authorId;
    @NotNull
    @Parameter(description = "Дата публикации")
    private String publishDate;
    @Parameter(description = "Количество")
    private Long amount;
}
