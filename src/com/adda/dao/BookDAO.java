package com.adda.dao;

import java.util.List;
import com.adda.model.Book;

public interface BookDAO 
{

    void addBook(Book book);

    void updateBook(Book book);

    void deleteBook(int bookId);

    Book getBookById(int bookId);

    List<Book> getAllBooks();
}