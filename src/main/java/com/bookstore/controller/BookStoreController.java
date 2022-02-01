package com.bookstore.controller;

import com.bookstore.model.Book;
import com.bookstore.service.BookStoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * @author Smbat Bulghadaryan
 **/

@RestController
@RequestMapping("/")
public class BookStoreController {
    @Autowired
    private BookStoreService bookStoreService;

    @Operation(summary = " Get all books ")

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookStoreService.getAllBooks();
    }

    @Operation(summary = "Get a book by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the book",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Book not found",
                    content = @Content) })
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable long id){
         Book matchingBook =  bookStoreService.getBookById(id);
         return new ResponseEntity<>(matchingBook,HttpStatus.OK);
    }

    @Operation(summary = "Add book to store")
    @PostMapping("/books")
    public ResponseEntity<Book>  addBook(@RequestBody Book book){
        bookStoreService.addBook(book);
        return new ResponseEntity<>(book,HttpStatus.CREATED);

    }
    @Operation(summary = "Update books information by its ID")
    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable long id,@RequestBody Book book){
         bookStoreService.updateBook(id, book);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @Operation(summary = "Delete book by it`s ID")
    @DeleteMapping("/books/{id}")
    public ResponseEntity<Book> deleteBookById(@PathVariable long id){
        bookStoreService.deleteBookById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
