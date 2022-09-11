package com.bolotnyi.shop.repository.author;

import com.bolotnyi.shop.model.author.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    Optional<Author> findById(Long id);
}
