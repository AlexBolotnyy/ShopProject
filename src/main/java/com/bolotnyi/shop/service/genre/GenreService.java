package com.bolotnyi.shop.service.genre;

import com.bolotnyi.shop.model.genre.dto.GenreShowDto;

import java.util.List;

public interface GenreService {

    void addNewGenre(String title);

    List<GenreShowDto> getGenreList();
}
