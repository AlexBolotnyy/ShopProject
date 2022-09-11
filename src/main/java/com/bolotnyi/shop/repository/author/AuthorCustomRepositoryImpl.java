package com.bolotnyi.shop.repository.author;

import com.bolotnyi.shop.model.author.Author;
import com.bolotnyi.shop.model.author.Author_;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AuthorCustomRepositoryImpl implements AuthorCustomRepository {

    @PersistenceContext
    private final EntityManager em;

    @Override
    public List<Author> getAuthorByName(String name) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Author> criteriaQuery = builder.createQuery(Author.class);
        Root<Author> root = criteriaQuery.from(Author.class);
        Predicate predicate = getPredicate(name, builder, root);
        criteriaQuery.select(root).where(predicate);
        return em.createQuery(criteriaQuery).getResultList();
    }

    private Predicate getPredicate(String name,
                                   CriteriaBuilder builder,
                                   Root<Author> root) {

        return builder.like(builder.upper(root.get(Author_.NM_FULL)),
                "%" + Optional.ofNullable(name).map(String::toUpperCase).orElse(" ") + "%");
    }

}
