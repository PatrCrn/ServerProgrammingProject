package com.example.Bookstore.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class Trade {
    @Id
    private String isbn;

    private String title;
    private String author;
    private int year;
    private double price;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonManagedReference
    public Stock category;

    public Trade() {}

    public Trade(String isbn, String title, String author, int year, double price, Stock stock) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
        this.category = stock;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getIsbn() {
        return isbn;
    }

    public double getPrice() {
        return price;
    }

    public Stock getCategory() {
        return category;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(Stock stock) {
        this.category = stock;
    }

    @Override
    public String toString() {
        return "ISBN : " + isbn + ", '" + title + "'" +
                ", made by '" + author + '\'' +
                ", in " + year + ". Price : " + price + '.' +
                " Category : " + category;
    }
}
