package com.bolotnyi.shop.controller.genre;

import com.bolotnyi.shop.model.genre.dto.GenreShowDto;
import com.bolotnyi.shop.service.genre.GenreService;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genre")
@RequiredArgsConstructor
public class GenreController {

    private final GenreService genreService;

    @PostMapping("/add-new-genre")
    public void addNewGenre(@ParameterObject @RequestParam String title) {
        genreService.addNewGenre(title);
    }

    @GetMapping("/get-genre-list")
    public List<GenreShowDto> getGenreList() {
        return genreService.getGenreList();
    }
}
