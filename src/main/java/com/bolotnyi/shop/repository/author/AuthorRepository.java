package com.bolotnyi.shop.repository.author;

import com.bolotnyi.shop.model.author.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Author> findById(Long id);
}
