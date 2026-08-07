package com.adda.service;

import java.util.List;
import com.adda.model.Book;

public interface BookService
{

    void addBook(Book book);

    void updateBook(Book book);

    void deleteBook(int bookId);

    Book getBookById(int bookId);

    List<Book> getAllBooks();
}