package com.adda.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.adda.dao.BookDAO;
import com.adda.model.Book;
import com.adda.utility.DBConnection;

public class BookDAOImpl implements BookDAO 
{

    @Override
    public void addBook(Book book) 
    {

        try 
        {
            Connection con =  DBConnection.getConnection();

            String query = "insert into books values(?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, book.getBookId());
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getAuthor());
            ps.setString(4, book.getPublisher());
            ps.setInt(5, book.getCopiesTotal());
            ps.setInt(6, book.getCopiesAvailable());

            int rows = ps.executeUpdate();

            if(rows > 0)
            {
                System.out.println("Book Added Successfully");
            }

        } 
        catch(Exception e) 
        {
            e.printStackTrace();
        }
    }

    @Override
    public void updateBook(Book book) 
    {

        try 
        {

            Connection con =  DBConnection.getConnection();

            String query = "update books set title=?,author=?,publisher=?,copies_total=?,copies_available=? where book_id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getPublisher());
            ps.setInt(4, book.getCopiesTotal());
            ps.setInt(5, book.getCopiesAvailable());
            ps.setInt(6, book.getBookId());

            ps.executeUpdate();

            System.out.println("Book Updated");

        } 
        catch(Exception e) 
        {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBook(int bookId) 
    {

        try
        {

            Connection con = DBConnection.getConnection();

            String query = "delete from books where book_id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, bookId);

            ps.executeUpdate();

            System.out.println("Book Deleted");

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
    }

    @Override
    public Book getBookById(int bookId)
    {

        Book book = null;

        try 
        {

            Connection con = DBConnection.getConnection();

            String query = "select * from books where book_id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, bookId);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) 
            {

                book = new Book();

                book.setBookId(rs.getInt("book_id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setPublisher(rs.getString("publisher"));
                book.setCopiesTotal(rs.getInt("copies_total"));
                book.setCopiesAvailable(rs.getInt("copies_available"));
            }

        } 
        catch(Exception e) 
        {
            e.printStackTrace();
        }

        return book;
    }

    @Override
    public List<Book> getAllBooks() 
    {

        List<Book> books = new ArrayList<>();

        try 
        {

            Connection con = DBConnection.getConnection();

            String query = "select * from books";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {

                Book book = new Book();

                book.setBookId(rs.getInt("book_id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setPublisher(rs.getString("publisher"));
                book.setCopiesTotal(rs.getInt("copies_total"));
                book.setCopiesAvailable(rs.getInt("copies_available"));

                books.add(book);
            }

        } 
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return books;
    }
}