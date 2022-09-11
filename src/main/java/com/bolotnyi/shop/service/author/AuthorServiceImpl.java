package com.bolotnyi.shop.service.author;

import com.bolotnyi.shop.model.author.Author;
import com.bolotnyi.shop.model.author.dto.AuthorCreateDto;
import com.bolotnyi.shop.model.author.dto.AuthorShowDto;
import com.bolotnyi.shop.repository.author.AuthorCustomRepository;
import com.bolotnyi.shop.repository.author.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorCustomRepository authorCustomRepository;

    @Override
    public void addNewAuthor(AuthorCreateDto createDto) {
        Author author = new Author();
        author.setName(createDto.getName());
        author.setSecondName(createDto.getSecondName());
        author.setPatronymic(createDto.getPatronymic());
        author.setNmFull(getAuthorNmFull(createDto));
        authorRepository.save(author);
    }

    @Override
    public List<AuthorShowDto> getAuthorShowDtoList(String name) {
        return createDtoByEntity(authorCustomRepository.getAuthorByName(name));
    }

    private List<AuthorShowDto> createDtoByEntity(List<Author> authorList) {
        return authorList.stream()
                .map(i -> {
                    AuthorShowDto authorShowDto = new AuthorShowDto();
                    authorShowDto.setId(i.getId());
                    authorShowDto.setNmFull(i.getNmFull());
                    return authorShowDto;
                })
                .collect(Collectors.toList());
    }

    private String getAuthorNmFull(AuthorCreateDto createDto) {
        return createDto.getName() +
                " " +
                createDto.getSecondName() +
                " " +
                createDto.getPatronymic();
    }
}
