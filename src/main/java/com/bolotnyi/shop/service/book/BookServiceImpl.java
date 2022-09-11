package com.bolotnyi.shop.service.book;

import com.bolotnyi.shop.model.author.Author;
import com.bolotnyi.shop.model.book.Book;
import com.bolotnyi.shop.model.book.BookGenreLink;
import com.bolotnyi.shop.model.book.dto.BookCreateDto;
import com.bolotnyi.shop.model.exception.BusinessException;
import com.bolotnyi.shop.repository.author.AuthorRepository;
import com.bolotnyi.shop.repository.book.BookGenreLinkRepository;
import com.bolotnyi.shop.repository.book.BookRepository;
import com.bolotnyi.shop.repository.genre.GenreRepository;
import com.bolotnyi.shop.utils.DateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;
    private final BookGenreLinkRepository linkRepository;

    @Override
    public void addNewBook(BookCreateDto createDto) {
        Book book = new Book();
        book.setTitle(createDto.getTitle());
        book.setPublishDate(getPublishDate(createDto.getPublishDate()));
        book.setAuthor(getAuthor(createDto.getAuthorId()));
        bookRepository.save(book);
        createBookGenreLinks(book, createDto.getGenresList());
    }

    private Author getAuthor(Long authorId) {
        return authorRepository.findById(authorId)
                .orElseThrow(() -> new BusinessException("Автор с айди " + authorId + " не найден"));
    }

    private Date getPublishDate(String title) {
        return DateUtils.getDateByString(title);
    }

    private void createBookGenreLinks(Book book, List<Long> genresNameList) {
        genreRepository.getGenresByName(genresNameList)
                .forEach(genre -> {
                    BookGenreLink link = new BookGenreLink();
                    link.setBook(book);
                    link.setGenre(genre);
                    linkRepository.save(link);
                });
    }
}
