package com.bookstore.bookstore.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="MyBooks")
@AllArgsConstructor
@NoArgsConstructor
public class MyBookList {
    @Id
    @Column(name = "book_id")
    private int id;
    private String name;
    private String author;
    private String price;
}
