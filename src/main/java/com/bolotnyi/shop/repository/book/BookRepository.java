package com.bolotnyi.shop.repository.book;

import com.bolotnyi.shop.model.book.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
