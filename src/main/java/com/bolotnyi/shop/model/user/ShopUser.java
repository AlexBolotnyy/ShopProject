package com.bolotnyi.shop.model.user;


import com.bolotnyi.shop.model.book.Book;
import com.bolotnyi.shop.model.purshase.Purchase;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "shop_user")
public class ShopUser {

    @Column(name = "id", columnDefinition = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login", columnDefinition = "логин")
    private String login;

    @Column(name = "password", columnDefinition = "пароль")
    private String password;

    @Column(name = "role", columnDefinition = "роль")
    private String role;

    @Column(name = "name", columnDefinition = "имя")
    private String name;

    @Column(name = "second_name", columnDefinition = "фамилия")
    private String secondName;

    @Column(name = "email", columnDefinition = "email")
    private String email;

    @Column(name = "phone", columnDefinition = "номер телефона")
    private String phone;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "basket_table",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> basket = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Purchase> purchaseList = new ArrayList<>();

    public void insertBookIntoBasket(Book book) {
        this.basket.add(book);
    }

    public void insertPurchase(Purchase purchase) {
        this.purchaseList.add(purchase);
    }

    public void removeBookFromBasket(Book book) {
        this.basket.remove(book);
    }

    public void clearBasket() {
        this.basket.clear();
    }
}
