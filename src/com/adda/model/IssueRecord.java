package com.adda.model;

import java.time.LocalDate;

public class IssueRecord 
{

    private int recordId;
    private int bookId;
    private int memberId;
    private LocalDate issueDate;
    private LocalDate returnDate;

    public IssueRecord() 
    {
    }

    public IssueRecord(int recordId,
                       int bookId,
                       int memberId,
                       LocalDate issueDate,
                       LocalDate returnDate) {

        this.recordId = recordId;
        this.bookId = bookId;
        this.memberId = memberId;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}