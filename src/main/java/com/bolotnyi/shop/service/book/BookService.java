package com.bolotnyi.shop.service.book;

import com.bolotnyi.shop.model.basket.dto.BasketShowDto;
import com.bolotnyi.shop.model.book.Book;
import com.bolotnyi.shop.model.book.dto.BookCreateDto;
import com.bolotnyi.shop.model.book.dto.BookFilterDto;
import com.bolotnyi.shop.model.book.dto.BookShowDto;
import com.bolotnyi.shop.model.book.dto.BookUpdateDto;

import java.util.List;

public interface BookService {

    void addNewBook(BookCreateDto createDto) throws RuntimeException;
    void updateExist(BookUpdateDto updateDto);
    List<BookShowDto> getCatalog(BookFilterDto filterDto);
    void addBookToBasket(Long id);
    BasketShowDto getBasketShowDto();

    void removeBookFromBasket(Long bookId);
    void clearBasket();
    void incrementBooksAmount(BasketShowDto showDto, List<Book> basket);
}
