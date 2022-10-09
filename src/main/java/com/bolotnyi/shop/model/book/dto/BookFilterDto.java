package com.bolotnyi.shop.model.book.dto;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Schema(description = "Данные для фильтрации каталога")
public class BookFilterDto {

    @Parameter(description = "Наименование")
    private String title;

    @Parameter(description = "Дата публикации с", example = "1555/01/01 00:00:00")
    private Date publishDate;

    @Parameter(description = "В наличии")
    private Boolean availability;

    @Parameter(description = "Имя автора")
    private String authorName;

    @Parameter(description = "ID жанра")
    private List<Long> genre;
}
