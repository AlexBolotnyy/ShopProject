package com.bolotnyi.shop.controller.author;

import com.bolotnyi.shop.model.author.dto.AuthorCreateDto;
import com.bolotnyi.shop.model.author.dto.AuthorShowDto;
import com.bolotnyi.shop.service.author.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping("/add-new-author")
    public void addNewAuthor(AuthorCreateDto createDto) {
        authorService.addNewAuthor(createDto);
    }

    @GetMapping("/get-author-list")
    public List<AuthorShowDto> getAuthorShowDtoList(@RequestParam (required = false) String name) {
        return authorService.getAuthorShowDtoList(name);
    }
}
