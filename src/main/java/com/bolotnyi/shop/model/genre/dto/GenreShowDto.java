package com.bolotnyi.shop.model.genre.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GenreShowDto {

    private Long id;
    private String title;
}
