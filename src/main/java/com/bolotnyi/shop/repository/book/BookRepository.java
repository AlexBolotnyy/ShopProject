package com.bolotnyi.shop.repository.book;

import com.bolotnyi.shop.model.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(" select b from Book b "
    + " where upper(b.title) = :title ")
    Optional<Book> findByTitle(String title);
}
