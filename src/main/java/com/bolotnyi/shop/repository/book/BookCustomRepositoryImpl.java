package com.bolotnyi.shop.repository.book;

import com.bolotnyi.shop.model.author.Author;
import com.bolotnyi.shop.model.author.Author_;
import com.bolotnyi.shop.model.book.Book;
import com.bolotnyi.shop.model.book.Book_;
import com.bolotnyi.shop.model.book.dto.BookFilterDto;
import com.bolotnyi.shop.model.genre.Genre;
import com.bolotnyi.shop.model.genre.Genre_;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BookCustomRepositoryImpl implements BookCustomRepository {

    @PersistenceContext
    private final EntityManager em;

    @Override
    public List<Book> getListByFilter(BookFilterDto filterDto) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = builder.createQuery(Book.class);
        createQuery(filterDto, builder, criteriaQuery);
        return em.createQuery(criteriaQuery)
                .setHint("javax.persistence.fetchgraph", getEntityGraps())
                .getResultList();
    }

    private void createQuery(BookFilterDto filterDto,
                             CriteriaBuilder builder,
                             CriteriaQuery<Book> criteriaQuery) {

        Root<Book> root = criteriaQuery.from(Book.class);
        Join<Book, Author> authorJoin = root.join(Book_.AUTHOR);
        Join<Book, Genre> genreJoin = root.join(Book_.GENRE_LIST);


        List<Predicate> predicates = new ArrayList<>();
//        private Date publishDate;
        Optional.ofNullable(filterDto.getTitle())
                .ifPresent(i -> predicates.add(builder.like(builder.upper(root.get(Book_.TITLE)),
                        "%" + i.toUpperCase() + "%")));
        Optional.ofNullable(filterDto.getAvailability())
                .ifPresent(i -> predicates.add(builder.greaterThan(root.get(Book_.AMOUNT), 0)));
        Optional.ofNullable(filterDto.getAuthorName())
                .ifPresent(i -> predicates.add(builder.like(builder.upper(authorJoin.get(Author_.NM_FULL)),
                        "%" + i.toUpperCase() + "%")));
        Optional.ofNullable(filterDto.getGenre())
                .ifPresent(i -> predicates.add(builder.in(genreJoin.get(Genre_.ID)).value(i)));
        Optional.ofNullable(filterDto.getPublishDate())
                .ifPresent(i -> predicates.add(builder.greaterThan(root.get(Book_.PUBLISH_DATE), i)));
        buildQuery(criteriaQuery, root, predicates, builder);
    }

    private void buildQuery(CriteriaQuery<Book> criteriaQuery,
                            Root<Book> root,
                            List<Predicate> predicates,
                            CriteriaBuilder builder) {
        criteriaQuery.select(root)
                .where(builder.and(predicates.toArray(new Predicate[0])))
                .distinct(true);
    }

    private EntityGraph<Book> getEntityGraps() {
        EntityGraph<Book> rootGraph = em.createEntityGraph(Book.class);
        rootGraph.addSubgraph(Book_.AUTHOR);
        return rootGraph;
    }
}
