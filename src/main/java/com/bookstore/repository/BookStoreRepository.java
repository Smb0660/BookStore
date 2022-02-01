package com.bookstore.repository;

import com.bookstore.model.Book;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * @author Smbat Bulghadaryan
 **/
@Repository
public class BookStoreRepository {

    private  Map<Long, Book> bookList;

    {

        bookList = new HashMap<>();
        bookList.put(1L, new Book(" Don Quixote", " Miguel de Cervantes", 4200));
        bookList.put(2L, new Book(" The Great Gatsby", "F. Scott Fitzgerald", 2500));
        bookList.put(3L, new Book(" War and Peace", "Leo Tolstoy", 1230));

    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(bookList.values());
    }

    public Book getBookById(long id) {
        return bookList.get(id);
    }

    public void deleteBookById(long id) {
        bookList.remove(id);
    }

    public Book addBook(Book book) {
        bookList.put(book.getId(), book);
        return book;
    }

    public void updateBook(long id, Book book) {
        book.setId(id);
        bookList.put(id, book);
    }


}


