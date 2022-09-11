package com.bolotnyi.shop.service.author;

import com.bolotnyi.shop.model.author.dto.AuthorCreateDto;
import com.bolotnyi.shop.model.author.dto.AuthorShowDto;

import java.util.List;

public interface AuthorService {

    void addNewAuthor(AuthorCreateDto createDto);
    List<AuthorShowDto> getAuthorShowDtoList(String name);
}
