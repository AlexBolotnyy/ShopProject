package com.bolotnyi.shop.controller.book;

import com.bolotnyi.shop.model.book.dto.BookCreateDto;
import com.bolotnyi.shop.model.book.dto.BookUpdateDto;
import com.bolotnyi.shop.service.book.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
@Tag(name = "Книги")
public class BookController {

    private final BookService bookService;

    @PostMapping("/add-new-book")
    @Operation(summary = "Добавление новой книги")
    public void addNewBook(@ParameterObject BookCreateDto createDto) {
        bookService.addNewBook(createDto);
    }

    @PutMapping("/update-exist-book")
    @Operation(summary = "Редактирование существующей книги")
    public void updateExistBook(@ParameterObject BookUpdateDto updateDto) {
        bookService.updateExist(updateDto);
    }

}
