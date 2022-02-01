package com.bookstore.model;

import lombok.*;


/**
 * @author Smbat Bulghadaryan
 **/


@Getter
@Setter
public class Book {
    private  long id;
    private static long previousId;
    private String bookName;
    private String author;
    private int price;

    public Book(String bookName, String author, int price) {
        increment();
        this.id = previousId;
        this.bookName = bookName;
        this.author = author;
        this.price = price;
    }

    private void increment() {
        previousId++;
    }

    @Override
    public String toString() {
        return "Book{" +
                id + "====" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
