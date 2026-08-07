package com.adda.model;

public class Book 
{

    private int bookId;
    private String title;
    private String author;
    private String publisher;
    private int copiesTotal;
    private int copiesAvailable;

    public Book() 
    {
    }

    public Book(int bookId, String title, String author,
                String publisher, int copiesTotal,
                int copiesAvailable) {

        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.copiesTotal = copiesTotal;
        this.copiesAvailable = copiesAvailable;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getCopiesTotal() {
        return copiesTotal;
    }

    public void setCopiesTotal(int copiesTotal) {
        this.copiesTotal = copiesTotal;
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public void setCopiesAvailable(int copiesAvailable) {
        this.copiesAvailable = copiesAvailable;
    }

    @Override
    public String toString() {
        return bookId + " | " + title + " | " + author +
                " | " + publisher + " | " +
                copiesAvailable + "/" + copiesTotal;
    }
}