package com.bolotnyi.shop.model.book;

import com.bolotnyi.shop.model.author.Author;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "book_table")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "publish_date")
    private Date publishDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="author_id")
    private Author author;


}
