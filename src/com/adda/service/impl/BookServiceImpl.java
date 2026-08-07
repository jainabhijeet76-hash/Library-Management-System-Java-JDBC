package com.adda.service.impl;

import java.util.List;

import com.adda.dao.BookDAO;
import com.adda.dao.impl.BookDAOImpl;
import com.adda.model.Book;
import com.adda.service.BookService;

public class BookServiceImpl implements BookService 
{

	private BookDAO bookDAO = new BookDAOImpl();

	@Override
	public void addBook(Book book)
	{

		if (book.getCopiesTotal() < 0)
		{

			System.out.println("Invalid Copies");

			return;
		}

		bookDAO.addBook(book);
	}

	@Override
	public void updateBook(Book book)
	{

		Book existingBook = bookDAO.getBookById(book.getBookId());

		if (existingBook == null)
		{

			System.out.println("Book Not Found");

			return;
		}

		bookDAO.updateBook(book);
	}

	@Override
	public void deleteBook(int bookId) 
	{

		Book book = bookDAO.getBookById(bookId);

		if (book == null) 
		{

			System.out.println("Book Not Found");

			return;
		}

		bookDAO.deleteBook(bookId);
	}

	@Override
	public Book getBookById(int bookId) 
	{

		return bookDAO.getBookById(bookId);
	}

	@Override
	public List<Book> getAllBooks() 
	{

		return bookDAO.getAllBooks();
	}
}