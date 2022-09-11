package com.bolotnyi.shop.model.author;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "author_table")
@Getter
@Setter
public class Author {

    @Column(name = "id", columnDefinition = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", columnDefinition = "имя")
    private String name;

    @Column(name = "second_name", columnDefinition = "фамилия")
    private String secondName;

    @Column(name = "patronymic", columnDefinition = "отчество")
    private String patronymic;

    @Column(name = "nm_full", columnDefinition = "Полное имя")
    private String nmFull;

}
