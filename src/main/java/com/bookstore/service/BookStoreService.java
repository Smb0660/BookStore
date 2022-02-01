package com.bookstore.service;

import com.bookstore.model.Book;
import com.bookstore.repository.BookStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Smbat Bulghadaryan
 **/

@Service
public class BookStoreService {
    @Autowired
    private BookStoreRepository bookStoreRepository;

    public List<Book> getAllBooks() {
        return bookStoreRepository.getAllBooks();
    }

    public Book getBookById(long id) {
        return bookStoreRepository.getBookById(id);
    }

    public void deleteBookById(long id) {
        bookStoreRepository.deleteBookById(id);
    }

    public Book addBook(Book book) {
        bookStoreRepository.addBook(book);
        return book;
    }

    public void updateBook(long id, Book book) {
        bookStoreRepository.updateBook(id, book);

    }


}
