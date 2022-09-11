package com.bolotnyi.shop.service.book;

import com.bolotnyi.shop.model.book.dto.BookCreateDto;

public interface BookService {

    void addNewBook(BookCreateDto createDto);
}
