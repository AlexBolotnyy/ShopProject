package com.bolotnyi.shop.service.book_genre_link;

import com.bolotnyi.shop.model.book.Book;
import com.bolotnyi.shop.model.book_genre_link.BookGenreLink;
import com.bolotnyi.shop.repository.book.BookGenreLinkRepository;
import com.bolotnyi.shop.repository.genre.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookGenreLinkServiceImpl implements BookGenreLinkService {

    private final GenreRepository genreRepository;
    private final BookGenreLinkRepository linkRepository;
 }
