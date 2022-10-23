package com.bolotnyi.shop.repository.author;

import com.bolotnyi.shop.model.author.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AuthorRepositoryTest {
    @Autowired
    private AuthorRepository repository;

    @Test
    void givenId_whenFindThenReturnsAnimal() {
        Author author = new Author();
        assertNull(author.getId());
        repository.save(author);
        assertNotNull(author.getId());
    }

    @Test
    void count() {
        Long count = repository.count();
        assertEquals(0L, count);
    }
}