package com.bolotnyi.shop.repository.book;

import com.bolotnyi.shop.model.book.Book;
import com.bolotnyi.shop.model.book.dto.BookFilterDto;

import java.util.List;

public interface BookCustomRepository {

    List<Book> getListByFilter(BookFilterDto filterDto);
}
