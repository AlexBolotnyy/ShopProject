package com.bolotnyi.shop.repository.author;

import com.bolotnyi.shop.model.author.Author;

import java.util.List;

public interface AuthorCustomRepository {

    List<Author> getAuthorByName(String name);
}
