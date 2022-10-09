package com.bolotnyi.shop.model.book_purchase_link;

import com.bolotnyi.shop.model.book.Book;
import com.bolotnyi.shop.model.purshase.Purchase;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "book_purchase_link")
public class BookPurchaseLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase_id")
    private Purchase genre;
}
