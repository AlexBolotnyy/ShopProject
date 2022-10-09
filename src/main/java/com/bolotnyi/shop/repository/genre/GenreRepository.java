package com.bolotnyi.shop.repository.genre;

import com.bolotnyi.shop.model.genre.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre, Long> {

    @Query(" select g from Genre g"
            + " where g.id in (:genreIdList)")
    List<Genre> getGenresById(List<Long> genreIdList);
}
