package com.bolotnyi.shop.controller.book;

import com.bolotnyi.shop.model.book.dto.BookCreateDto;
import com.bolotnyi.shop.service.book.BookService;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/add-new-book")
    public void addNewBook(@ParameterObject BookCreateDto createDto) {
        bookService.addNewBook(createDto);
    }
}
