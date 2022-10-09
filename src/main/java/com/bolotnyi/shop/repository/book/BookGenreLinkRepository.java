package com.bolotnyi.shop.repository.book;

import com.bolotnyi.shop.model.book_genre_link.BookGenreLink;
import org.springframework.data.repository.CrudRepository;

public interface BookGenreLinkRepository extends CrudRepository<BookGenreLink, Long> {
}
