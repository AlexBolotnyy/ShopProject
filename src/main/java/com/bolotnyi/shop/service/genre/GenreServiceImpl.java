package com.bolotnyi.shop.service.genre;

import com.bolotnyi.shop.model.genre.Genre;
import com.bolotnyi.shop.model.genre.dto.GenreShowDto;
import com.bolotnyi.shop.repository.genre.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    @Override
    public void addNewGenre(String title) {
        Genre genre = new Genre();
        genre.setName(title);
        genreRepository.save(genre);
    }

    @Override
    public List<GenreShowDto> getGenreList() {
        return genreRepository.findAll().stream()
                .map(i ->
                        GenreShowDto.builder()
                                .id(i.getId())
                                .title(i.getName())
                                .build()
                )
                .collect(Collectors.toList());
    }
}
